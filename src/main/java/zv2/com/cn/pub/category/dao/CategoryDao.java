package zv2.com.cn.pub.category.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import zv2.com.cn.common.util.PageHibernateCallback;
import zv2.com.cn.common.util.StringUtils;
import zv2.com.cn.pub.category.entity.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lb
 * @date 2019/8/14 0:45
 */
public class CategoryDao extends HibernateDaoSupport {
    public List<Category> list() {
        return this.getHibernateTemplate().find("from Category where status = ? order by sortNumber", 1);
    }

    public int count() {
        List<Long> list = this.getHibernateTemplate().find("select count(*) from Category c where c.status=?", 1);
        return list.get(0).intValue();
    }

    public List<Category> list(int firstResult, int maxResult) {
        return this.getHibernateTemplate().executeFind(new PageHibernateCallback<Category>("select c from Category c where c.status=? order by c.sortNumber,field(c.isHot,1,1,0,2)", new Object[]{1}, firstResult, maxResult));
    }

    public void save(Category category) {
        this.getHibernateTemplate().save(category);
    }

    public void delete(Category category) {
        category = this.getHibernateTemplate().get(Category.class, category.getId());
        this.getHibernateTemplate().delete(category);
    }

    public Category get(Long id) {
        return this.getHibernateTemplate().get(Category.class, id);
    }

    public void update(Category category) {
        this.getHibernateTemplate().update(category);
    }

    public int countByCondition(Category category) {
        String hql = "select count(*) from Category where 1=1 ";
        List<Object> params = new ArrayList<>();
        String name = category.getName();
        if (!StringUtils.isBlank(name)) {
            hql += " and name like ?";
            params.add("%" + name + "%");
        }
        Integer isHot = category.getIsHot();
        if (isHot != null) {
            hql += " and isHot=?";
            params.add(isHot);
        }
        Integer status = category.getStatus();
        if (status != null) {
            hql += " and status=?";
            params.add(status);
        }
        System.out.println(hql);
        List<Long> list = this.getHibernateTemplate().find(hql, params.toArray(new Object[params.size()]));
        return list.get(0).intValue();
    }

    public List<Category> listByCondition(Category category, int firstResult, int maxResult) {
        String hql = "from Category where 1=1 ";
        List<Object> params = new ArrayList<>();
        String name = category.getName();
        if (!StringUtils.isBlank(name)) {
            hql += " and name like ?";
            params.add("%" + name + "%");
        }
        Integer isHot = category.getIsHot();
        if (isHot != null) {
            hql += " and isHot=?";
            params.add(isHot);
        }
        Integer status = category.getStatus();
        if (status != null) {
            hql += " and status=?";
            params.add(status);
        }
        System.out.println(hql);
        List<Category> list = this.getHibernateTemplate().executeFind(new PageHibernateCallback<Category>(hql, params.toArray(new Object[params.size()]), firstResult, maxResult));
        return list;
    }
}
