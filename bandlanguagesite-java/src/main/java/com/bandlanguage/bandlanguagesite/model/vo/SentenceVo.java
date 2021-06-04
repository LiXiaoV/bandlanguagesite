package com.bandlanguage.bandlanguagesite.model.vo;

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
public class SentenceVo implements Serializable {

    private Long sentenceId;
    private String name;
    private String description;
    private String paradigm;
    private Long creatorId;
    private String creatorUsername;
    private String creatorNickname;
    private Long editorId;
    private String editorUsername;
    private String editorNickname;
    private Date updateTime;
    private Integer isTypeIn;
    private Integer status;
    private Long userId;
    private Long sceneId;
    private String sceneName;
}
