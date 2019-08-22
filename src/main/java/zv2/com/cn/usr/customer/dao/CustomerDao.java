package zv2.com.cn.usr.customer.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import zv2.com.cn.usr.customer.entity.Customer;

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
}
