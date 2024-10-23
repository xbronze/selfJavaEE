package com.dingli.chapter7experiment.questionnaire;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: xbronze
 * @date: 2024-10-23 09:01
 * @description: TODO
 */
@Controller
@RequestMapping("/questionnaire")
public class QuestionnaireController {

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> add(@RequestBody Questionnaire questionnaire) {
        if (questionnaire != null) {
            System.out.println(questionnaire);
        }


        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", questionnaire);
        return map;
    }
}
