package zv2.com.cn.biz.cart.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import zv2.com.cn.biz.cart.entity.Cart;
import zv2.com.cn.biz.cart.entity.CartItem;
import zv2.com.cn.biz.cart.service.CartService;
import zv2.com.cn.biz.product.entity.Product;
import zv2.com.cn.biz.product.service.ProductService;
import zv2.com.cn.pub.category.entity.Category;
import zv2.com.cn.pub.category.service.CategoryService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author lb
 * @date 2019/8/18 3:51
 */
public class CartAction extends ActionSupport {
    private Long productId;
    private Integer quantity;
    private ProductService productService;
    private CartService cartService;
    private CategoryService categoryService;

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public void setCartService(CartService cartService) {
        this.cartService = cartService;
    }

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public String addCartItem() {
        List<Category> categoryList = categoryService.list();
        ActionContext.getContext().getValueStack().set("categoryList", categoryList);

        Product product = productService.get(productId);
        CartItem cartItem = new CartItem();
        cartItem.setQuantity(quantity);
        cartItem.setProduct(product);
        Cart cart = getCart(ServletActionContext.getRequest());
        cartService.addCartItem(cart, cartItem);
        return "addCartItemSuccess";
    }

    public String clear() {
        List<Category> categoryList = categoryService.list();
        ActionContext.getContext().getValueStack().set("categoryList", categoryList);

        Cart cart = getCart(ServletActionContext.getRequest());
        cartService.clear(cart);
        return "clearSuccess";
    }

    public String removeCartItem() {
        List<Category> categoryList = categoryService.list();
        ActionContext.getContext().getValueStack().set("categoryList", categoryList);

        Cart cart = getCart(ServletActionContext.getRequest());
        cartService.removeCartItem(cart, productId);
        return "removeCartItemSuccess";
    }

    public String goCart() {
        List<Category> categoryList = categoryService.list();
        ActionContext.getContext().getValueStack().set("categoryList", categoryList);
        return "goCartSuccess";
    }

    private Cart getCart(HttpServletRequest request) {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }
        return cart;
    }
}
