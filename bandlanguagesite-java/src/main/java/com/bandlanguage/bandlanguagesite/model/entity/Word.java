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
 * 词的实体类
 *
 * @author xiaov
 * @since 2021-05-21 17:08
 */
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("bls_word")
public class Word implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long wordId;

    @TableField(value = "name")
    private String name;

    @TableField(value = "description")
    private String description;

    @TableField(value = "example")
    private String example;

    @TableField(value = "type")
    private Integer type;

    @TableField(value = "synonym")
    private String synonym;

    @TableField(value = "creator_id")
    private Long creatorId;

    @TableField(value = "editor_id")
    private Long editorId;

    @TableField(value = "update_time")
    private Date updateTime;

    // 是否录入
    @TableField(value = "is_type_in")
    private Integer isTypeIn;

    @TableField(value = "status")
    private Integer status;
}
