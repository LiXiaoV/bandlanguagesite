package com.bandlanguage.bandlanguagesite.controller;

import com.bandlanguage.bandlanguagesite.model.vo.WordVo;
import com.bandlanguage.bandlanguagesite.result.Result;
import com.bandlanguage.bandlanguagesite.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 词汇的控制器
 *
 * @author xiaov
 * @since 2021-05-22 15:04
 */
@Controller
@RestController
@RequestMapping("/word")
public class WordController {

    @Autowired
    private WordService wordService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Result registerWord(@RequestBody WordVo wordVo) {
//        System.out.println("wordVo = " + wordVo);
        Boolean res = wordService.SaveWord(wordVo);
        if (res)
            return Result.success("注册词汇成功");
        else return Result.fail(500, "注册词汇失败");
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Result getAllWords() {
        return Result.success(wordService.getAllWords());
    }

    @RequestMapping(value = "/allWords", method = RequestMethod.GET)
    public Result getAllWordsBySceneId(@RequestParam Long sceneId) {
        return Result.success(wordService.getAllWordsBySceneId(sceneId));
    }

    @RequestMapping(value = "/myWords", method = RequestMethod.GET)
    public Result getMyWordsBySceneIdAndUserId(@RequestParam Long sceneId, @RequestParam Long userId) {
        return Result.success(wordService.getWordsBySceneIdAndUserId(sceneId, userId));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result getMyWordDetailById(@PathVariable("id") Long id) {
        return Result.success(wordService.getWordDetailById(id));
    }

    @RequestMapping(value = "/getWordsByKeywordInPage", method = RequestMethod.GET)
    public Result getWordsByKeywordInPage(@RequestParam String keyword, Long pageNum, Long pageSize) {
        List<WordVo> words = wordService.getWordsByKeywordInPage(keyword, pageNum, pageSize);
        Long wordsTotal = wordService.getWordsTotalByKeyword(keyword);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("result", words);
        map.put("type", 1);
        map.put("total", wordsTotal);
        return Result.success(map);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Result updateWord(@RequestBody WordVo wordVo) {
//        System.out.println("wordVo = " + wordVo);
        Boolean res = wordService.editWord(wordVo);
        if (res)
            return Result.success("修改词汇成功");
        else return Result.fail(500, "修改词汇失败");
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public Result deleteWord(@RequestBody WordVo wordVo) {
        return Result.success(wordService.deleteWord(wordVo));
    }

    @RequestMapping(value = "/updateTypeInStatus/{id}", method = RequestMethod.PUT)
    public Result updateTypeInStatusByWordId(@PathVariable("id") Long id) {
//        System.out.println("id = " + id);
        Boolean res = wordService.updateTypeInStatusByWordId(id);
        if (res)
            return Result.success("修改词汇录入状态成功");
        else return Result.fail(500, "修改词汇录入状态失败");
    }
}
