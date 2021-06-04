package com.bandlanguage.bandlanguagesite.controller;

import com.bandlanguage.bandlanguagesite.model.vo.ScriptVo;
import com.bandlanguage.bandlanguagesite.model.vo.SentenceVo;
import com.bandlanguage.bandlanguagesite.model.vo.WordVo;
import com.bandlanguage.bandlanguagesite.result.Result;
import com.bandlanguage.bandlanguagesite.service.ScriptService;
import com.bandlanguage.bandlanguagesite.service.SentenceService;
import com.bandlanguage.bandlanguagesite.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
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

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public Result registerScript(@RequestBody ScriptVo scriptVo){
        System.out.println("scriptVo = " + scriptVo);
        Boolean res = scriptService.SaveScript(scriptVo);
        if(res)
            return Result.success("保存剧本成功");
        else return Result.fail(500,"保存剧本失败");
    }

    @RequestMapping(value = "/allScripts",method = RequestMethod.GET)
    public Result getAllScriptsBySceneId(@RequestParam Long sceneId){
        return Result.success(scriptService.getAllScriptsBySceneId(sceneId));
    }

    @RequestMapping(value = "/getWordsAndSentencesByKeyword",method = RequestMethod.GET)
    public Result searchWordsOrSentenceByKeyword(@RequestParam String keyword){
        System.out.println(keyword);
        List<WordVo> words = wordService.getWordsByKeyword(keyword);
        List<SentenceVo> sentences = sentenceService.getSentencesByKeyword(keyword);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("words",words);
        map.put("sentences",sentences);
        System.out.println(words);
        System.out.println(sentences);

        return Result.success(map);
    }


}
