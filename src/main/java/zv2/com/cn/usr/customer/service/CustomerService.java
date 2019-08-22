package zv2.com.cn.usr.customer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import zv2.com.cn.common.factory.InstanceFactory;
import zv2.com.cn.common.util.MailUtils;
import zv2.com.cn.common.util.StringUtils;
import zv2.com.cn.usr.customer.dao.CustomerDao;
import zv2.com.cn.usr.customer.entity.Customer;

import java.util.Date;

/**
 * @author lb
 * @date 2019/5/27
 */
@Transactional
public class CustomerService {
    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);
    // 注入DAO
    private CustomerDao customerDao;

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    /**
     * 注册用户
     * @param customer
     */
    public void register(Customer customer) {
        // 保存用户
        customer.setState(0);
        customer.setGmtCreate(new Date());
        customer.setGmtModified(new Date());
        String activationCode = StringUtils.randomNumStr(4);
        System.out.println(new Date() + "generate activation code: " + activationCode);
        customer.setActivationCode(activationCode);
        customerDao.save(customer);
        // TODO 发送激活邮件
        InstanceFactory.cachedThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("send activate email...start");
                try {
                    MailUtils.sendMail(customer.getEmail(), activationCode);
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.error("send activate mail...failed", e);
                }
                System.out.println("send activate email...end");
            }
        });
    }

    public Customer findByActivationCode(String activationCode) {
        return customerDao.findByActivationCode(activationCode);
    }

    public void update(Customer customer) {
        customerDao.update(customer);
    }

    public Customer login(Customer customer) {
        return customerDao.findByUsernameAndPwd(customer);
    }

    public Customer findByUsername(String username) {
        return customerDao.findByUsername(username);
    }
}
