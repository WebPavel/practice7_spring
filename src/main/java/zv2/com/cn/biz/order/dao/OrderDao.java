package zv2.com.cn.biz.order.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import zv2.com.cn.biz.order.entity.Order;
import zv2.com.cn.common.util.PageHibernateCallback;
import zv2.com.cn.usr.customer.entity.Customer;

import java.util.List;

/**
 * @author lb
 * @date 2019/8/18 23:48
 */
public class OrderDao extends HibernateDaoSupport {
    public Long save(Order order) {
        return (Long) this.getHibernateTemplate().save(order);
    }

    public Order get(Long id) {
        return this.getHibernateTemplate().get(Order.class, id);
    }

    public void update(Order order) {
        this.getHibernateTemplate().update(order);
    }

    public Order getBySn(String sn) {
        List<Order> list = this.getHibernateTemplate().find("from Order o where o.sn=?", sn);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public Integer countByCustomer(Customer customer) {
        List<Long> list = this.getHibernateTemplate().find("select count(*) from Order o join o.customer c where c.id=?", customer.getId());
        return list.get(0).intValue();
    }

    public List<Order> listByCustomer(Customer customer, int firstResult, int maxResult) {
        return this.getHibernateTemplate().executeFind(new PageHibernateCallback<Order>("from Order o where o.customer.id=?", new Object[]{customer.getId()}, firstResult, maxResult));
    }
}
