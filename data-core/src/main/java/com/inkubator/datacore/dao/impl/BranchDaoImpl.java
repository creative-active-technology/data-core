/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inkubator.datacore.dao.impl;

import com.inkubator.datacore.Branch;
import com.inkubator.datacore.dao.BranchDao;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Deni Husni FR
 */
@Repository
public class BranchDaoImpl extends IDAOImpl<Branch> implements BranchDao {

    @Override
    public Class<Branch> getEntityClass() {
        return Branch.class;
    }

}
