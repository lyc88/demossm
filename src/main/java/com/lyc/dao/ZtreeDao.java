package com.lyc.dao;

import com.lyc.model.po.ZtreePO;
import com.lyc.model.query.ZtreeQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description: ZtreeDao
 * Author: curd generator
 * Create: 2016-02-18 11:45
 */
@Repository
public interface ZtreeDao {

    int insert(ZtreePO po);

    int update(ZtreePO po);

    List<ZtreePO> query(ZtreeQuery query);

    long count(ZtreeQuery query);

}