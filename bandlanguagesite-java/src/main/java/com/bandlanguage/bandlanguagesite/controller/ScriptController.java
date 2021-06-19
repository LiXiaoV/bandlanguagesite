package com.bandlanguage.bandlanguagesite.controller;

import com.alibaba.fastjson.JSONObject;
import com.bandlanguage.bandlanguagesite.model.entity.Script;
import com.bandlanguage.bandlanguagesite.model.vo.ScriptVo;
import com.bandlanguage.bandlanguagesite.model.vo.SentenceVo;
import com.bandlanguage.bandlanguagesite.model.vo.WordVo;
import com.bandlanguage.bandlanguagesite.result.Result;
import com.bandlanguage.bandlanguagesite.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 剧本的控制类
 *
 * @author xiaov
 * @since 2021-05-22 15:04
 */
@Controller
@RestController
@RequestMapping("/script")
public class ScriptController {

    @Autowired
    private ScriptService scriptService;

    @Autowired
    private WordService wordService;

    @Autowired
    private SentenceService sentenceService;

    @Autowired
    private BLFactory blFactory;
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Result registerScript(@RequestBody ScriptVo scriptVo) {

        System.out.println("scriptVo = " + scriptVo);
        Boolean res = scriptService.SaveScript(scriptVo);
        if (res)
            return Result.success("保存剧本成功");
        else return Result.fail(500, "保存剧本失败");
    }

    @RequestMapping(value = "/allScripts", method = RequestMethod.GET)
    public Result getAllScriptsBySceneId(@RequestParam Long sceneId) {
        return Result.success(scriptService.getAllScriptsBySceneId(sceneId));
    }


    @RequestMapping(value = "/myScripts", method = RequestMethod.GET)
    public Result getMyScriptsBySceneIdAndUserId(@RequestParam Long sceneId, @RequestParam Long userId) {
        return Result.success(scriptService.getMyScriptsBySceneIdAndUserId(sceneId, userId));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result getMyScriptDetailById(@PathVariable("id") Long id) {
        return Result.success(scriptService.getMyScriptDetailById(id));
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Result updateScript(@RequestBody ScriptVo scriptVo) {
//        System.out.println("scriptVo = " + scriptVo);
        Boolean res = scriptService.editScript(scriptVo);
        if (res)
            return Result.success("修改剧本成功");
        else return Result.fail(500, "修改剧本败");
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public Result deleteScript(@RequestBody ScriptVo scriptVo) {
        return Result.success(scriptService.deleteScript(scriptVo));
    }

    @RequestMapping(value = "/hotScripts", method = RequestMethod.GET)
    public Result getHotScripts(@RequestParam Long limitCount) {
        return Result.success(scriptService.getHotScripts(limitCount));
    }

    @RequestMapping(value = "/increaseRunTimes/{id}", method = RequestMethod.PUT)
    public Result increaseRunTimesByScriptId(@PathVariable("id") Long id) {
//        System.out.println("id = " + id);
        Boolean res = scriptService.increaseRunTimesByScriptId(id);
        if (res)
            return Result.success("增加剧本运行次数成功");
        else return Result.fail(500, "增加剧本运行次数失败");
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Result getAllScripts() {
        return Result.success(scriptService.getAllScripts());
    }

    @RequestMapping(value = "/getWordsAndSentencesByKeyword", method = RequestMethod.GET)
    public Result searchWordsOrSentenceByKeyword(@RequestParam String keyword, Long pageNum, Long pageSize) {
        Long start = (pageNum - 1) * pageSize;

        Long wordsTotal = wordService.getWordsTotalByKeyword(keyword);
        Long sentencesTotal = sentenceService.getSentencesTotalByKeyword(keyword);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", wordsTotal + sentencesTotal);

        if (wordsTotal == 0 && sentencesTotal == 0) {
            map.put("result", new HashMap<String, Object>());
        } else if (sentencesTotal == 0) {
            List<WordVo> words = wordService.getWordsByKeywordInPage(keyword, pageNum, pageSize);
            map.put("result", words);
            map.put("type", 1);
        } else if (wordsTotal == 0) {
            List<SentenceVo> sentences = sentenceService.getSentencesByKeywordInPageWithOffset(keyword, start - wordsTotal, pageSize);
            map.put("result", sentences);
            map.put("type", 2);
        } else {

            if (start > wordsTotal) {
                //只搜索句型
                List<SentenceVo> sentences = sentenceService.getSentencesByKeywordInPageWithOffset(keyword, start - wordsTotal, pageSize);
                map.put("result", sentences);
                map.put("type", 2);
            } else {
                if (pageNum * pageSize < wordsTotal) {
                    //只搜索词汇
                    List<WordVo> words = wordService.getWordsByKeywordInPage(keyword, pageNum, pageSize);
                    map.put("result", words);
                    map.put("type", 1);
                } else {
                    List list = new ArrayList();
                    List<WordVo> words = wordService.getWordsByKeywordInPage(keyword, pageNum, pageSize);
                    List<SentenceVo> sentences = sentenceService.getSentencesByKeywordInPageWithOffset(keyword, 0L, pageSize - words.size());
                    Iterator<WordVo> itW = words.iterator();
                    Iterator<SentenceVo> itS = sentences.iterator();
                    while (itW.hasNext()) {
                        JSONObject wordVo = (JSONObject) JSONObject.toJSON(itW.next());
                        wordVo.put("isWord", true);
                        list.add(wordVo);
                    }

                    while (itS.hasNext()) {
                        JSONObject sentenceVo = (JSONObject) JSONObject.toJSON(itS.next());
                        sentenceVo.put("isWord", false);
                        list.add(sentenceVo);
                    }
                    map.put("result", list);
                    map.put("type", 3);
                }
            }
        }

        return Result.success(map);
    }

    @RequestMapping(value = "/getScriptsInPage", method = RequestMethod.GET)
    public Result getScriptsInPage(@RequestParam Long pageNum, Long pageSize) {
        List<Script> scripts = scriptService.getScriptsInPage(pageNum, pageSize);
        Long scriptTotal = scriptService.getScriptsTotal();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("scripts", scripts);
        map.put("scriptsTotal", scriptTotal);
        return Result.success(map);
    }

    @RequestMapping(value = "/showAST", method = RequestMethod.GET)
    public Result showAST(@RequestParam String script, Long sceneId) {
        BLService blService = blFactory.getBLService(sceneId);
        String treeJson = blService.getAST(script);
        return Result.success(treeJson);
    }

    @RequestMapping(value = "/runScript", method = RequestMethod.POST)
    public Result runScript(@RequestParam String script, Long sceneId) {
        System.out.println("script = " + script);
        BLService blService = blFactory.getBLService(sceneId);
        return Result.success(blService.runScript(script));
    }

}
