package com.example.seventhweekhomework.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * user_info
 * @author 
 */
@Data
public class UserInfo implements Serializable {
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 头像
     */
    private String profile;

    /**
     * 说明
     */
    private String note;

    private Date gmtCreate;

    private Date gmtModified;

    private static final long serialVersionUID = 1L;
}