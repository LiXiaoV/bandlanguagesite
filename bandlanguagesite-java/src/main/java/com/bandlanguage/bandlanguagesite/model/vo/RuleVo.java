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
 * 规则的视图类
 *
 * @author xiaov
 * @since 2021-05-31 10:54
 */
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class RuleVo implements Serializable {

    private Long ruleId;
    private String rule;
    private String chineseName;
    private String express;
    private String description;
    private String code;
    private Long creatorId;
    private String creatorUsername;
    private String creatorNickname;
    private Long editorId;
    private String editorUsername;
    private String editorNickname;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;

    private Integer status;
    // 前端传进来的操作者的ID
    private Long userId;
    private Long sceneId;

    // 用于规则-句型 或规则-词汇关联
    // 词汇或句型的ID
    private Long itemId;
    // 1:词汇 2：句型
    private int type;
}
