package amazon2.amazon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import amazon2.amazon.models.Product;

@Service
public class ServiceProducto {
    
    @Autowired
    private amazon2.amazon.repository.RepositoryProducto producto;

    public List<Product> getAllProductos() {
        return producto.findAll();
    }

    public void saveProducto(Product product) {
        producto.save(product);
    }

    public void deleteProducto(Long id) {
        producto.deleteById(id);
    }
}
