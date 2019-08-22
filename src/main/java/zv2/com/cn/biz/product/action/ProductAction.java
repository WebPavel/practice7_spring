package zv2.com.cn.biz.product.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import zv2.com.cn.biz.product.entity.Product;
import zv2.com.cn.biz.product.service.ProductService;
import zv2.com.cn.common.util.PageBean;
import zv2.com.cn.pub.category.entity.Category;
import zv2.com.cn.pub.category.service.CategoryService;

import java.util.List;

/**
 * @author lb
 * @date 2019/8/15 1:18
 */
public class ProductAction extends ActionSupport implements ModelDriven<Product> {
    private Product product = new Product();
    private Long categoryId;
    private Long subcategoryId;
    private int pageIndex;
    private int pageSize;
    private PageBean<Product> productPageBean;
    private CategoryService categoryService;
    private ProductService productService;

    @Override
    public Product getModel() {
        return product;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public void setSubcategoryId(Long subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public Long getSubcategoryId() {
        return subcategoryId;
    }

    public PageBean<Product> getProductPageBean() {
        return productPageBean;
    }

    public String listByCategory() {
        List<Category> categoryList = categoryService.list();
        ActionContext.getContext().getValueStack().set("categoryList", categoryList);
        // 查询商品列表
        productPageBean = productService.listByCategory(categoryId, pageIndex, pageSize);
        return "listByCategorySuccess";
    }

    public String get() {
        List<Category> categoryList = categoryService.list();
        ActionContext.getContext().getValueStack().set("categoryList", categoryList);
        product = productService.get(product.getId());
        return "getSuccess";
    }

    public String listBySubcategory() {
        List<Category> categoryList = categoryService.list();
        ActionContext.getContext().getValueStack().set("categoryList", categoryList);
        productPageBean = productService.listBySubcategory(subcategoryId, pageIndex, pageSize);
        return "listBySubcategorySuccess";
    }

    public String goListHotProduct() {
        List<Category> categoryList = categoryService.list();
        ActionContext.getContext().getValueStack().set("categoryList", categoryList);
        productPageBean = productService.listHotProduct(pageIndex, pageSize);
        return "goListHotProductSuccess";
    }

    public String goListNewProduct() {
        List<Category> categoryList = categoryService.list();
        ActionContext.getContext().getValueStack().set("categoryList", categoryList);
        productPageBean = productService.listNewProduct(pageIndex, pageSize);
        return "goListNewProductSuccess";
    }
}
