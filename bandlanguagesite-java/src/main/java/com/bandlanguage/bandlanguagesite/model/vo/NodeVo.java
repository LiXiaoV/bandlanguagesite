package com.bandlanguage.bandlanguagesite.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 节点的视图类
 * @author xiaov
 * @since 2021-05-31 10:56
 */
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class NodeVo implements Serializable {

    private Long nodeId;
    private String name;
    private String packageName;
    private String content;
    private Long creatorId;
    private String creatorUsername;
    private String creatorNickname;
    private Long editorId;
    private String editorUsername;
    private String editorNickname;
    private Date updateTime;
    private Integer status;
    // 前端传进来的操作者的ID
    private Long userId;
    private Long sceneId;
}
