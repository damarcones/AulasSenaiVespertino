

package com.senai.primeirospassos.view;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import com.senai.primeirospassos.model.Usuario;

@Repository
public class UsuarioView {

    public void save(Usuario usuario){
        System.out.println("Salvar - Recebendo um novo usuário");
        System.out.println(usuario);
    }

    public List<Usuario> listAll(){
        List <Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Damarcones", "1234"));
        usuarios.add(new Usuario("Porto","5678"));
        return usuarios;
    }
}
