package zv2.com.cn.usr.customer.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author lb
 * @date 2019/5/27
 */
@Data
public class Customer {
    private Long id;
    private String username;
    private String password;
    /**
     * 确认密码
     */
    private String confirmPassword;
    private String telephone;
    private String nickname;
    private String email;
    private String trueName;
    private Integer gender;
    private Date birthday;
    private String region;
    private String address;
    private String postalCode;
    /**
     * 状态(0未激活 1正常 2删除 3停用)
     */
    private Integer state;
    private String activationCode;
    private Date gmtCreate;
    private Date gmtModified;
    private String remark;
}
