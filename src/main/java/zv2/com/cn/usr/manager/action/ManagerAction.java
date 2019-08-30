package zv2.com.cn.usr.manager.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import zv2.com.cn.usr.manager.entity.Manager;
import zv2.com.cn.usr.manager.service.ManagerService;

/**
 * @author lb
 * @date 2019/8/24 3:27
 */
public class ManagerAction extends ActionSupport implements ModelDriven<Manager> {
    private Manager manager = new Manager();
    private ManagerService managerService;

    @Override
    public Manager getModel() {
        return manager;
    }

    public void setManagerService(ManagerService managerService) {
        this.managerService = managerService;
    }

    public String login() {
        Manager currManager = managerService.login(manager);
        if (currManager == null) {
            this.addActionError("用户名或密码错误");
            return "loginInput";
        }
        ServletActionContext.getRequest().getSession().setAttribute("manager", currManager);
        return "loginSuccess";
    }

    public String goIndex() {
        return "goIndexSuccess";
    }

    public String logout() {
        ServletActionContext.getRequest().getSession().invalidate();
        return "logoutSuccess";
    }
}
