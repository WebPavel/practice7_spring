package zv2.com.cn.biz.order.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import zv2.com.cn.biz.order.entity.Order;
import zv2.com.cn.common.util.PageHibernateCallback;
import zv2.com.cn.usr.customer.entity.Customer;

import java.util.ArrayList;
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

    public int countByCustomer(Customer customer) {
        List<Long> list = this.getHibernateTemplate().find("select count(*) from Order o join o.customer c where c.id=?", customer.getId());
        return list.get(0).intValue();
    }

    public List<Order> listByCustomer(Customer customer, int firstResult, int maxResult) {
        return this.getHibernateTemplate().executeFind(new PageHibernateCallback<Order>("from Order o where o.customer.id=? order by field(status,1,1,3,2,4,3,2,4,5,5),gmtCreate desc", new Object[]{customer.getId()}, firstResult, maxResult));
    }

    public int countByCustomer(Order order, Long customerId) {
        String hql = "select count(*) from Order where 1=1 ";
        List<Object> params = new ArrayList<>();
        Integer status = order.getStatus();
        if (status != null) {
            hql += " and status=?";
            params.add(status);
        }
        if (customerId != null) {
            hql += " and customer.id=?";
            params.add(customerId);
        }
        System.out.println(hql);
        List<Long> list = this.getHibernateTemplate().find(hql, params.toArray(new Object[params.size()]));
        return list.get(0).intValue();
    }

    public List<Order> listByCustomer(Order order, Long customerId, int firstResult, int maxResult) {
        String hql = "select o from Order o where 1=1 ";
        List<Object> params = new ArrayList<>();
        Integer status = order.getStatus();
        if (status != null) {
            hql += " and o.status=?";
            params.add(status);
        }
        if (customerId != null) {
            hql += " and o.customer.id=?";
            params.add(customerId);
        }
        System.out.println(hql);
        List<Order> list = this.getHibernateTemplate().executeFind(new PageHibernateCallback<Order>(hql, params.toArray(new Object[params.size()]), firstResult, maxResult));
        return list;
    }

    public int count() {
        String hql = "select count(*) from Order";
        List<Long> list = this.getHibernateTemplate().find(hql);
        return list.get(0).intValue();
    }

    public List<Order> list(int firstResult, int maxResult) {
        String hql = "select o from Order o";
        return this.getHibernateTemplate().executeFind(new PageHibernateCallback<Order>(hql, null, firstResult, maxResult));
    }
}
