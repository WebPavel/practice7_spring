package zv2.com.cn.biz.order.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import zv2.com.cn.biz.cart.entity.Cart;
import zv2.com.cn.biz.cart.entity.CartItem;
import zv2.com.cn.biz.cart.service.CartService;
import zv2.com.cn.biz.order.entity.Order;
import zv2.com.cn.biz.order.entity.OrderItem;
import zv2.com.cn.biz.order.service.OrderService;
import zv2.com.cn.common.util.PageBean;
import zv2.com.cn.common.util.UUIDUtils;
import zv2.com.cn.pub.category.entity.Category;
import zv2.com.cn.pub.category.service.CategoryService;
import zv2.com.cn.thirdparty.alipay.AlipayClientHelper;
import zv2.com.cn.thirdparty.alipay.request.PayRequest;
import zv2.com.cn.thirdparty.alipay.response.PayResponse;
import zv2.com.cn.usr.customer.entity.Customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author lb
 * @date 2019/8/18 23:48
 */
public class OrderAction extends ActionSupport implements ModelDriven<Order> {
    private static final String CHARSET = "UTF-8";
    private Order order = new Order();
    private String payChannel;
    private PayResponse payResponse;
    private int pageIndex;
    private int pageSize;
    private PageBean<Order> orderPageBean;
    private OrderService orderService;
    private CategoryService categoryService;
    private CartService cartService;

    @Override
    public Order getModel() {
        return order;
    }

    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel;
    }

    public PayResponse getPayResponse() {
        return payResponse;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public PageBean<Order> getOrderPageBean() {
        return orderPageBean;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public void setCartService(CartService cartService) {
        this.cartService = cartService;
    }

    public String create() {
        List<Category> categoryList = categoryService.list();
        ActionContext.getContext().getValueStack().set("categoryList", categoryList);

        HttpServletRequest request = ServletActionContext.getRequest();
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        if (customer == null) {
            this.addActionMessage("您还未登录，请先去登录！");
            return "createInput";
        }
        order.setAddress(customer.getAddress());
        order.setTelephone(customer.getTelephone());
        order.setConsignee(customer.getUsername());
        order.setCustomer(customer);
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) {
            this.addActionMessage("您还未购买任何商品，请先去挑选您中意的宝贝！");
            return "createInput";
        }
        BigDecimal weight = new BigDecimal(0);
        Collection<CartItem> cartItemCollection = cart.getCartItemCollection();
        for (CartItem cartItem : cartItemCollection) {
            OrderItem orderItem = new OrderItem();
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setPrice(cartItem.getPrice());
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setOrder(order);
            order.getOrderItemSet().add(orderItem);
            weight = weight.add(cartItem.getProduct().getWeight().multiply(new BigDecimal(cartItem.getQuantity())));
        }
        BigDecimal freight = new BigDecimal(0);
        String sn = UUIDUtils.generate();
        order.setGmtCreate(new Date());
        order.setWeight(weight);
        order.setFreight(freight);
        order.setPrice(cart.getPrice());
        order.setSn(sn);
        order.setStatus(1);
        order.setGmtModified(new Date());
        Long orderId = orderService.save(order);
        order = orderService.get(orderId);
        // 清空购物车
        cartService.clear(cart);
        return "createSuccess";
    }

    public String goPay() throws IOException {
        // 1.更新订单收货地址等
        Order currOrder = orderService.get(order.getId());
        currOrder.setAddress(order.getAddress());
        currOrder.setTelephone(order.getTelephone());
        currOrder.setConsignee(order.getConsignee());
        orderService.update(currOrder);
        // 2.付款
        if ("alipay".equals(payChannel)) {
            PayRequest payRequest = new PayRequest();
            payRequest.setOut_trade_no(currOrder.getSn());
            payRequest.setTotal_amount(currOrder.getPrice()!=null?currOrder.getPrice().toPlainString():"0.01");
            payRequest.setSubject(String.valueOf(currOrder.getId()));
            payRequest.setBody("");
            String result = AlipayClientHelper.pay(payRequest);
            HttpServletResponse response = ServletActionContext.getResponse();
            response.setContentType("text/html;charset=" + CHARSET);
            response.getWriter().write(result);
            response.getWriter().flush();
            response.getWriter().close();
        }
        return NONE;
    }

    public String callback() throws UnsupportedEncodingException {
        payResponse = AlipayClientHelper.callback(ServletActionContext.getRequest());
        Order currOrder = orderService.getBySn(payResponse.getOut_trade_no());
        currOrder.setStatus(3);
        orderService.update(currOrder);
        return "callbackSuccess";
    }

    public String listByCustomer() {
        List<Category> categoryList = categoryService.list();
        ActionContext.getContext().getValueStack().set("categoryList", categoryList);

        Customer currCustomer = (Customer) ServletActionContext.getRequest().getSession().getAttribute("customer");
        orderPageBean = orderService.listByCustomer(currCustomer, pageIndex, pageSize);
        return "listByCustomerSuccess";
    }

    public String get() {
        order = orderService.get(order.getId());
        return "getSuccess";
    }

    public String confirmReceipt() {
        Order currOrder = orderService.get(order.getId());
        currOrder.setStatus(4);
        orderService.update(currOrder);
        this.addActionMessage("亲，恭喜您，交易完成！！！");
        return "confirmReceiptSuccess";
    }

    public String close() {
        Order currOrder = orderService.get(order.getId());
        currOrder.setStatus(5);
        orderService.update(currOrder);
        this.addActionMessage("亲，已为您关闭交易");
        return "closeSuccess";
    }
}
