package com.bandlanguage.bandlanguagesite;

import com.bandlanguage.bandlanguagesite.cache.IGlobalCache;
import com.bandlanguage.bandlanguagesite.mapper.*;
import com.bandlanguage.bandlanguagesite.model.entity.*;
import com.bandlanguage.bandlanguagesite.model.vo.SentenceVo;
import com.bandlanguage.bandlanguagesite.model.vo.WordVo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class BandlanguagesiteApplicationTests {

    @Autowired
    private IGlobalCache globalCache;

    @Autowired
    private SceneMapper sceneMapper;

    @Autowired
    private WordMapper wordMapper;

    @Autowired
    private SentenceMapper sentenceMapper;

    @Autowired
    private WordUserMapper wordUserMapper;

    @Autowired
    private ScriptMapper scriptMapper;

    @Autowired
    private SentenceUserMapper sentenceUserMapper;

    @Autowired
    private ScriptUserMapper scriptUserMapper;

    @Test
    public void testGetScenes() {
        List<Scene> scenes = sceneMapper.getScenes();
        System.out.println("scenes = " + scenes);
    }

    @Test
    public void testGetSceneById() {
        Scene scene = sceneMapper.getSceneById(1L);
        System.out.println("scene = " + scene);
    }

    @Test
    public void testSaveWord() {
        Word word = new Word();
        word.setName("论文");
        word.setCreatorId(2L);
        word.setEditorId(2L);
        word.setDescription("学术论文");
        word.setExample("发表论文");
        word.setSynonym("qikan");
        word.setType(1);
        int res = wordMapper.insert(word);
        System.out.println("res = " + res);
        System.out.println("word = " + word);
    }

    @Test
    public void testRedisOps() {
        globalCache.set("key1", "xiaov");
        globalCache.lSetAll("list", Arrays.asList("hello", "redis"));
        List<Object> list = globalCache.lGet("list", 0, -1);
        System.out.println("list = " + list);
    }

    @Test
    public void testGetWordsBySceneIdAndUserId() {
        List<WordVo> words = wordMapper.getWordsBySceneIdAndUserId(2L, 3L);
        System.out.println("words = " + words);
    }

    @Test
    public void testInsertWordUser() {
        List<Word> words = wordMapper.selectList(null);
        for (Word word : words) {
            WordUser wordUser = new WordUser();
            wordUser.setWordId(word.getWordId());
            wordUser.setUserId(word.getCreatorId());
            wordUser.setUpdateTime(word.getUpdateTime());
            int res = wordUserMapper.insert(wordUser);
            System.out.println("res = " + res);
            System.out.println("词汇id = " + wordUser.getWordId());
            System.out.println("用户id = " + wordUser.getUserId());
            System.out.println();
        }

    }

    @Test
    public void testInsertSentenceUser() {
        List<Sentence> sentences = sentenceMapper.selectList(null);
        for (Sentence sentence : sentences) {
            SentenceUser sentenceUser = new SentenceUser();
            sentenceUser.setSentenceId(sentence.getSentenceId());
            sentenceUser.setUserId(sentence.getCreatorId());
            sentenceUser.setUpdateTime(sentence.getUpdateTime());
            int res = sentenceUserMapper.insert(sentenceUser);
            System.out.println("res = " + res);
            System.out.println("句型id = " + sentenceUser.getSentenceId());
            System.out.println("用户id = " + sentenceUser.getUserId());
            System.out.println();
        }

    }

    @Test
    public void testInsertScriptUser() {
        List<Script> scripts = scriptMapper.selectList(null);
        for (Script script : scripts) {
            ScriptUser scriptUser = new ScriptUser();
            scriptUser.setScriptId(script.getScriptId());
            scriptUser.setUserId(script.getCreatorId());
            scriptUser.setUpdateTime(script.getUpdateTime());
            int res = scriptUserMapper.insert(scriptUser);
            System.out.println("res = " + res);
            System.out.println("剧本id = " + scriptUser.getScriptId());
            System.out.println("用户id = " + scriptUser.getUserId());
            System.out.println();
        }
    }

    public void testGetCount() {
        Long scriptTotal = scriptMapper.getScriptsTotal();
        System.out.println(scriptTotal);
    }

    @Test
    public void getSentencesTotalByKeyword() {
        List<SentenceVo> sentences = sentenceMapper.getSentencesByKeywordInPage("部门", 1L, 5L);
        Long total = sentenceMapper.getSentencesTotalByKeyword("部门");
        System.out.println(sentences);
        System.out.println(total);
    }

    @Test
    public void testGetWordsByKeyword() {
        List<WordVo> words = wordMapper.getWordsByKeywordInPage("帮区", 1L, 3L);
        Long total = wordMapper.getWordsTotalByKeyword("帮区");
        System.out.println(words);
        System.out.println(words.size());
        System.out.println(total);

    }

    @Test
    public void testGetScripts() {
        List<Script> scripts = scriptMapper.getAllScriptsInPage(2L, 5L);
        Long scriptTotal = scriptMapper.getScriptsTotal();
        System.out.println(scripts);
        System.out.println(scripts.size());
        System.out.println(scriptTotal);

    }

}
