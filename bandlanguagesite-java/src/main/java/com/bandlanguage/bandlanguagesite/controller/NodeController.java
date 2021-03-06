package com.bandlanguage.bandlanguagesite.controller;

import com.bandlanguage.bandlanguagesite.model.vo.NodeVo;
import com.bandlanguage.bandlanguagesite.result.Result;
import com.bandlanguage.bandlanguagesite.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 节点控制器
 *
 * @author xiaov
 * @since 2021-05-31 15:33
 */
@Controller
@RestController
@RequestMapping("/node")
public class NodeController {

    @Autowired
    private NodeService nodeService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Result registerNode(@RequestBody NodeVo nodeVo) {
//        System.out.println("nodeVo = " + nodeVo);
        Boolean res = nodeService.saveNode(nodeVo);
        if (res)
            return Result.success("注册节点成功");
        else return Result.fail(500, "注册节点失败");
    }

    @RequestMapping(value = "/allSimpleNodes", method = RequestMethod.GET)
    public Result getAllSimpleNodesBySceneId(@RequestParam Long sceneId) {
        return Result.success(nodeService.getAllSimpleNodesBySceneId(sceneId));
    }

    @RequestMapping(value = "/allWholeNodes", method = RequestMethod.GET)
    public Result getAllWholeNodesBySceneId(@RequestParam Long sceneId) {
        return Result.success(nodeService.getAllWholeNodesBySceneId(sceneId));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result getNodeDetailById(@PathVariable("id") Long id) {
        return Result.success(nodeService.getNodeDetailById(id));
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Result updateNode(@RequestBody NodeVo nodeVo) {
//        System.out.println("nodeVo = " + nodeVo);
        Boolean res = nodeService.editNode(nodeVo);
        if (res)
            return Result.success("修改节点成功");
        else return Result.fail(500, "修改节点失败");
    }

    @RequestMapping(value = "/wordAssociatedNodes", method = RequestMethod.GET)
    public Result getWordAssociatedNodesByWordId(@RequestParam Long wordId) {
        return Result.success(nodeService.getWordAssociatedNodesByWordId(wordId));
    }

    @RequestMapping(value = "/sentenceAssociatedNodes", method = RequestMethod.GET)
    public Result getSentenceAssociatedNodesBySentenceId(@RequestParam Long sentenceId) {
        return Result.success(nodeService.getSentenceAssociatedNodesBySentenceId(sentenceId));
    }

    @RequestMapping(value = "/deleteNodeOfAssociate", method = RequestMethod.DELETE)
    public Result deleteNodeOfAssociate(@RequestBody NodeVo nodeVo) {
        return Result.success(nodeService.deleteNodeOfAssociate(nodeVo));
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public Result deleteNode(@RequestBody NodeVo nodeVo) {
        return Result.success(nodeService.deleteNode(nodeVo));
    }
}
