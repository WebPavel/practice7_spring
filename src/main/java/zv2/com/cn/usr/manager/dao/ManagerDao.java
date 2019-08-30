package zv2.com.cn.usr.manager.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import zv2.com.cn.usr.manager.entity.Manager;

import java.util.List;

/**
 * @author lb
 * @date 2019/8/24 3:27
 */
public class ManagerDao extends HibernateDaoSupport {
    public Manager getByUsernameAndPwd(Manager manager) {
        List<Manager> managerList = this.getHibernateTemplate().find("from Manager where status=? and username=? and password=?", new Object[]{1, manager.getUsername(), manager.getPassword()});
        if (managerList.size() > 0) {
            return managerList.get(0);
        }
        return null;
    }
}
