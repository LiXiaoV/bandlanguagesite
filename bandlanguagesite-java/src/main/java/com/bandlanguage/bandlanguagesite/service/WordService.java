package com.bandlanguage.bandlanguagesite.service;


import com.bandlanguage.bandlanguagesite.model.entity.Word;
import com.bandlanguage.bandlanguagesite.model.vo.WordVo;

import java.util.List;

/**
 * @author xiaov
 * @since 2021-05-22 14:48
 */
public interface WordService{
    /**
     * 保存词汇
     * @param word 词的实体类
     * @return 影响的行数
     */
    Boolean SaveWord(WordVo wordVo);

    /**
     * 通过场景区Id获取所有词汇
     * @param SceneId 场景区ID
     * @return 词汇对象数组
     */
    List<Word> getAllWordsBySceneId(Long SceneId);
}
