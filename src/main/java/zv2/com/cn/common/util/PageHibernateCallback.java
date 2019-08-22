package zv2.com.cn.common.util;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import java.sql.SQLException;
import java.util.List;

/**
 * @author lb
 * @date 2019/8/15 2:07
 */
public class PageHibernateCallback<T> implements HibernateCallback<List<T>> {
    private String hql;
    private Object[] params;
    private int firstResult;
    private int maxResults;

    public PageHibernateCallback(String hql, Object[] params, int firstResult, int maxResults) {
        this.hql = hql;
        this.params = params;
        this.firstResult = firstResult;
        this.maxResults = maxResults;
    }

    @Override
    public List<T> doInHibernate(Session session) throws HibernateException, SQLException {
        Query query = session.createQuery(hql);
        if (params != null) {
            for (int i=0; i < params.length; i++) {
                query.setParameter(i, params[i]);
            }
        }
        query.setFirstResult(firstResult);
        query.setMaxResults(maxResults);
        return query.list();
    }
}
