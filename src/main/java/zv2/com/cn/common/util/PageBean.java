package zv2.com.cn.common.util;

import lombok.Data;

import java.util.List;

/**
 * @author lb
 * @date 2019/8/16 2:36
 */
@Data
public class PageBean<T> {
    // 当前页码
    private Integer pageIndex;
    // 每页记录数
    private Integer pageSize;
    // 总记录数
    private Integer totalRecord;
    // 总页数
    private Integer totalPage;
    private List<T> list;
}
