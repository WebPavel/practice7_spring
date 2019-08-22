package zv2.com.cn.pub.subcategory.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import zv2.com.cn.pub.subcategory.entity.Subcategory;
import zv2.com.cn.pub.subcategory.service.SubcategoryService;

/**
 * @author lb
 * @date 2019/8/16 0:49
 */
public class SubcategoryAction extends ActionSupport implements ModelDriven<Subcategory> {
    private Subcategory subcategory = new Subcategory();
    private SubcategoryService subcategoryService;
    @Override
    public Subcategory getModel() {
        return subcategory;
    }

    public void setSubcategoryService(SubcategoryService subcategoryService) {
        this.subcategoryService = subcategoryService;
    }
}
