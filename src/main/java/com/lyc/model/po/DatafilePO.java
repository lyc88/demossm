package com.lyc.model.po;

import java.sql.Timestamp;

/**
 * Description: DatafilePO
 * Author: curd generator
 * Create: 2016-02-18 11:06
 */
public class DatafilePO {
	private Integer id;
	private String filepath;
	private String filename;
	private Integer dataid;

	public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }

	public String getFilepath(){
        return this.filepath;
    }

    public void setFilepath(String filepath){
        this.filepath = filepath;
    }

	public String getFilename(){
        return this.filename;
    }

    public void setFilename(String filename){
        this.filename = filename;
    }

	public Integer getDataid(){
        return this.dataid;
    }

    public void setDataid(Integer dataid){
        this.dataid = dataid;
    }

}