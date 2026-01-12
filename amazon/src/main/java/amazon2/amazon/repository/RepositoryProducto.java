package amazon2.amazon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
import amazon2.amazon.models.Product;

@Repository
public interface RepositoryProducto extends JpaRepository<Product, Long> {

    List<Product> findAll();
}
