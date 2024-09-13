package com.dingli.gitlist.controller;

import com.dingli.gitlist.pojo.GitInfo;
import com.dingli.gitlist.service.GitListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xbronze
 * @date: 2024-09-10 11:38
 * @description: TODO
 */
@Controller
@RequestMapping("/git")
public class GitListController {

    @Autowired
    private GitListService gitListService;

    @RequestMapping("/list")
    public ModelAndView list() {
        List<GitInfo> list = gitListService.gitInfoList();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("gitInfoList", list);
        modelAndView.setViewName("list");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView init(GitInfo gitInfo) {
        System.out.println(gitInfo.toString());
        List<GitInfo> list = gitListService.gitInfoList();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("gitInfoList", list);
        modelAndView.setViewName("list");
        return modelAndView;
    }

    @RequestMapping(value = "/queryByCode", method = RequestMethod.POST)
    public ModelAndView queryByCode(String code) {
        List<GitInfo> list = new ArrayList<>();
        if (code != null && !"".equals(code)) {
            GitInfo gitInfo = gitListService.queryGitInfoByCode(code);
            if (gitInfo != null) {
                list.add(gitInfo);
            }
        } else {
            list = gitListService.gitInfoList();
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("gitInfoList", list);
        modelAndView.setViewName("list");
        return modelAndView;
    }
}
