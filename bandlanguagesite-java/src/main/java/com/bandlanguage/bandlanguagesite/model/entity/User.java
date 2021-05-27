package com.bandlanguage.bandlanguagesite.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体类
 *
 * @author xiaov
 * @since 2021-05-24 16:46
 */
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("bls_user")
public class User implements Serializable {

    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    @TableField(value = "username")
    private String username;

    @TableField(value = "nickname")
    private String nickname;

    @TableField(value = "password")
    private String password;

    @TableField(value = "salt")
    private String salt;

    @TableField(value = "mobile")
    private String mobile;

    @TableField(value = "email")
    private String email;

    @TableField(value = "head")
    private String head;

    @TableField(value = "register_date")
    private Date registerDate;

    @TableField(value = "last_login_date")
    private Date lastLoginDate;

    @TableField(value = "login_count")
    private Integer loginCount;

    @TableField(value = "status")
    private Integer status;
}
