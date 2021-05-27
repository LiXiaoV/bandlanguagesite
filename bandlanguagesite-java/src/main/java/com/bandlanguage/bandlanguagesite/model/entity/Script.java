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
 * 剧本的实体类
 * @author xiaov
 * @since 2021-05-21 17:21
 */
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("bls_script")
public class Script implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long scriptId;

    @TableField(value = "name")
    private String name;

    @TableField(value = "content")
    private String content;

    @TableField(value = "description")
    private String description;

    @TableField(value = "creator_id")
    private Long creatorId;

    @TableField(value = "editor_id")
    private Long editorId;

    @TableField(value = "update_time")
    private Date updateTime;

    @TableField(value = "run_times")
    private Long runTimes;

    @TableField(value = "status")
    private Integer status;
}
