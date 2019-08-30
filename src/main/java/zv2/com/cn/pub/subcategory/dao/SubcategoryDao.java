package zv2.com.cn.pub.subcategory.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import zv2.com.cn.common.util.PageHibernateCallback;
import zv2.com.cn.common.util.StringUtils;
import zv2.com.cn.pub.subcategory.entity.Subcategory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lb
 * @date 2019/8/16 0:49
 */
public class SubcategoryDao extends HibernateDaoSupport {
    public int count() {
        List<Long> list = this.getHibernateTemplate().find("select count(*) from Subcategory s where s.status=?", 1);
        return list.get(0).intValue();
    }

    public List<Subcategory> list(int firstResult, int maxResult) {
        String hql = "select s from Subcategory s where s.status=? order by s.sortNumber, gmtCreate desc";
        return this.getHibernateTemplate().executeFind(new PageHibernateCallback<Subcategory>(hql, new Object[]{1}, firstResult, maxResult));
    }

    public void save(Subcategory subcategory) {
        this.getHibernateTemplate().save(subcategory);
    }

    public void delete(Subcategory subcategory) {
        this.getHibernateTemplate().delete(subcategory);
    }

    public Subcategory get(Long id) {
        return this.getHibernateTemplate().get(Subcategory.class, id);
    }

    public void update(Subcategory subcategory) {
        this.getHibernateTemplate().update(subcategory);
    }

    public int countByCondition(Subcategory subcategory, Long categoryId) {
        String hql = "select count(*) from Subcategory where 1=1 ";
        List<Object> params = new ArrayList<>();
        String name = subcategory.getName();
        if (!StringUtils.isBlank(name)) {
            hql += " and name like ?";
            params.add("%" + name + "%");
        }
        Integer isHot = subcategory.getIsHot();
        if (isHot != null) {
            hql += " and isHot=?";
            params.add(isHot);
        }
        Integer status = subcategory.getStatus();
        if (status != null) {
            hql += " and status=?";
            params.add(status);
        }
        if (categoryId != null) {
            hql += " and category.id=?";
            params.add(categoryId);
        }
        System.out.println(hql);
        List<Long> list = this.getHibernateTemplate().find(hql, params.toArray(new Object[params.size()]));
        return list.get(0).intValue();
    }

    public List<Subcategory> listByCondition(Subcategory subcategory, Long categoryId, int firstResult, int maxResult) {
        String hql = "select s from Subcategory s where 1=1 ";
        List<Object> params = new ArrayList<>();
        String name = subcategory.getName();
        if (!StringUtils.isBlank(name)) {
            hql += " and s.name like ?";
            params.add("%" + name + "%");
        }
        Integer isHot = subcategory.getIsHot();
        if (isHot != null) {
            hql += " and s.isHot=?";
            params.add(isHot);
        }
        Integer status = subcategory.getStatus();
        if (status != null) {
            hql += " and s.status=?";
            params.add(status);
        }
        if (categoryId != null) {
            hql += " and category.id=?";
            params.add(categoryId);
        }
        System.out.println(hql);
        List<Subcategory> list = this.getHibernateTemplate().executeFind(new PageHibernateCallback<Subcategory>(hql, params.toArray(new Object[params.size()]), firstResult, maxResult));
        return list;
    }
}
