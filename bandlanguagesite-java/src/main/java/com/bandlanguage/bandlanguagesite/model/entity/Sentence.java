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
 * 句的实体类
 *
 * @author xiaov
 * @since 2021-05-21 17:17
 */
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("bls_sentence")
public class Sentence implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long sentenceId;

    @TableField(value = "name")
    private String name;

    @TableField(value = "description")
    private String description;

    // 句型的巴克斯范式表示
    @TableField(value = "paradigm")
    private String paradigm;

    @TableField(value = "creator_id")
    private Long creatorId;

    @TableField(value = "editor_id")
    private Long editorId;

    @TableField(value = "update_time")
    private Date updateTime;

    @TableField(value = "status")
    private Integer status;
}
