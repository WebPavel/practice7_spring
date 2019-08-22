package zv2.com.cn.pub.category.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import zv2.com.cn.pub.category.entity.Category;

import java.util.List;

/**
 * @author lb
 * @date 2019/8/14 0:45
 */
public class CategoryDao extends HibernateDaoSupport {
    public List<Category> list() {
        return this.getHibernateTemplate().find("from Category where status = ? order by sortNumber", 1);
    }
}
