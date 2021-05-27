package com.bandlanguage.bandlanguagesite.service;


import com.bandlanguage.bandlanguagesite.model.entity.Sentence;
import com.bandlanguage.bandlanguagesite.model.entity.Word;
import com.bandlanguage.bandlanguagesite.model.vo.SentenceVo;
import com.bandlanguage.bandlanguagesite.model.vo.WordVo;

import java.util.List;

/**
 * @author xiaov
 * @since 2021-05-22 14:48
 */
public interface SentenceService {
    /**
     * 保存句型
     * @param sentenceVo 句型的实体类
     * @return 影响的行数
     */
    Boolean SaveSentence(SentenceVo sentenceVo);

    /**
     * 通过场景区Id获取所有句型
     * @param SceneId 场景区ID
     * @return 句型对象数组
     */
    List<Sentence> getAllSentencesBySceneId(Long SceneId);
}
