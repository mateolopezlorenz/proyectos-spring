package amazon2.amazon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import amazon2.amazon.models.Usuario;

@Service
public class ServiceUsuario {
    
    @Autowired
    private amazon2.amazon.repository.RepositoryUsuario repositoryUsuario;

    public void saveUsuario(amazon2.amazon.models.Usuario usuario) {
        repositoryUsuario.save(usuario);
    }

    public List<Usuario> getUsuariosByNombre(String nombre) {
        return repositoryUsuario.findByNombre(nombre).map(List::of).orElseGet(List::of);
    }

    public List<Usuario> getAllUsuarios() {
        return repositoryUsuario.findAll();
    }

    public Usuario deleteUsuario(Long id){
        Usuario usuario = repositoryUsuario.findById(id).orElse(null);
        if (usuario != null) {
            repositoryUsuario.deleteById(id);
        }
        return usuario;
    }
}
