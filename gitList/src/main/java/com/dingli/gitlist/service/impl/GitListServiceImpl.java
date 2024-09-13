package com.dingli.gitlist.service.impl;

import com.dingli.gitlist.dao.GitListMapper;
import com.dingli.gitlist.pojo.GitInfo;
import com.dingli.gitlist.service.GitListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: xbronze
 * @date: 2024-09-10 11:41
 * @description: TODO
 */
@Service("gitListService")
public class GitListServiceImpl implements GitListService {

    @Autowired
    private GitListMapper gitListMapper;

    @Override
    public List<GitInfo> gitInfoList() {
        return gitListMapper.gitInfoList();
    }

    @Override
    public GitInfo queryGitInfoByCode(String code) {
        return gitListMapper.getGitInfoByCode(code);
    }
}
