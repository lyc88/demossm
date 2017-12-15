package com.lyc.model.po;

import java.util.List;

/**
 * Created by lyc on 2017/12/15.
 * email 984006207@qq.com
 */
public class User {
    private int id;
    private String username;
    private String mobile;
    private List<Group> groups;
    public List<Group> getGroups() {
        return groups;
    }
    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
