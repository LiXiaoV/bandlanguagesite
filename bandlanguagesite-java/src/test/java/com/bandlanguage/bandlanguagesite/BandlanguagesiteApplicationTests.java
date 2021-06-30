package com.bandlanguage.bandlanguagesite;

import com.bandlanguage.bandlanguagesite.cache.IGlobalCache;
import com.bandlanguage.bandlanguagesite.cache.prefix.EnvironmentKey;
import com.bandlanguage.bandlanguagesite.constant.EnvironmentType;
import com.bandlanguage.bandlanguagesite.environment.EnvironmentManagement;
import com.bandlanguage.bandlanguagesite.mapper.*;
import com.bandlanguage.bandlanguagesite.model.entity.*;
import com.bandlanguage.bandlanguagesite.model.vo.SentenceVo;
import com.bandlanguage.bandlanguagesite.model.vo.WordVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

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

    @Autowired
    private RuleMapper ruleMapper;

    @Autowired
    private RuleUserMapper ruleUserMapper;

    @Autowired
    private NodeMapper nodeMapper;

    @Autowired
    private NodeUserMapper nodeUserMapper;

    @Autowired
    private ParadigmMapper paradigmMapper;

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

    /**
     * 用户录入词汇时是游客，改为其真实用户名
     */
    @Test
    public void testUpdateWordInsertUser() {
        Long userId = 3L;

        Long startNum = 118L;
        Long endNum = 162L;
        for (Long wordId = startNum; wordId <= endNum; wordId++) {
            Word word = Word.builder().wordId(wordId).creatorId(userId).editorId(userId).build();
            int res = wordMapper.updateById(word);
            System.out.println(res > 0 ? "修改word表成功" : "修改word表失败");

            QueryWrapper<WordUser> wordUserQueryWrapper = new QueryWrapper<>();
            wordUserQueryWrapper.eq("word_id", wordId);
            List<WordUser> wordUserList = wordUserMapper.selectList(wordUserQueryWrapper);
            System.out.println("有 " + wordUserList.size() + " 条WordUser要更新");
            int index = 0;
            for (WordUser wordUser : wordUserList) {
                index++;
                wordUser.setUserId(userId);
                int updateCount = wordUserMapper.updateById(wordUser);
                System.out.println("第 " + index + " 条WordUser更新" + (updateCount > 0 ? "成功" : "失败"));
            }
        }
    }

    /**
     * 用户录入句型时是游客，改为其真实用户名
     */
    @Test
    public void testUpdateSentenceInsertUser() {
        Long userId = 3L;

        Long startNum = 26L;
        Long endNum = 44L;
        for (Long sentenceId = startNum; sentenceId <= endNum; sentenceId++) {
            Sentence sentence = Sentence.builder().sentenceId(sentenceId).creatorId(userId).editorId(userId).build();
            int res = sentenceMapper.updateById(sentence);
            System.out.println(res > 0 ? "修改sentence表成功" : "修改sentence表失败");

            QueryWrapper<SentenceUser> sentenceUserQueryWrapper = new QueryWrapper<>();
            sentenceUserQueryWrapper.eq("sentence_id", sentenceId);
            List<SentenceUser> sentenceUserList = sentenceUserMapper.selectList(sentenceUserQueryWrapper);
            System.out.println("有 " + sentenceUserList.size() + " 条SentenceUser要更新");
            int index = 0;
            for (SentenceUser sentenceUser : sentenceUserList) {
                index++;
                sentenceUser.setUserId(userId);
                int updateCount = sentenceUserMapper.updateById(sentenceUser);
                System.out.println("第 " + index + " 条SentenceUser更新" + (updateCount > 0 ? "成功" : "失败"));
            }

            // 修改中间范式
            QueryWrapper<Paradigm> paradigmQueryWrapper = new QueryWrapper<>();
            paradigmQueryWrapper.eq("sentence_id", sentenceId);
            List<Paradigm> paradigms = paradigmMapper.selectList(paradigmQueryWrapper);
            System.out.println("有 " + paradigms.size() + " 条Paradigm要更新");
            index = 0;
            for (Paradigm paradigm : paradigms) {
                index++;
                paradigm.setCreatorId(userId);
                paradigm.setEditorId(userId);
                int updateCount = paradigmMapper.updateById(paradigm);
                System.out.println("第 " + index + " 条Paradigm更新" + (updateCount > 0 ? "成功" : "失败"));
            }
        }
    }

    /**
     * 用户录入规则时是游客，改为其真实用户名
     */
    @Test
    public void testUpdateRuleInsertUser() {
        Long userId = 4L;

        Long startNum = 53L;
        Long endNum = 55L;
        for (Long ruleId = startNum; ruleId <= endNum; ruleId++) {
            Rule rule = Rule.builder().ruleId(ruleId).creatorId(userId).editorId(userId).build();
            int res = ruleMapper.updateById(rule);
            System.out.println(res > 0 ? "修改rule表成功" : "修改rule表失败");

            QueryWrapper<RuleUser> ruleUserQueryWrapper = new QueryWrapper<>();
            ruleUserQueryWrapper.eq("rule_id", ruleId);
            List<RuleUser> ruleUserList = ruleUserMapper.selectList(ruleUserQueryWrapper);
            System.out.println("有 " + ruleUserList.size() + " 条RuleUser要更新");
            int index = 0;
            for (RuleUser ruleUser : ruleUserList) {
                index++;
                ruleUser.setUserId(userId);
                int updateCount = ruleUserMapper.updateById(ruleUser);
                System.out.println("第 " + index + " 条RuleUser更新" + (updateCount > 0 ? "成功" : "失败"));
            }
        }
    }

    /**
     * 用户录入节点时是游客，改为其真实用户名
     */
    @Test
    public void testUpdateNodeInsertUser() {
        Long userId = 4L;

        Long startNum = 53L;
        Long endNum = 55L;
        for (Long nodeId = startNum; nodeId <= endNum; nodeId++) {
            Node node = Node.builder().nodeId(nodeId).creatorId(userId).editorId(userId).build();
            int res = nodeMapper.updateById(node);
            System.out.println(res > 0 ? "修改node表成功" : "修改node表失败");

            QueryWrapper<NodeUser> nodeUserQueryWrapper = new QueryWrapper<>();
            nodeUserQueryWrapper.eq("node_id", nodeId);
            List<NodeUser> nodeUserList = nodeUserMapper.selectList(nodeUserQueryWrapper);
            System.out.println("有 " + nodeUserList.size() + " 条NodeUser要更新");
            int index = 0;
            for (NodeUser nodeUser : nodeUserList) {
                index++;
                nodeUser.setUserId(userId);
                int updateCount = nodeUserMapper.updateById(nodeUser);
                System.out.println("第 " + index + " 条NodeUser更新" + (updateCount > 0 ? "成功" : "失败"));
            }
        }
    }

}
