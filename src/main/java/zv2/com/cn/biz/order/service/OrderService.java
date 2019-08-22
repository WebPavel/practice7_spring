package zv2.com.cn.biz.order.service;

import org.springframework.transaction.annotation.Transactional;
import zv2.com.cn.biz.order.dao.OrderDao;
import zv2.com.cn.biz.order.entity.Order;
import zv2.com.cn.common.util.PageBean;
import zv2.com.cn.usr.customer.entity.Customer;

import java.util.List;

/**
 * @author lb
 * @date 2019/8/18 23:48
 */
@Transactional
public class OrderService {
    private OrderDao orderDao;

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public Long save(Order order) {
        return orderDao.save(order);
    }

    public Order get(Long id) {
        return orderDao.get(id);
    }

    public void update(Order order) {
        orderDao.update(order);
    }

    public Order getBySn(String sn) {
        return orderDao.getBySn(sn);
    }

    public PageBean<Order> listByCustomer(Customer customer, int pageIndex, int pageSize) {
        PageBean<Order> orderPageBean = new PageBean<>();
        orderPageBean.setPageIndex(pageIndex);
        orderPageBean.setPageSize(pageSize);
        Integer totalRecord = orderDao.countByCustomer(customer);
        orderPageBean.setTotalRecord(totalRecord);
        orderPageBean.setTotalPage(totalRecord/pageSize + totalRecord%pageSize==0?0:1);
        int firstResult = (pageIndex-1) * pageSize;
        List<Order> orderList = orderDao.listByCustomer(customer, firstResult, pageSize);
        orderPageBean.setList(orderList);
        return orderPageBean;
    }
}
