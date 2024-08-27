<<<<<<< Updated upstream
package com.testetrabalho.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.testetrabalho.Model.GastoModel;
import com.testetrabalho.Repository.GastoRepository;




@RestController
public class GastoController {

    @Autowired
    private GastoRepository gastoRepository;


 @PostMapping("/cadastrargasto")
    public GastoModel cadastrarGasto(@RequestBody GastoModel gastoModel )  {
     return gastoRepository.save(gastoModel);

}

@GetMapping("/ListarGastos")
public List<GastoModel> ListarGasto() {
    return gastoRepository.findAll();
}
 
        
}
=======
package com.testetrabalho.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.testetrabalho.Model.GastoModel;
import com.testetrabalho.Repository.GastoRepository;




@RestController
public class GastoController {

    @Autowired
    private GastoRepository gastoRepository;


 @PostMapping("/cadastrargasto")
    public GastoModel cadastrarGasto(@RequestBody GastoModel gastoModel )  {
     return gastoRepository.save(gastoModel);

}

@GetMapping("/ListarGastos")
public List<GastoModel> ListarGasto() {
    return gastoRepository.findAll();
}
 
        
}
>>>>>>> Stashed changes
