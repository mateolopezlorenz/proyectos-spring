package amazon2.amazon.controller;

import amazon2.amazon.models.Carrito;
import amazon2.amazon.models.Product;
import amazon2.amazon.service.ServiceCarrito;
import amazon2.amazon.service.ServiceProducto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ControllerCarrito {

    @Autowired
    private ServiceCarrito serviceCarrito;

    @Autowired
    private ServiceProducto serviceProducto;

    // -- Productos --

    // Añadir producto
    @PostMapping("/productos")
    public String saveProducto(@RequestBody Product product) {
        try{
            serviceProducto.saveProducto(product);
            return "Producto añadido correctamente: " + product.getName();
        }
        catch(Exception e){
            return "Error al añadir el producto: " + e.getMessage();
        }
    }

    // Ver todos los productos
    @GetMapping("/productos")
    public List<Product> getAllProductos() {
        return serviceProducto.getAllProductos();
    }

    // -- Carrito --

    // Añadir producto al carrito
    @PostMapping("/carritos")
    public String saveCarrito(@RequestParam Long productId) {
        Product product = serviceProducto.getProductoById(productId);
        if (product == null) {
            return "Error: producto no encontrado con id " + productId;
        }

        Carrito carrito = new Carrito(product, 1);
        serviceCarrito.saveCarrito(carrito);

        return "Producto añadido al carrito: " + product.getName();
    }

    // Ver carrito por ID
    @GetMapping("/carritos/{id}")
    public Carrito getCarritoById(@PathVariable Long id) {
        Carrito carrito = serviceCarrito.getCarritoById(id);
        if (carrito == null) {
            throw new RuntimeException("Carrito no encontrado con id: " + id);
        }

        return carrito;
    }

    // Ver todos los carritos
    @GetMapping("/carritos")
    public List<Carrito> getAllCarritos() {
        return serviceCarrito.getAllCarritos();
    }

    // Eliminar carrito
    @DeleteMapping("/carritos/{id}")
    public String deleteCarrito(@PathVariable Long id) {
        Carrito carrito = serviceCarrito.getCarritoById(id);
        if (carrito == null) {
            return "Error: no existe carrito con id " + id;
        }

        serviceCarrito.deleteCarrito(id);
        return "Carrito eliminado correctamente";
    }
}
