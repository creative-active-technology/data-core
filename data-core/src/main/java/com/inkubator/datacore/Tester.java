/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inkubator.datacore;

import com.inkubator.datacore.service.BranchService;
import com.inkubator.datacore.util.ServiceUtil;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Deni Husni FR
 */
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        BranchService branchService = (BranchService) ServiceUtil.getService("branchService");
//        System.out.println(branchService);
        try {
            System.out.println(branchService.getEntiyByPK(Long.parseLong("2028891130")).getBranchName());
        } catch (Exception ex) {
            Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
