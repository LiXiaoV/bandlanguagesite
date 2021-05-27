package com.bandlanguage.bandlanguagesite.controller;

import com.bandlanguage.bandlanguagesite.model.vo.WordVo;
import com.bandlanguage.bandlanguagesite.result.Result;
import com.bandlanguage.bandlanguagesite.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author xiaov
 * @since 2021-05-22 15:04
 */
@Controller
@RestController
@RequestMapping("/word")
public class WordController {

    @Autowired
    private WordService wordService;

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public Result registerWord(@RequestBody WordVo wordVo){
//        System.out.println("wordVo = " + wordVo);
        Boolean res = wordService.SaveWord(wordVo);
        if(res)
            return Result.success("注册词汇成功");
        else return Result.fail(500,"注册词汇失败");
    }

    @RequestMapping(value = "/allWords",method = RequestMethod.GET)
    public Result getAllWordsBySceneId(@RequestParam Long sceneId){
        return Result.success(wordService.getAllWordsBySceneId(sceneId));
    }
}
