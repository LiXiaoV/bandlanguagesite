package com.bandlanguage.bandlanguagesite.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author xiaov
 * @since 2021-05-22 17:48
 */
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class WordVo implements Serializable {

    private Long wordId;
    private String name;
    private String description;
    private String example;
    private Integer type;
    private String synonym;
    private Long userId;
    private String username;
    private String nickname;
    private Long sceneId;
}
