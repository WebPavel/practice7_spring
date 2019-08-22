package zv2.com.cn.biz.product.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import zv2.com.cn.biz.product.entity.Product;
import zv2.com.cn.common.util.PageHibernateCallback;

import java.sql.SQLException;
import java.util.List;

/**
 * @author lb
 * @date 2019/8/15 1:18
 */
public class ProductDao extends HibernateDaoSupport {
    public List<Product> findByHot(int firstResult, int maxResults) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
        criteria.add(Restrictions.eq("isHot", true));
        criteria.add(Restrictions.eq("status", 1));
        criteria.addOrder(Order.desc("sortNumber")).addOrder(Order.desc("gmtCreate"));
        return this.getHibernateTemplate().findByCriteria(criteria, firstResult, maxResults);
    }

    public List<Product> findByCreate(int firstResult, int maxResults) {
        return this.getHibernateTemplate().executeFind(new HibernateCallback<List<Product>>() {
            @Override
            public List<Product> doInHibernate(Session session) throws HibernateException, SQLException {
                String hql = "from Product where status=? order by sortNumber,gmtCreate desc";
                Query query = session.createQuery(hql);
                query.setParameter(0, 1);
                query.setFirstResult(firstResult);
                query.setMaxResults(maxResults);
                return query.list();
            }
        });
    }

    public Integer countByCategory(Long categoryId) {
        List<Long> list = this.getHibernateTemplate().find("select count(*) from Product p, Subcategory s where p.status=? and p.subcategory = s and s.category.id=?", new Object[]{1, categoryId});
//        System.out.println(list.get(0));
        return list.get(0).intValue();
    }

    public List<Product> listByCategory(Long categoryId, int firstResult, int maxResults) {// order by sortNumber,gmtCreate desc
        String hql = "select p from Product p,Subcategory s where p.status=? and p.subcategory = s and s.category.id=? order by p.sortNumber, p.gmtCreate desc";
        return this.getHibernateTemplate().executeFind(new PageHibernateCallback<Product>(hql, new Object[]{1, categoryId}, firstResult, maxResults));
    }

    public Product get(Long id) {
        return this.getHibernateTemplate().get(Product.class, id);
    }

    public Integer countBySubcategory(Long subcategoryId) {
        String hql = "select count(*) from Product p, Subcategory s where p.status=? and p.subcategory = s and s.id=?";
        hql = "select count(*) from Product p join p.subcategory s where p.status=? and s.id=?";
        List<Long> list = this.getHibernateTemplate().find(hql, new Object[]{1, subcategoryId});
        return list.get(0).intValue();
    }

    public List<Product> listBySubcategory(Long subcategoryId, int firstResult, int maxResults) {
        String hql = "select p from Product p join p.subcategory s where p.status=? and s.id=? order by p.sortNumber, p.gmtCreate desc";
        return this.getHibernateTemplate().executeFind(new PageHibernateCallback<Product>(hql, new Object[]{1, subcategoryId}, firstResult, maxResults));
    }

    public void update(Product product) {
        this.getHibernateTemplate().update(product);
    }

    public Integer countByHot() {
        String hql = "select count(*) from Product p where p.isHot=? and status = ?";
        List<Long> list = this.getHibernateTemplate().find(hql, new Object[]{true, 1});
        return list.get(0).intValue();
    }

    public Integer countByCreate() {
        String hql = "select count(*) from Product p where status = ?";
        List<Long> list = this.getHibernateTemplate().find(hql, 1);
        return list.get(0).intValue();
    }
}
