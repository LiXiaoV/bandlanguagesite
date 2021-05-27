package com.bandlanguage.bandlanguagesite.controller;

import com.bandlanguage.bandlanguagesite.model.vo.ScriptVo;
import com.bandlanguage.bandlanguagesite.model.vo.SentenceVo;
import com.bandlanguage.bandlanguagesite.result.Result;
import com.bandlanguage.bandlanguagesite.service.ScriptService;
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
@RequestMapping("/script")
public class ScriptController {

    @Autowired
    private ScriptService scriptService;

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
}
