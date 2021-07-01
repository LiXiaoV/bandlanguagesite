package com.bandlanguage.bandlanguagesite.model.vo;

import com.bandlanguage.bandlanguagesite.model.entity.Paradigm;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 句型的视图类
 *
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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    private Integer isTypeIn;
    private Integer status;

    // 中间范式
    private List<Paradigm> paradigms;

    private Long userId;
    private Long sceneId;
    private String sceneName;
}
