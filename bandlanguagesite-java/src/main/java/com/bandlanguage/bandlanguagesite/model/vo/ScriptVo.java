package com.bandlanguage.bandlanguagesite.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xiaov
 * @since 2021-05-22 17:48
 */
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class ScriptVo implements Serializable {

    private Long scriptId;
    private String name;
    private String content;
    private String description;
    private Long creatorId;
    private String creatorUsername;
    private String creatorNickname;
    private Long editorId;
    private String editorUsername;
    private String editorNickname;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;

    // 运行次数
    private Long runTimes;
    private Integer status;
    private Long userId;
    private Long sceneId;
    private String sceneName;
}
