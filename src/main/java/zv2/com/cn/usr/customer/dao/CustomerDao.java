package zv2.com.cn.usr.customer.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import zv2.com.cn.common.util.PageHibernateCallback;
import zv2.com.cn.common.util.StringUtils;
import zv2.com.cn.usr.customer.entity.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lb
 * @date 2019/5/27
 */
public class CustomerDao extends HibernateDaoSupport {
    public void save(Customer customer) {
        this.getHibernateTemplate().save(customer);
    }

    public Customer findByActivationCode(String activationCode) {
        List<Customer> customerList = this.getHibernateTemplate().find("from Customer where activationCode=?", activationCode);
        if (customerList.size() > 0) {
            return customerList.get(0);
        }
        return null;
    }

    public void update(Customer customer) {
        this.getHibernateTemplate().update(customer);
    }

    public Customer findByUsernameAndPwd(Customer customer) {
        List<Customer> customerList = this.getHibernateTemplate().find("from Customer where username=? and password=? and state=?", customer.getUsername(), customer.getPassword(), 1);
        if (customerList.size() > 0) {
            return customerList.get(0);
        }
        return null;
    }

    public Customer findByUsername(String username) {
        List<Customer> customerList = this.getHibernateTemplate().find("from Customer where username=?", username);
        if (customerList.size() > 0) {
            return customerList.get(0);
        }
        return null;
    }

    public Customer get(Long id) {
        return this.getHibernateTemplate().get(Customer.class, id);
    }

    public int count() {
        String hql = "select count(*) from Customer";
        List<Long> list = this.getHibernateTemplate().find(hql);
        return list.get(0).intValue();
    }

    public List<Customer> list(int firstResult, int maxResult) {
        String hql = "from Customer order by gmtCreate desc";
        return this.getHibernateTemplate().executeFind(new PageHibernateCallback<Customer>(hql, null, firstResult, maxResult));
    }

    public int countByCondition(Customer customer) {
        String hql = "select count(*) from Customer where 1=1 ";
        List<Object> params = new ArrayList<>();
        String username = customer.getUsername();
        if (!StringUtils.isBlank(username)) {
            hql += " and username like ?";
            params.add("%" + username + "%");
        }
        Integer state = customer.getState();
        if (state != null) {
            hql += " and state=?";
            params.add(state);
        }
        System.out.println(hql);
        List<Long> list = this.getHibernateTemplate().find(hql, params.toArray(new Object[params.size()]));
        return list.get(0).intValue();
    }

    public List<Customer> listByCondition(Customer customer, int firstResult, int maxResult) {
        String hql = "from Customer where 1=1 ";
        List<Object> params = new ArrayList<>();
        String username = customer.getUsername();
        if (!StringUtils.isBlank(username)) {
            hql += " and username like ?";
            params.add("%" + username + "%");
        }
        Integer state = customer.getState();
        if (state != null) {
            hql += " and state=?";
            params.add(state);
        }
        System.out.println(hql);
        return this.getHibernateTemplate().executeFind(new PageHibernateCallback<Customer>(hql, params.toArray(new Object[params.size()]), firstResult, maxResult));
    }
}
