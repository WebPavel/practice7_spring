package zv2.com.cn.pub.category.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import zv2.com.cn.common.util.PageBean;
import zv2.com.cn.pub.category.entity.Category;
import zv2.com.cn.pub.category.service.CategoryService;

import java.util.Date;

/**
 * @author lb
 * @date 2019/8/14 0:44
 */
public class CategoryAction extends ActionSupport implements ModelDriven<Category> {
    private Category category = new Category();
    private int pageIndex;
    private int pageSize;
    private PageBean<Category> categoryPageBean;
    private CategoryService categoryService;

    @Override
    public Category getModel() {
        return category;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public PageBean<Category> getCategoryPageBean() {
        return categoryPageBean;
    }

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public String list() {
        categoryPageBean = categoryService.list(pageIndex, pageSize);
        return "listSuccess";
    }

    public String goAdd() {
        return "goAddSuccess";
    }

    public String add() {
        category.setGmtCreate(new Date());
        category.setGmtModified(new Date());
        categoryService.create(category);
        return "addSuccess";
    }

    public String delete() {
        categoryService.delete(category);
        return "deleteSuccess";
    }

    public String selected() {
        category = categoryService.get(category.getId());
        return "selectedSuccess";
    }

    public String update() {
        category.setGmtModified(new Date());
        categoryService.update(category);
        return "updateSuccess";
    }

    public String listByCondition() {
        categoryPageBean = categoryService.queryByCondition(category, pageIndex, pageSize);
        return "listByConditionSuccess";
    }
}
