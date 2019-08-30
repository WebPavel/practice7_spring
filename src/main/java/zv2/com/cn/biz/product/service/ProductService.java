package zv2.com.cn.biz.product.service;

import org.springframework.transaction.annotation.Transactional;
import zv2.com.cn.biz.product.dao.ProductDao;
import zv2.com.cn.biz.product.entity.Product;
import zv2.com.cn.common.util.PageBean;

import java.util.List;

/**
 * @author lb
 * @date 2019/8/15 1:18
 */
@Transactional
public class ProductService {
    private ProductDao productDao;

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public PageBean<Product> listHotProduct(int pageIndex, int pageSize) {
        PageBean<Product> productPageBean = new PageBean<>();
        productPageBean.setPageIndex(pageIndex);
        productPageBean.setPageSize(pageSize);
        // 查询总记录数
        Integer totalRecord = productDao.countByHot();
        productPageBean.setTotalRecord(totalRecord);
        int firstResult = (pageIndex-1)*pageSize;
        List<Product> productList = productDao.findByHot(firstResult, pageSize);
        productPageBean.setList(productList);
        return productPageBean;
    }

    public PageBean<Product> listNewProduct(int pageIndex, int pageSize) {
        PageBean<Product> productPageBean = new PageBean<>();
        productPageBean.setPageIndex(pageIndex);
        productPageBean.setPageSize(pageSize);
        // 查询总记录数
        Integer totalRecord = productDao.countByCreate();
        productPageBean.setTotalRecord(totalRecord);
        int firstResult = (pageIndex-1)*pageSize;
        List<Product> productList = productDao.findByCreate(firstResult, pageSize);
        productPageBean.setList(productList);
        return productPageBean;
    }

    public PageBean<Product> listByCategory(Long categoryId, int pageIndex, int pageSize) {
        PageBean<Product> productPageBean = new PageBean<>();
        productPageBean.setPageIndex(pageIndex);
        productPageBean.setPageSize(pageSize);
        // 查询总记录数
        Integer totalRecord = productDao.countByCategory(categoryId);
        productPageBean.setTotalRecord(totalRecord);
        int firstResult = (pageIndex-1)*pageSize;
        List<Product> productList = productDao.listByCategory(categoryId, firstResult, pageSize);
        productPageBean.setList(productList);
        return productPageBean;
    }

    public Product get(Long id) {
        return productDao.get(id);
    }

    public PageBean<Product> listBySubcategory(Long subcategoryId, int pageIndex, int pageSize) {
        PageBean<Product> productPageBean = new PageBean<>();
        productPageBean.setPageIndex(pageIndex);
        productPageBean.setPageSize(pageSize);
        // 查询总记录数
        Integer totalRecord = productDao.countBySubcategory(subcategoryId);
        productPageBean.setTotalRecord(totalRecord);
        int firstResult = (pageIndex-1)*pageSize;
        List<Product> productList = productDao.listBySubcategory(subcategoryId, firstResult, pageSize);
        productPageBean.setList(productList);
        return productPageBean;
    }

    public void update(Product product) {
        productDao.update(product);
    }

    public PageBean<Product> listByName(String name, int pageIndex, int pageSize) {
        PageBean<Product> productPageBean = new PageBean<>();
        productPageBean.setPageIndex(pageIndex);
        productPageBean.setPageSize(pageSize);
        // 查询总记录数
        Integer totalRecord = productDao.countByName(name);
        productPageBean.setTotalRecord(totalRecord);
        int firstResult = (pageIndex-1)*pageSize;
        List<Product> productList = productDao.listByName(name, firstResult, pageSize);
        productPageBean.setList(productList);
        return productPageBean;
    }

    public PageBean<Product> list(int pageIndex, int pageSize) {
        PageBean<Product> productPageBean = new PageBean<>();
        productPageBean.setPageIndex(pageIndex);
        productPageBean.setPageSize(pageSize);
        // 查询总记录数
        int totalRecord = productDao.count();
        productPageBean.setTotalRecord(totalRecord);
        int firstResult = (pageIndex-1)*pageSize;
        List<Product> productList = productDao.list(firstResult, pageSize);
        productPageBean.setList(productList);
        return productPageBean;
    }

    public void create(Product product) {
        productDao.save(product);
    }

    public void delete(Product product) {
        productDao.delete(product);
    }

    public PageBean<Product> queryByCondition(Product product, Long subcategoryId, int pageIndex, int pageSize) {
        PageBean<Product> productPageBean = new PageBean<>();
        productPageBean.setPageIndex(pageIndex);
        productPageBean.setPageSize(pageSize);
        int totalRecord = productDao.countByCondition(product, subcategoryId);
        productPageBean.setTotalRecord(totalRecord);
        int firstResult = (pageIndex - 1) * pageSize;
        List<Product> productList = productDao.listByCondition(product, subcategoryId, firstResult, pageSize);
        productPageBean.setList(productList);
        return productPageBean;
    }
}
