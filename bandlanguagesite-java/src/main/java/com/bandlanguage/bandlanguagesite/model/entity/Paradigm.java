package com.bandlanguage.bandlanguagesite.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 中间泛式实体类
 *
 * @author xiaov
 * @since 2021-06-16 17:37
 */
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("bls_paradigm")
public class Paradigm implements Serializable {

    @TableId(value = "paradigm_id", type = IdType.AUTO)
    private Long paradigmId;

    @TableField(value = "sentence_id")
    private Long sentenceId;

    @TableField(value = "easy_paradigm")
    private String easyParadigm;

    @TableField(value = "example")
    private String example;

    @TableField(value = "creator_id")
    private Long creatorId;

    @TableField(value = "editor_id")
    private Long editorId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "update_time")
    private Date updateTime;

    @TableField(value = "status")
    private Integer status;
}
