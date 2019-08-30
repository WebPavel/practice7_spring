package zv2.com.cn.usr.manager.service;

import org.springframework.transaction.annotation.Transactional;
import zv2.com.cn.usr.manager.dao.ManagerDao;
import zv2.com.cn.usr.manager.entity.Manager;

/**
 * @author lb
 * @date 2019/8/24 3:27
 */
@Transactional
public class ManagerService {
    private ManagerDao managerDao;

    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }

    public Manager login(Manager manager) {
        return managerDao.getByUsernameAndPwd(manager);
    }
}
