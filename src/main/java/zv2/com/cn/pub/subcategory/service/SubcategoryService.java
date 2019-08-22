package zv2.com.cn.pub.subcategory.service;

import org.springframework.transaction.annotation.Transactional;
import zv2.com.cn.pub.subcategory.dao.SubcategoryDao;

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
}
