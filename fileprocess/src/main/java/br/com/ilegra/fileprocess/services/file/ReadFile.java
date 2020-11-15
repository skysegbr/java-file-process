package br.com.ilegra.fileprocess.services.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import br.com.ilegra.fileprocess.process.ThreadProcess;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class ReadFile implements ThreadProcess {

    @Override
    public void execult(String[] args, Object... kwArgs) {
        BufferedReader buffRead;
        try {
            buffRead = new BufferedReader(new FileReader(args[0]));

            String linha = "";
            while (true) {
                if (linha != null) {
                    log.info(linha);
                } else
                    break;
                linha = buffRead.readLine();
            }
            buffRead.close();
        
        } catch (IOException e) {
            log.error("Error to read a file ", e);;
        }

    }
    
}
