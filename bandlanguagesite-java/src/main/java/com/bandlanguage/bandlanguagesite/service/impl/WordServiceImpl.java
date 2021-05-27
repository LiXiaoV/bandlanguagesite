package com.bandlanguage.bandlanguagesite.service.impl;

import com.bandlanguage.bandlanguagesite.mapper.SceneWordMapper;
import com.bandlanguage.bandlanguagesite.mapper.WordMapper;
import com.bandlanguage.bandlanguagesite.model.entity.SceneWord;
import com.bandlanguage.bandlanguagesite.model.entity.Word;
import com.bandlanguage.bandlanguagesite.model.vo.WordVo;
import com.bandlanguage.bandlanguagesite.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author xiaov
 * @since 2021-05-22 14:53
 */
@Service
public class WordServiceImpl implements WordService {

    @Autowired
    private WordMapper wordMapper;

    @Autowired
    private SceneWordMapper sceneWordMapper;

    @Override
    @Transactional
    public Boolean SaveWord(WordVo wordVo) {
        Word word = Word.builder().name(wordVo.getName())
                .description(wordVo.getDescription())
                .example(wordVo.getExample())
                .type(wordVo.getType())
                .synonym(wordVo.getSynonym())
                .creatorId(wordVo.getUserId())
                .editorId(wordVo.getUserId())
                .updateTime(new Date()).build();
        int res = wordMapper.insert(word);
        if (res > 0) {
            SceneWord sceneWord = SceneWord.builder().sceneId(wordVo.getSceneId())
                    .wordId(word.getWordId()).build();
            int res1 = sceneWordMapper.insert(sceneWord);
            return res1 > 0;
        }
        return false;
    }

    @Override
    public List<Word> getAllWordsBySceneId(Long SceneId) {
        return wordMapper.getAllWordsBySceneId(SceneId);
    }
}
