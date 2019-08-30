package zv2.com.cn.common.util;

import java.util.List;

/**
 * @author lb
 * @date 2019/8/16 2:36
 */
public class PageBean<T> {
    // 当前页码
    private int pageIndex;
    // 每页记录数
    private int pageSize;
    // 总记录数
    private int totalRecord;
    // 总页数
    private int totalPage;
    private List<T> list;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage() {
        int extPage = ((totalRecord % pageSize) == 0) ? 0 : 1;
        this.totalPage = totalRecord/pageSize + extPage;
        return totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
