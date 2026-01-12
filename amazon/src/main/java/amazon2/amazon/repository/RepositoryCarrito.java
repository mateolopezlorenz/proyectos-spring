package amazon2.amazon.repository;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import amazon2.amazon.models.Carrito;

@Repository
public interface RepositoryCarrito extends JpaRepository<Carrito, Long> {
    
    List<Carrito> findAll();
}
