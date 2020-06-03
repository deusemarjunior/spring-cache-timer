package br.com.example.deusemar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("parameters")
public class ParameterController {

    @Autowired
    ParameterService parameterService;

    @GetMapping
    public Iterable<Parameter> getParameters() {
        System.out.println("Controller Get All Parameters - Cached");
        return parameterService.findAllParameters();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void recharge(@RequestBody Parameter parameter) {
        parameterService.save(parameter);
    }

}
