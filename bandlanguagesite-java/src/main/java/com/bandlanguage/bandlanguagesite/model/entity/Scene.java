package com.bandlanguage.bandlanguagesite.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 场景区实体类
 *
 * @author xiaov
 * @since 2021-05-21 15:10
 */
@Data
@TableName("bls_dept")
public class Scene implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long deptId;

    @TableField(value = "parent_id")
    private Long parentId;

    @TableField(value = "name")
    private String name;

    @TableField(value = "description")
    private String description;

    @TableField(value = "avatar")
    private String avatar;

    @TableField(value = "band_obj_id")
    private Long bandObjId;

    @TableField(value = "create_time")
    private Date createTime;

    @TableField(value = "status")
    private Integer status;
}
