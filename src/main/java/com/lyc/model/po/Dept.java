package com.lyc.model.po;

import java.util.List;

/**
 * Created by lyc on 2018/6/9.
 * email 984006207@qq.com
 */
public class Dept {

    private String deptName;

    private int deptId;

    private List<Emp> empList;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public List<Emp> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Emp> empList) {
        this.empList = empList;
    }
}
