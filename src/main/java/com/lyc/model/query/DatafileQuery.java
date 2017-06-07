package com.lyc.model.query;

import java.sql.Timestamp;

/**
 * Description: DatafileQuery
 * Author: curd generator
 * Create: 2016-02-18 11:06
 */
public class DatafileQuery {
	private Integer id;
	private String filepath;
	private String filename;
	private Integer dataid;
	private Long offset;
	private Integer limit;

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

	public Long getOffset(){
        return this.offset;
    }

    public void setOffset(Long offset){
        this.offset = offset;
    }

	public Integer getLimit(){
        return this.limit;
    }

    public void setLimit(Integer limit){
        this.limit = limit;
    }

}