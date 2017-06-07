package com.lyc.model.po;

import java.sql.Timestamp;

/**
 * Description: ZtreePO
 * Author: curd generator
 * Create: 2016-02-18 11:06
 */
public class ZtreePO {
	private Integer treeId;
	private Integer parentId;
	private String treeCode;
	private String treeDesc;
	private Integer treeid;

	public Integer getTreeId(){
        return this.treeId;
    }

    public void setTreeId(Integer treeId){
        this.treeId = treeId;
    }

	public Integer getParentId(){
        return this.parentId;
    }

    public void setParentId(Integer parentId){
        this.parentId = parentId;
    }

	public String getTreeCode(){
        return this.treeCode;
    }

    public void setTreeCode(String treeCode){
        this.treeCode = treeCode;
    }

	public String getTreeDesc(){
        return this.treeDesc;
    }

    public void setTreeDesc(String treeDesc){
        this.treeDesc = treeDesc;
    }

	public Integer getTreeid(){
        return this.treeid;
    }

    public void setTreeid(Integer treeid){
        this.treeid = treeid;
    }

}