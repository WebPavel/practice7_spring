package zv2.com.cn.web.index.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import zv2.com.cn.biz.product.entity.Product;
import zv2.com.cn.biz.product.service.ProductService;
import zv2.com.cn.pub.category.entity.Category;
import zv2.com.cn.pub.category.service.CategoryService;

import java.util.List;

/**
 * 首页
 * @author lb
 * @date 2019/5/27
 */
public class IndexAction extends ActionSupport {
    private CategoryService categoryService;
    private ProductService productService;
    private List<Product> hotProductList;
    private List<Product> newProductList;

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public List<Product> getHotProductList() {
        return hotProductList;
    }

    public List<Product> getNewProductList() {
        return newProductList;
    }

    public String index() throws Exception {
        List<Category> categoryList = categoryService.list();
        ActionContext.getContext().getValueStack().set("categoryList", categoryList);
        hotProductList = productService.listHotProduct(1, 10).getList();
        newProductList = productService.listNewProduct(1, 10).getList();
        return "indexSuccess";
    }
}
