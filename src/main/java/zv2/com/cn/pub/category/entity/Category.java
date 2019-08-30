package zv2.com.cn.pub.category.entity;

import zv2.com.cn.pub.subcategory.entity.Subcategory;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author lb
 * @date 2019/8/14 0:32
 */
public class Category {
    private Long id;
    private String name;
    private Integer isHot;
    private Integer status;
    private Integer sortNumber;
    private Date gmtCreate;
    private Date gmtModified;
    private String remark;
    private Set<Subcategory> subcategorySet = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIsHot() {
        return isHot;
    }

    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSortNumber() {
        return sortNumber;
    }

    public void setSortNumber(Integer sortNumber) {
        this.sortNumber = sortNumber;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Set<Subcategory> getSubcategorySet() {
        return subcategorySet;
    }

    public void setSubcategorySet(Set<Subcategory> subcategorySet) {
        this.subcategorySet = subcategorySet;
    }
}
