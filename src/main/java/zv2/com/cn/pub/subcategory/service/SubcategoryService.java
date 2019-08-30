package zv2.com.cn.pub.subcategory.service;

import org.springframework.transaction.annotation.Transactional;
import zv2.com.cn.common.util.PageBean;
import zv2.com.cn.pub.subcategory.dao.SubcategoryDao;
import zv2.com.cn.pub.subcategory.entity.Subcategory;

import java.util.List;

/**
 * @author lb
 * @date 2019/8/16 0:49
 */
@Transactional
public class SubcategoryService {
    private SubcategoryDao subcategoryDao;

    public void setSubcategoryDao(SubcategoryDao subcategoryDao) {
        this.subcategoryDao = subcategoryDao;
    }

    public PageBean<Subcategory> list(int pageIndex, int pageSize) {
        PageBean<Subcategory> subcategoryPageBean = new PageBean<>();
        subcategoryPageBean.setPageIndex(pageIndex);
        subcategoryPageBean.setPageSize(pageSize);
        int totalRecord = subcategoryDao.count();
        subcategoryPageBean.setTotalRecord(totalRecord);
        int firstResult = (pageIndex-1) * pageSize;
        List<Subcategory> subcategoryList = subcategoryDao.list(firstResult, pageSize);
        subcategoryPageBean.setList(subcategoryList);
        return subcategoryPageBean;
    }

    public void create(Subcategory subcategory) {
        subcategoryDao.save(subcategory);
    }

    public void delete(Subcategory subcategory) {
        subcategoryDao.delete(subcategory);
    }

    public Subcategory get(Long id) {
        return subcategoryDao.get(id);
    }

    public void update(Subcategory subcategory) {
        subcategoryDao.update(subcategory);
    }

    public PageBean<Subcategory> queryByCondition(Subcategory subcategory, Long categoryId, int pageIndex, int pageSize) {
        PageBean<Subcategory> subcategoryPageBean = new PageBean<>();
        subcategoryPageBean.setPageIndex(pageIndex);
        subcategoryPageBean.setPageSize(pageSize);
        int totalRecord = subcategoryDao.countByCondition(subcategory, categoryId);
        subcategoryPageBean.setTotalRecord(totalRecord);
        int firstResult = (pageIndex-1) * pageSize;
        List<Subcategory> subcategoryList = subcategoryDao.listByCondition(subcategory, categoryId, firstResult, pageSize);
        subcategoryPageBean.setList(subcategoryList);
        return subcategoryPageBean;
    }

    public List<Subcategory> list() {
        return subcategoryDao.list(0, Integer.MAX_VALUE);
    }
}
