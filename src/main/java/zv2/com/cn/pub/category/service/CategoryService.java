package zv2.com.cn.pub.category.service;

import org.springframework.transaction.annotation.Transactional;
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
}
