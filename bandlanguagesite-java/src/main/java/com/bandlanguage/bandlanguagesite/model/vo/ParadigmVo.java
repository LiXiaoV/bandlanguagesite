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
 * 中间范式的视图类
 *
 * @author xiaov
 * @since 2021-06-16 22:43
 */
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class ParadigmVo implements Serializable {

    private Long paradigmId;
    private Long sentenceId;
    private String easyParadigm;
    private String example;
    private Long creatorId;
    private Long editorId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    private Integer status;

    // 前端传进来的操作者的ID
    private Long userId;
}
