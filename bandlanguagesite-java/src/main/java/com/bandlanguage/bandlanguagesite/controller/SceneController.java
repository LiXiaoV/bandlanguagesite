package com.bandlanguage.bandlanguagesite.controller;

import com.bandlanguage.bandlanguagesite.model.entity.Scene;
import com.bandlanguage.bandlanguagesite.result.Result;
import com.bandlanguage.bandlanguagesite.service.SceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xiaov
 * @since 2021-05-21 15:49
 */
@Controller
@RestController
@RequestMapping("/scene")
public class SceneController {

    @Autowired
    private SceneService sceneService;

    @RequestMapping(value = "/scenes",method = RequestMethod.GET)
    public Result getScenes(){
        return Result.success(sceneService.getScenes());
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Scene getSceneById(@PathVariable("id") Long id){
        return sceneService.getSceneById(id);
    }
}
