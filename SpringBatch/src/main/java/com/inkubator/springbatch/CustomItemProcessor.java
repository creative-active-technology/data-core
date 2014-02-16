/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.inkubator.springbatch;

import org.springframework.batch.item.ItemProcessor;

/**
 *
 * @author Deni Husni FR
 */
public class CustomItemProcessor implements ItemProcessor<Report, Report>{

    @Override
    public Report process(Report item) throws Exception {
        System.out.println("Processing...data..." + item);
		return item;
    }

   
}
