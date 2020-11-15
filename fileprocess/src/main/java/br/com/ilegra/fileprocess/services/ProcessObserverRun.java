package br.com.ilegra.fileprocess.services;

import br.com.ilegra.fileprocess.process.RunProcess;
import br.com.ilegra.fileprocess.process.ThreadProcess;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Getter
@Setter
public class ProcessObserverRun {
    private String[] paranPathFile;
    private Object[] parans; 
   
    public void runProcess(String[] paranPathFile, Object[] parans ){
       
        log.info("Caminho >> " + paranPathFile[0]);
        ThreadProcess fileProcess = new FileObserverProcess();

        this.paranPathFile = paranPathFile;
        this.parans = parans;

       log.info("Caminho >> " + this.paranPathFile[0]);
       Runnable fileObserverRun = new RunProcess(fileProcess, this.paranPathFile, this.parans);
    
       Thread runObserver = new Thread(fileObserverRun);
       runObserver.start();

    }
}
