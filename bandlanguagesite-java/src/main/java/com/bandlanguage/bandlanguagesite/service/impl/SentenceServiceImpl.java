package com.bandlanguage.bandlanguagesite.service.impl;

import com.bandlanguage.bandlanguagesite.mapper.SceneSentenceMapper;
import com.bandlanguage.bandlanguagesite.mapper.SentenceMapper;
import com.bandlanguage.bandlanguagesite.mapper.SentenceUserMapper;
import com.bandlanguage.bandlanguagesite.model.entity.SceneSentence;
import com.bandlanguage.bandlanguagesite.model.entity.Sentence;
import com.bandlanguage.bandlanguagesite.model.entity.SentenceUser;
import com.bandlanguage.bandlanguagesite.model.vo.SentenceVo;
import com.bandlanguage.bandlanguagesite.service.SentenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author xiaov
 * @since 2021-05-24 02:01
 */
@Service
public class SentenceServiceImpl implements SentenceService {

    @Autowired
    private SceneSentenceMapper sceneSentenceMapper;

    @Autowired
    private SentenceMapper sentenceMapper;

    @Autowired
    private SentenceUserMapper sentenceUserMapper;

    @Override
    @Transactional
    public Boolean SaveSentence(SentenceVo sentenceVo) {
        Sentence sentence = Sentence.builder().name(sentenceVo.getName())
                .description(sentenceVo.getDescription())
                .paradigm(sentenceVo.getParadigm())
                .creatorId(sentenceVo.getUserId())
                .editorId(sentenceVo.getUserId())
                .updateTime(new Date()).build();
        int res = sentenceMapper.insert(sentence);
        if(res > 0){
            SceneSentence sceneSentence = SceneSentence.builder().sceneId(sentenceVo.getSceneId())
                    .sentenceId(sentence.getSentenceId()).build();
            int res1 = sceneSentenceMapper.insert(sceneSentence);

            SentenceUser sentenceUser = SentenceUser.builder().sentenceId(sentence.getSentenceId())
                    .userId(sentenceVo.getUserId())
                    .updateTime(new Date()).build();
            int res2 = sentenceUserMapper.insert(sentenceUser);
            return res1 > 0 && res2 >0;
        }
        return false;
    }

    @Override
    public List<Sentence> getAllSentencesBySceneId(Long SceneId) {
        return sentenceMapper.getAllSentencesBySceneId(SceneId);
    }
}
