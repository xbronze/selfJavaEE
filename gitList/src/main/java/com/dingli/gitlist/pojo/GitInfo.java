package com.dingli.gitlist.pojo;

/**
 * @author: xbronze
 * @date: 2024-09-10 11:35
 * @description: TODO
 */
public class GitInfo {

    private Integer id;
    private String classes;
    private String code;
    private String name;
    private String gitAddress;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGitAddress() {
        return gitAddress;
    }

    public void setGitAddress(String gitAddress) {
        this.gitAddress = gitAddress;
    }
}
