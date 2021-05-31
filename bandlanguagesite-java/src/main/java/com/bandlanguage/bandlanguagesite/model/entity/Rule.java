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
 * 规则的实体类
 *
 * @author xiaov
 * @since 2021-05-31 10:44
 */
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("bls_rule")
public class Rule implements Serializable {

    @TableId(value = "rule_id", type = IdType.AUTO)
    private Long ruleId;

    @TableField(value = "rule")
    private String rule;

    @TableField(value = "chinese_name")
    private String chineseName;

    @TableField(value = "express")
    private String express;

    @TableField(value = "description")
    private String description;

    @TableField(value = "code")
    private String code;

    @TableField(value = "creator_id")
    private Long creatorId;

    @TableField(value = "editor_id")
    private Long editorId;

    @TableField(value = "update_time")
    private Date updateTime;

    @TableField(value = "status")
    private Integer status;
}
