package zv2.com.cn.biz.product.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.util.Assert;
import zv2.com.cn.biz.product.entity.Product;
import zv2.com.cn.biz.product.service.ProductService;
import zv2.com.cn.common.util.ImgUtils;
import zv2.com.cn.common.util.PageBean;
import zv2.com.cn.pub.category.entity.Category;
import zv2.com.cn.pub.category.service.CategoryService;
import zv2.com.cn.pub.subcategory.entity.Subcategory;
import zv2.com.cn.pub.subcategory.service.SubcategoryService;

import java.io.File;
import java.io.IOException;
import java.util.Date;
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
    private String keyword;
    private PageBean<Product> productPageBean;
    private List<Subcategory> subcategoryList;
    // 文件上传须3个属性
    /**
     * 上传文件
     */
    private File upload;
    /**
     * 上传文件的mime类型
     */
    private String uploadContentType;
    /**
     * 上传文件的名称
     */
    private String uploadFileName;
    private CategoryService categoryService;
    private ProductService productService;
    private SubcategoryService subcategoryService;

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

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public void setUploadContentType(String uploadContentType) {
        this.uploadContentType = uploadContentType;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public void setSubcategoryService(SubcategoryService subcategoryService) {
        this.subcategoryService = subcategoryService;
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

    public List<Subcategory> getSubcategoryList() {
        return subcategoryList;
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

    public String search() {
        List<Category> categoryList = categoryService.list();
        ActionContext.getContext().getValueStack().set("categoryList", categoryList);
        productPageBean = productService.listByName(keyword, pageIndex, pageSize);
        return "searchSuccess";
    }

    public String list() {
        subcategoryList = subcategoryService.list();
        productPageBean = productService.list(pageIndex, pageSize);
        return "listSuccess";
    }

    public String goAdd() {
        subcategoryList = subcategoryService.list();
        return "goAddSuccess";
    }

    public String add() throws IOException {
        Subcategory subcategory = subcategoryService.get(subcategoryId);
        Assert.notNull(subcategory, "商品所属二级分类 not null");
        product.setSubcategory(subcategory);
        // 完成文件上传的操作
        // 上传文件保存路径
        final String productImgthumbDir = "/upload/biz/product/imgthumb";
        String absPath = ServletActionContext.getServletContext().getRealPath(productImgthumbDir);
        String realPath = absPath + File.separator + subcategoryId + File.separator + uploadFileName;
        File diskFile = new File(realPath);
        // 文件写入
        FileUtils.copyFile(upload, diskFile);
        // 生成缩略图
        ImgUtils imgUtils = new ImgUtils(diskFile.getCanonicalPath());
        // 生成200*200的缩略图
        imgUtils.resize(200, 200);
        int index = uploadFileName.lastIndexOf(".");
        String suffix = uploadFileName.substring(index);
        String imgThumbnail = uploadFileName.substring(0, index) + "_thumbnail" + suffix;
        product.setImgthumb(productImgthumbDir + File.separator + subcategoryId + File.separator + imgThumbnail);
        // 入库
        product.setGmtCreate(new Date());
        product.setGmtModified(new Date());
        productService.create(product);
        return "addSuccess";
    }

    public String delete() {
        Product currProduct = productService.get(product.getId());
        currProduct.setStatus(0);
        currProduct.setGmtModified(new Date());
        productService.delete(currProduct);
        return "deleteSuccess";
    }

    public String selected() {
        subcategoryList = subcategoryService.list();
        product = productService.get(product.getId());
        return "selectedSuccess";
    }

    public String update() throws IOException {
        Subcategory subcategory = subcategoryService.get(subcategoryId);
        Assert.notNull(subcategory, "商品所属二级分类 not null");
        product.setSubcategory(subcategory);
        Product currProduct = productService.get(product.getId());
        Assert.notNull(currProduct, "找不到商品");
        String oldImgFileName = currProduct.getImgthumb();
        if (!oldImgFileName.equals(product.getImgthumb())) {
            // 完成文件上传的操作
            // 上传文件保存路径
            final String productImgThumbDir = "/upload/biz/product/imgthumb";
            String absPath = ServletActionContext.getServletContext().getRealPath(productImgThumbDir);
            String realPath = absPath + File.separator + subcategoryId + File.separator + uploadFileName;
            File diskFile = new File(realPath);
            // 文件写入
            FileUtils.copyFile(upload, diskFile);
            // 生成缩略图
            ImgUtils imgUtils = new ImgUtils(diskFile.getCanonicalPath());
            // 生成200*200的缩略图
            imgUtils.resize(200, 200);
            int index = uploadFileName.lastIndexOf(".");
            String suffix = uploadFileName.substring(index);
            String imgThumbnail = uploadFileName.substring(0, index) + "_thumbnail" + suffix;
            product.setImgthumb(productImgThumbDir + File.separator + subcategoryId + File.separator + imgThumbnail);
        }
        product.setGmtModified(new Date());
        productService.update(product);
        return "updateSuccess";
    }

    public String listByCondition() {
        subcategoryList = subcategoryService.list();
        productPageBean = productService.queryByCondition(product, subcategoryId, pageIndex, pageSize);
        return "listByConditionSuccess";
    }
}
