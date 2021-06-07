package com.bandlanguage.bandlanguagesite.controller;

import com.bandlanguage.bandlanguagesite.model.vo.SentenceVo;
import com.bandlanguage.bandlanguagesite.result.Result;
import com.bandlanguage.bandlanguagesite.service.SentenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 句型的控制类
 *
 * @author xiaov
 * @since 2021-05-22 15:04
 */
@Controller
@RestController
@RequestMapping("/sentence")
public class SentenceController {

    @Autowired
    private SentenceService sentenceService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Result registerSentence(@RequestBody SentenceVo sentenceVo) {
//        System.out.println("sentenceVo = " + sentenceVo);
        Boolean res = sentenceService.SaveSentence(sentenceVo);
        if (res)
            return Result.success("注册句型成功");
        else return Result.fail(500, "注册句型失败");
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Result getAllSentences() {
        return Result.success(sentenceService.getAllSentences());
    }

    @RequestMapping(value = "/allSentences", method = RequestMethod.GET)
    public Result getAllSentencesBySceneId(@RequestParam Long sceneId) {
        return Result.success(sentenceService.getAllSentencesBySceneId(sceneId));
    }

    @RequestMapping(value = "/mySentences", method = RequestMethod.GET)
    public Result getMySentencesBySceneIdAndUserId(@RequestParam Long sceneId, @RequestParam Long userId) {
        return Result.success(sentenceService.getMySentencesBySceneIdAndUserId(sceneId, userId));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result getMySentenceDetailById(@PathVariable("id") Long id) {
        return Result.success(sentenceService.getMySentenceDetailById(id));
    }

    @RequestMapping(value = "/getSentencesByKeywordInPage",method = RequestMethod.GET)
    public Result getSentencesByKeywordInPage(@RequestParam String keyword,Long pageNum,Long pageSize){
        List<SentenceVo> sentences = sentenceService.getSentencesByKeywordInPage(keyword, pageNum, pageSize);
        Long sentencesTotal = sentenceService.getSentencesTotalByKeyword(keyword);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("result",sentences);
        map.put("type",2);
        map.put("total",sentencesTotal);
        return Result.success(map);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result updateSentence(@RequestBody SentenceVo sentenceVo) {
        System.out.println("sentenceVo = " + sentenceVo);
        Boolean res = sentenceService.editSentence(sentenceVo);
        if (res)
            return Result.success("修改句型成功");
        else return Result.fail(500, "修改句型失败");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result deleteSentenceById(@PathVariable("id") Long id) {
        return Result.success(sentenceService.deleteSentenceById(id));
    }

    @RequestMapping(value = "/updateTypeInStatus/{id}",method = RequestMethod.PUT)
    public Result updateTypeInStatusBySentenceId(@PathVariable("id") Long id){
//        System.out.println("id = " + id);
        Boolean res = sentenceService.updateTypeInStatusBySentenceId(id);
        if(res)
            return Result.success("修改句型录入状态成功");
        else return Result.fail(500,"修改句型录入状态失败");
    }
}
