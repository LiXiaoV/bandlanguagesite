package com.bandlanguage.bandlanguagesite.controller;

import com.bandlanguage.bandlanguagesite.model.vo.ScriptVo;
import com.bandlanguage.bandlanguagesite.model.vo.SentenceVo;
import com.bandlanguage.bandlanguagesite.result.Result;
import com.bandlanguage.bandlanguagesite.service.ScriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
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

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result updateScript(@RequestBody ScriptVo scriptVo) {
//        System.out.println("scriptVo = " + scriptVo);
        Boolean res = scriptService.editScript(scriptVo);
        if (res)
            return Result.success("修改剧本成功");
        else return Result.fail(500, "修改剧本败");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result deleteScriptById(@PathVariable("id") Long id) {
        return Result.success(scriptService.deleteScriptById(id));
    }
}
