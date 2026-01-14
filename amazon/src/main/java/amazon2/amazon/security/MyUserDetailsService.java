package amazon2.amazon.security;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;

import amazon2.amazon.models.Usuario;
import amazon2.amazon.repository.RepositoryUsuario;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final RepositoryUsuario usuarioRepository;

    public MyUserDetailsService(RepositoryUsuario usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByNombre(nombre)
                .stream().findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + nombre));

        return User.builder()
                .username(usuario.getNombre())
                .password(usuario.getPassword())
                .authorities(new ArrayList<>())
                .build();
    }
}
