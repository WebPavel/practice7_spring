package zv2.com.cn.pub.subcategory.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import zv2.com.cn.common.util.PageBean;
import zv2.com.cn.pub.category.entity.Category;
import zv2.com.cn.pub.category.service.CategoryService;
import zv2.com.cn.pub.subcategory.entity.Subcategory;
import zv2.com.cn.pub.subcategory.service.SubcategoryService;

import java.util.Date;
import java.util.List;

/**
 * @author lb
 * @date 2019/8/16 0:49
 */
public class SubcategoryAction extends ActionSupport implements ModelDriven<Subcategory> {
    private Subcategory subcategory = new Subcategory();
    private Long categoryId;
    private int pageIndex;
    private int pageSize;
    private PageBean<Subcategory> subcategoryPageBean;
    private List<Category> categoryList;
    private SubcategoryService subcategoryService;
    private CategoryService categoryService;
    @Override
    public Subcategory getModel() {
        return subcategory;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public PageBean<Subcategory> getSubcategoryPageBean() {
        return subcategoryPageBean;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setSubcategoryService(SubcategoryService subcategoryService) {
        this.subcategoryService = subcategoryService;
    }

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public String list() {
        categoryList = categoryService.list();
        subcategoryPageBean = subcategoryService.list(pageIndex, pageSize);
        return "listSuccess";
    }

    public String goAdd() {
        categoryList = categoryService.list();
        return "goAddSuccess";
    }

    public String add() {
        Category category = categoryService.get(categoryId);
        subcategory.setCategory(category);
        subcategory.setGmtCreate(new Date());
        subcategory.setGmtModified(new Date());
        subcategoryService.create(subcategory);
        return "addSuccess";
    }

    public String delete() {
        subcategoryService.delete(subcategory);
        return "deleteSuccess";
    }

    public String selected() {
        categoryList = categoryService.list();
        subcategory = subcategoryService.get(subcategory.getId());
        return "selectedSuccess";
    }

    public String update() {
        Category category = categoryService.get(categoryId);
        subcategory.setCategory(category);
        subcategory.setGmtModified(new Date());
        subcategoryService.update(subcategory);
        return "updateSuccess";
    }

    public String listByCondition() {
        categoryList = categoryService.list();
        subcategoryPageBean = subcategoryService.queryByCondition(subcategory, categoryId, pageIndex, pageSize);
        return "listByConditionSuccess";
    }
}
