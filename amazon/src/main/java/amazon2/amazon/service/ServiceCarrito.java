package amazon2.amazon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import amazon2.amazon.models.*;

@Service
public class ServiceCarrito {
    
    @Autowired
    private amazon2.amazon.repository.RepositoryCarrito repositoryCarrito;

    public List<Carrito> getAllCarritos() {
        return repositoryCarrito.findAll();
    }

    public Carrito getCarritoById(Long id) {
        return repositoryCarrito.findById(id).orElse(null);
    }

    public void saveCarrito(Carrito carrito) {
        repositoryCarrito.save(carrito);
    }

    public void deleteCarrito(Long id) {
        repositoryCarrito.deleteById(id);
    }

    public void deleteProductFromCarrito(Long carritoId, Long productId){
        
    }
}
