/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.giex.schedule;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;

/**
 *
 * @author jjunior
 */
@Singleton
public class Agenda {

    @EJB
    Job job;
    
    @Schedule(second = "0", minute = "0/5", hour = "*")
    public void execute(){
        job.processos();
    }
}
