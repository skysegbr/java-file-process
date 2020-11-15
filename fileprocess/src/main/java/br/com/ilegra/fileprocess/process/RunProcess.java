package br.com.ilegra.fileprocess.process;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RunProcess implements Runnable  {

    private String[] pathFile;
    private Object[] msg;
    private ThreadProcess threadProcess;

    public RunProcess(ThreadProcess threadProcess, String[] pathFile, Object... msg) {
        this.threadProcess =  threadProcess;
        this.pathFile = pathFile;
        this.msg = msg;
    }

    @Override
    public void run() {
        threadProcess.execult(pathFile, msg); 
    }
}
