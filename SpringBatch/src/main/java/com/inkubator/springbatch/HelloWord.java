/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inkubator.springbatch;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

/**
 *
 * @author Deni Husni FR
 */
public class HelloWord implements Tasklet {

    private static final String HELLO_WORD = "Hello Word";

    @Override
    public RepeatStatus execute(StepContribution sc, ChunkContext cc) throws Exception {
        System.out.println(HELLO_WORD);
        return RepeatStatus.FINISHED;
    }

}
