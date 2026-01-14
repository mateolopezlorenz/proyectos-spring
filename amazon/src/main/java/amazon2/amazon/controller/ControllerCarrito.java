package amazon2.amazon.controller;

import amazon2.amazon.models.Carrito;
import amazon2.amazon.models.Product;
import amazon2.amazon.service.ServiceCarrito;
import amazon2.amazon.service.ServiceProducto;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<String> saveProducto(@RequestBody Product product) {
        try{
            serviceProducto.saveProducto(product);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Producto añadido correctamente: " + product.getName());
        
        } catch(Exception e){
            return ResponseEntity
                    .status(HttpStatus.UNPROCESSABLE_CONTENT)
                    .body("Error al añadir el producto: " + e.getMessage());
        }
    }

    // Ver todos los productos
    @GetMapping("/productos")
    public List<Product> getAllProductos() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(serviceProducto.getAllProductos())
                .getBody();
    }

    // -- Carrito --

    // Añadir producto al carrito
    @PostMapping("/carritos")
    public String saveCarrito(@RequestParam Long productId) {
        Product product = serviceProducto.getProductoById(productId);
        if (product == null) {

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Error: producto no encontrado con id " + productId)
                    .getBody();
        }

        Carrito carrito = new Carrito(product, 1);
        serviceCarrito.saveCarrito(carrito);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Producto añadido al carrito correctamente: " + product.getName())
                .getBody();
    }

    // Ver carrito por ID
    @GetMapping("/carritos/{id}")
    public Carrito getCarritoById(@PathVariable Long id) {
        Carrito carrito = serviceCarrito.getCarritoById(id);
        if (carrito == null) {
            throw new RuntimeException("Error: no existe carrito con id " + id);
        }

        return carrito;
    }

    // Ver todos los carritos
    @GetMapping("/carritos")
    public List<Carrito> getAllCarritos() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(serviceCarrito.getAllCarritos())
                .getBody();
    }

    // Eliminar carrito
    @DeleteMapping("/carritos/{id}")
    public String deleteCarrito(@PathVariable Long id) {
        Carrito carrito = serviceCarrito.getCarritoById(id);
        if (carrito == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Error: no existe carrito con id " + id)
                    .getBody();
        }

        serviceCarrito.deleteCarrito(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Carrito eliminado correctamente con id " + id)
                .getBody();
    }
}
