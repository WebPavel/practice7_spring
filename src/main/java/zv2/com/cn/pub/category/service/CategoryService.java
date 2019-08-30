package zv2.com.cn.pub.category.service;

import org.springframework.transaction.annotation.Transactional;
import zv2.com.cn.common.util.PageBean;
import zv2.com.cn.pub.category.dao.CategoryDao;
import zv2.com.cn.pub.category.entity.Category;

import java.util.List;

/**
 * @author lb
 * @date 2019/8/14 0:45
 */
@Transactional
public class CategoryService {
    private CategoryDao categoryDao;

    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public List<Category> list() {
        return categoryDao.list();
    }

    public PageBean<Category> list(int pageIndex, int pageSize) {
        PageBean<Category> categoryPageBean = new PageBean<>();
        categoryPageBean.setPageIndex(pageIndex);
        categoryPageBean.setPageSize(pageSize);
        // 查询总记录数
        int totalRecord = categoryDao.count();
        categoryPageBean.setTotalRecord(totalRecord);
        int firstResult = (pageIndex-1) * pageSize;
        List<Category> categoryList = categoryDao.list(firstResult, pageSize);
        categoryPageBean.setList(categoryList);
        return categoryPageBean;
    }

    public void create(Category category) {
        categoryDao.save(category);
    }

    public void delete(Category category) {
        categoryDao.delete(category);
    }

    public Category get(Long id) {
        return categoryDao.get(id);
    }

    public void update(Category category) {
        categoryDao.update(category);
    }

    public PageBean<Category> queryByCondition(Category category, int pageIndex, int pageSize) {
        PageBean<Category> categoryPageBean = new PageBean<>();
        categoryPageBean.setPageIndex(pageIndex);
        categoryPageBean.setPageSize(pageSize);
        // 查询总记录数
        int totalRecord = categoryDao.countByCondition(category);
        categoryPageBean.setTotalRecord(totalRecord);
        int firstResult = (pageIndex-1) * pageSize;
        List<Category> categoryList = categoryDao.listByCondition(category, firstResult, pageSize);
        categoryPageBean.setList(categoryList);
        return categoryPageBean;
    }
}
