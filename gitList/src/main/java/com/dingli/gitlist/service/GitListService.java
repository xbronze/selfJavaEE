package com.dingli.gitlist.service;

import com.dingli.gitlist.pojo.GitInfo;

import java.util.List;

/**
 * @author: xbronze
 * @date: 2024-09-10 11:39
 * @description: TODO
 */
public interface GitListService {

    public List<GitInfo> gitInfoList();

    public GitInfo queryGitInfoByCode(String code);
}
