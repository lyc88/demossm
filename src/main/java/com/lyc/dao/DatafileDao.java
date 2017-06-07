package com.lyc.dao;

import com.lyc.model.po.DatafilePO;
import com.lyc.model.query.DatafileQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description: DatafileDao
 * Author: curd generator
 * Create: 2016-02-18 11:45
 */

public interface DatafileDao {

    int insert(DatafilePO po);

    int update(DatafilePO po);

    List<DatafilePO> query(DatafileQuery query);

    long count(DatafileQuery query);

}