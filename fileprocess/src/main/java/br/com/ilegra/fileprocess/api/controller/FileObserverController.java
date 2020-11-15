package br.com.ilegra.fileprocess.api.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.ilegra.fileprocess.services.ProcessObserverRun;


@RestController
@RequestMapping(value = "/api/process")
public class FileObserverController {
    
    
    String msg = "";
    Object[] param = {msg};

    @RequestMapping(value = "/observer", method = RequestMethod.GET)
    public ResponseEntity<String> buscar(HttpServletRequest req) {

        return new ResponseEntity<>(param[0].toString(), HttpStatus.OK);
    }

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public ResponseEntity<String> start(HttpServletRequest req) {


        ProcessObserverRun runProcess = new ProcessObserverRun();
        String[] caminho =  {"C:\\teste"};

        runProcess.runProcess(caminho, param);

        return new ResponseEntity<>("started", HttpStatus.OK);
    }

    @RequestMapping(value = "/stop", method = RequestMethod.GET)
    public ResponseEntity<String> stop(HttpServletRequest req) {
        
        return new ResponseEntity<>("stoped", HttpStatus.OK);
    }
}
