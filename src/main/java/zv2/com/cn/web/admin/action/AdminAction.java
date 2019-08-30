package zv2.com.cn.web.admin.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author lb
 * @date 2019/8/24 17:08
 */
public class AdminAction extends ActionSupport {
    public String admin() {
        return "adminSuccess";
    }

    public String goTop() {
        return "goTopSuccess";
    }

    public String goLeft() {
        return "goLeftSuccess";
    }

    public String goDisplay() {
        return "goDisplaySuccess";
    }

    public String goBottom() {
        return "goBottomSuccess";
    }
}
