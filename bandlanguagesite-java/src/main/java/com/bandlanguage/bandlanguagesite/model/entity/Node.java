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
 * 节点的实体类
 *
 * @author xiaov
 * @since 2021-05-31 10:50
 */
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("bls_node")
public class Node implements Serializable {

    @TableId(value = "node_id", type = IdType.AUTO)
    private Long nodeId;

    @TableField(value = "name")
    private String name;

    @TableField(value = "package_name")
    private String packageName;

    @TableField(value = "content")
    private String content;

    @TableField(value = "creator_id")
    private Long creatorId;

    @TableField(value = "editor_id")
    private Long editorId;

    @TableField(value = "update_time")
    private Date updateTime;

    @TableField(value = "status")
    private Integer status;
}
