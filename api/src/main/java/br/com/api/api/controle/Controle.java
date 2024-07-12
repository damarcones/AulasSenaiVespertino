package br.com.api.api.controle;

import java.util.List;

import org.aspectj.weaver.bcel.ExceptionRange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.data.repository.support.Repositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.api.api.modelo.Pessoa;
import br.com.api.api.repositorio.PessoaRepositorio;
// import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class Controle {

    @Autowired
    private PessoaRepositorio funcao;

    @PostMapping("/tudo")
    public Pessoa salvar(@RequestBody Pessoa pessoinha){
        return funcao.save(pessoinha);
    }

    @GetMapping("/tudo")
    public List<Pessoa> busca() {
        return funcao.findAll();
    }

    @GetMapping("/tudo/{id}")
    public Pessoa selecionaID(@PathVariable int id) {
        return funcao.findById(id);
    }


     @PutMapping("/tudo/{id}")
    public void edita(@PathVariable("id") int id, @RequestBody Pessoa p){
        if(funcao.existsById(id)){
            p.setId(id);
            funcao.save(p);
        }
        else throw new RuntimeException("Id não encontrado");
    }

    @DeleteMapping("/tudo/{id}")
    public void apaga(@PathVariable int id){
        funcao.deleteById(id);
        
    }

    @DeleteMapping("tudo/apagatudo")
    public void apagatudo(){
        funcao.deleteAll();
    }
    
    

    @GetMapping("")
    public String mensagem(){
        return "Olá Mundo!";
    }


    @GetMapping("/bemvindo")
    public String bemVindo() {
        return "Bem vindo ao Spring";
    }

    @GetMapping("/bemvindo/{nome}")
    public String bemVindo(@PathVariable String nome) {
        // Regra de negocio;
        // Organização da informação;
        // Apresentação dos dados;
        return "Bem vindo(a) professor " +nome;
    }

    @PostMapping("/pessoa")
    public Pessoa pessoa (@RequestBody Pessoa p){
        return p;
    }
    
}
