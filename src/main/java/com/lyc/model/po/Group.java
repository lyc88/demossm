package com.lyc.model.po;

import java.util.List;

/**
 * Created by lyc on 2017/12/15.
 * email 984006207@qq.com
 */
public class Group {
    private int groupId;
    private String groupName;
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }
    public int getGroupId() {
        return groupId;
    }
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
    public String getGroupName() {
        return groupName;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
