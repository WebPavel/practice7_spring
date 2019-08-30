package zv2.com.cn.usr.customer.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import org.apache.struts2.ServletActionContext;
import zv2.com.cn.common.util.PageBean;
import zv2.com.cn.usr.customer.entity.Customer;
import zv2.com.cn.usr.customer.service.CustomerService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

/**
 * @author lb
 * @date 2019/5/27
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
    private Customer customer = new Customer();
    // 验证码
    private String captcha;
    // 记住用户名
    private Boolean isRememberUsername;
    private int pageIndex;
    private int pageSize;
    private PageBean<Customer> customerPageBean;
    private CustomerService customerService;
    @Override
    public Customer getModel() {
        return customer;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public void setIsRememberUsername(Boolean isRememberUsername) {
        this.isRememberUsername = isRememberUsername;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public PageBean<Customer> getCustomerPageBean() {
        return customerPageBean;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public String goRegister() {
        return "goRegisterSuccess";
    }

    @InputConfig(resultName = "registerInput")
    public String register() {
        String sessionCaptcha = (String) ServletActionContext.getRequest().getSession().getAttribute("captcha");
        if (!sessionCaptcha.equalsIgnoreCase(captcha)) {
            this.addActionError("验证码错误！");
            return "registerInput";
        }
        customerService.register(customer);
        this.addActionMessage("注册成功！请去邮箱激活账户");
        return "registerSuccess";
    }

    public String activate() {
        String activationCode = customer.getActivationCode();
        Customer existCustomer = customerService.findByActivationCode(activationCode);
        if (existCustomer != null) {
            existCustomer.setState(1);
            customerService.update(existCustomer);
            this.addActionMessage("激活成功！请去登录");
        } else {
            this.addActionMessage("激活失败！激活码错误");
        }
        return "activateSuccess";
    }

    public String goLogin() {
        return "goLoginSuccess";
    }

    @InputConfig(resultName = "loginInput")
    public String login() throws UnsupportedEncodingException {
        String sessionCaptcha = (String) ServletActionContext.getRequest().getSession().getAttribute("captcha");
        if (!sessionCaptcha.equalsIgnoreCase(captcha)) {
            this.addActionError("验证码错误！");
            return "loginInput";
        }
        Customer existCustomer = customerService.login(customer);
        if (existCustomer == null) {
            this.addActionError("用户名或密码错误或用户未激活！");
            return "loginInput";
        } else {
            if (isRememberUsername != null && isRememberUsername) {
                ServletActionContext.getRequest().getSession().setAttribute("customer", existCustomer);
                Cookie cookie = new Cookie("cookieUsername", URLEncoder.encode(existCustomer.getUsername(), "UTF-8"));
                // 有效时间
                cookie.setMaxAge(60*60*24);
                // 有效路径
                cookie.setPath("/");
                ServletActionContext.getResponse().addCookie(cookie);
            }
            ServletActionContext.getRequest().getSession().setAttribute("customer", existCustomer);
            return "loginSuccess";
        }
    }

    public String checkUsername() throws IOException {
        Customer existCustomer = customerService.findByUsername(customer.getUsername());
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
        if (existCustomer == null) {
            response.getWriter().print("<font color='green'>用户名未被占用</font>");
        } else {
            response.getWriter().print("<font color='red'>用户名已被占用</font>");
        }
        return NONE;
    }

    public String logout() {
        ServletActionContext.getRequest().getSession().invalidate();
        return "logoutSuccess";
    }

    public String list() {
        customerPageBean = customerService.list(pageIndex, pageSize);
        return "listSuccess";
    }

    public String selected() {
        customer = customerService.get(customer.getId());
        return "selectedSuccess";
    }

    public String update() {
        customer.setGmtModified(new Date());
        customerService.update(customer);
        return "updateSuccess";
    }

    public String delete() {
        Customer currCustomer = customerService.get(customer.getId());
        currCustomer.setState(2);
        currCustomer.setGmtModified(new Date());
        customerService.update(currCustomer);
        return "deleteSuccess";
    }

    public String listByCondition() {
        customerPageBean = customerService.queryByCondition(customer, pageIndex, pageSize);
        return "listByConditionSuccess";
    }
}
