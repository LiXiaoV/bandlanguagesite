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
 * 规则-用户实体类
 * 用于记录参与规则创建或修改的人
 *
 * @author xiaov
 * @since 2021-05-31 11:38
 */
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("bls_rule_user")
public class RuleUser implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "rule_id")
    private Long ruleId;

    @TableField(value = "user_id")
    private Long userId;

    @TableField(value = "update_time")
    private Date updateTime;

    @TableField(value = "status")
    private Integer status;
}
