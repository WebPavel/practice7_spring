package zv2.com.cn.usr.manager.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author lb
 * @date 2019/8/24 3:23
 */
@Data
public class Manager {
    private Long id;
    private String username;
    private String password;
    private String telephone;
    private String email;
    private Integer gender;
    private Integer status;
    private Date gmtCreate;
    private Date gmtModified;
}
