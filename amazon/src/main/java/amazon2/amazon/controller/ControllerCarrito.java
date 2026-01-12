package amazon2.amazon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import amazon2.amazon.models.Product;

@RestController
public class ControllerCarrito {

    @Autowired
    private amazon2.amazon.service.ServiceCarrito serviceCarrito;

    @Autowired
    private amazon2.amazon.service.ServiceProducto serviceProducto;

    // Añadir productos
    @PostMapping("/api/productos")
    public String saveProducto(@RequestBody Product product) {
        serviceProducto.saveProducto(product);
        return "Se ha añadido el producto correctamente: " + product.getName();
}

    // Visualizar productos
    @GetMapping("/api/productos")
    public String getProductosAPI() {
        return serviceProducto.getAllProductos().toString();
    }

    // Ver el contenido del carrito por id
    @GetMapping("/carrito/{id}")
    public String getCarritoById(@PathVariable Long id) {
        return serviceCarrito.getCarritoById(id).toString();
    }
    
    // Ver todos los productos disponibles
    @GetMapping("/productos")
    public String getAllProductos() {
        return serviceProducto.getAllProductos().toString();
    }

    // Ver todos los carritos
    @GetMapping("/carritos")
    public String getAllCarritos() {
        return serviceCarrito.getAllCarritos().toString();
    }

    // Eliminar un carrito por id
    @DeleteMapping("/carrito/delete/{id}")
    public String deleteCarrito(@PathVariable Long id) {
        serviceCarrito.deleteCarrito(id);
        return "Carrito eliminado";
    }
}