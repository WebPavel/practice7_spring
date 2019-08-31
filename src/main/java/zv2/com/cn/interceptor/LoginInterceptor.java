package zv2.com.cn.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;
import zv2.com.cn.usr.manager.entity.Manager;

/**
 * @author lb
 * @date 2019/8/31 4:50
 */
public class LoginInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation invocation) throws Exception {
        Manager manager = (Manager) ServletActionContext.getRequest().getSession().getAttribute("manager");
        if (manager != null) {
            return invocation.invoke();
        }
        ActionSupport action = (ActionSupport) invocation.getAction();
        action.addActionError("亲，您还未登录，请先登录");
        return Action.LOGIN;
    }
}
