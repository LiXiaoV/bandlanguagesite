package com.bandlanguage.bandlanguagesite.controller;

import com.bandlanguage.bandlanguagesite.model.vo.SentenceVo;
import com.bandlanguage.bandlanguagesite.result.Result;
import com.bandlanguage.bandlanguagesite.service.SentenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author xiaov
 * @since 2021-05-22 15:04
 */
@Controller
@RestController
@RequestMapping("/sentence")
public class SentenceController {

    @Autowired
    private SentenceService sentenceService;

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public Result registerSentence(@RequestBody SentenceVo sentenceVo){
//        System.out.println("sentenceVo = " + sentenceVo);
        Boolean res = sentenceService.SaveSentence(sentenceVo);
        if(res)
            return Result.success("注册句型成功");
        else return Result.fail(500,"注册句型失败");
    }

    @RequestMapping(value = "/allSentences",method = RequestMethod.GET)
    public Result getAllSentencesBySceneId(@RequestParam Long sceneId){
        return Result.success(sentenceService.getAllSentencesBySceneId(sceneId));
    }
}
