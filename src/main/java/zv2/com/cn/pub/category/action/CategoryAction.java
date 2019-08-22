package zv2.com.cn.pub.category.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import zv2.com.cn.pub.category.entity.Category;
import zv2.com.cn.pub.category.service.CategoryService;

/**
 * @author lb
 * @date 2019/8/14 0:44
 */
public class CategoryAction extends ActionSupport implements ModelDriven<Category> {
    private Category category = new Category();
    private CategoryService categoryService;

    @Override
    public Category getModel() {
        return category;
    }

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

}
