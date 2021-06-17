package com.bandlanguage.bandlanguagesite.controller;

import com.bandlanguage.bandlanguagesite.model.vo.RuleVo;
import com.bandlanguage.bandlanguagesite.result.Result;
import com.bandlanguage.bandlanguagesite.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 规则控制器
 *
 * @author xiaov
 * @since 2021-05-31 11:45
 */
@Controller
@RestController
@RequestMapping("/rule")
public class RuleController {

    @Autowired
    private RuleService ruleService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Result registerRule(@RequestBody RuleVo ruleVo) {
        System.out.println("ruleVo = " + ruleVo);
        Boolean res = ruleService.saveRule(ruleVo);
        if (res)
            return Result.success("注册规则成功");
        else return Result.fail(500, "注册规则失败");
    }

    @RequestMapping(value = "/allSimpleRules", method = RequestMethod.GET)
    public Result getAllSimpleRulesBySceneId(@RequestParam Long sceneId) {
        return Result.success(ruleService.getAllSimpleRulesBySceneId(sceneId));
    }

    @RequestMapping(value = "/allWholeRules", method = RequestMethod.GET)
    public Result getAllWholeRulesBySceneId(@RequestParam Long sceneId) {
        return Result.success(ruleService.getAllWholeRulesBySceneId(sceneId));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result getRuleDetailById(@PathVariable("id") Long id) {
        return Result.success(ruleService.getRuleDetailById(id));
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Result updateRule(@RequestBody RuleVo ruleVo) {
//        System.out.println("ruleVo = " + ruleVo);
        Boolean res = ruleService.editRule(ruleVo);
        if (res)
            return Result.success("修改规则成功");
        else return Result.fail(500, "修改规则失败");
    }

    @RequestMapping(value = "/wordAssociatedRules", method = RequestMethod.GET)
    public Result getWordAssociatedRulesByWordId(@RequestParam Long wordId) {
        return Result.success(ruleService.getWordAssociatedRulesByWordId(wordId));
    }

    @RequestMapping(value = "/sentenceAssociatedRules", method = RequestMethod.GET)
    public Result getSentenceAssociatedRulesBySentenceId(@RequestParam Long sentenceId) {
        return Result.success(ruleService.getSentenceAssociatedRulesBySentenceId(sentenceId));
    }

    @RequestMapping(value = "/deleteRuleOfAssociate", method = RequestMethod.DELETE)
    public Result deleteRuleOfAssociate(@RequestBody RuleVo ruleVo) {
        return Result.success(ruleService.deleteRuleOfAssociate(ruleVo));
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public Result deleteRule(@RequestBody RuleVo ruleVo) {
        return Result.success(ruleService.deleteRule(ruleVo));
    }

}