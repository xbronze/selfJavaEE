package com.dingli.gitlist.dao;

import com.dingli.gitlist.pojo.GitInfo;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: xbronze
 * @date: 2024-09-10 11:42
 * @description: TODO
 */

public interface GitListMapper {

    @Select("select * from git_info order by code ")
    @Results(id = "gitInfoList", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "classes", column = "classes"),
            @Result(property = "code", column = "code"),
            @Result(property = "name", column = "name"),
            @Result(property = "gitAddress", column = "git_address")
    })
    public List<GitInfo> gitInfoList();

    @Select("select * from git_info where code = #{code}  ")
    @Results(id = "getGitInfoByCode", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "classes", column = "classes"),
            @Result(property = "code", column = "code"),
            @Result(property = "name", column = "name"),
            @Result(property = "gitAddress", column = "git_address")
    })
    public GitInfo getGitInfoByCode(String code);
}
