package amazon2.amazon.repository;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import amazon2.amazon.models.Usuario;

@Repository
public interface RepositoryUsuario extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByNombre(String nombre);
}
