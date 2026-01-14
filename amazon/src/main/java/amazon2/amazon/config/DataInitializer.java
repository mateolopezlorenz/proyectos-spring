package amazon2.amazon.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import amazon2.amazon.models.Usuario;
import amazon2.amazon.models.Product;
import amazon2.amazon.models.Carrito;

import amazon2.amazon.service.ServiceUsuario;
import amazon2.amazon.service.ServiceProducto;
import amazon2.amazon.service.ServiceCarrito;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private ServiceUsuario serviceUsuario;

    @Autowired
    private ServiceProducto serviceProducto;

    @Autowired
    private ServiceCarrito serviceCarrito;

    @Override
    public void run(String... args) throws Exception {
        // --- Usuarios ---
        Usuario usuario = new Usuario();
        usuario.setNombre("admin");
        usuario.setPassword("{noop}1234"); // {noop} para contraseña sin codificar
        serviceUsuario.saveUsuario(usuario);

        // --- Productos ---
        Product producto1 = new Product();
        producto1.setName("iPhone 13");
        producto1.setPrice(3499.99);
        serviceProducto.saveProducto(producto1);

        Product producto2 = new Product();
        producto2.setName("Samsung Galaxy S21");
        producto2.setPrice(2999.99);
        serviceProducto.saveProducto(producto2);

        Product producto3 = new Product();
        producto3.setName("MacBook Pro");
        producto3.setPrice(7599.99);
        serviceProducto.saveProducto(producto3);

        // --- Carritos ---
        Carrito carrito1 = new Carrito(producto1, 1);
        serviceCarrito.saveCarrito(carrito1);

        Carrito carrito2 = new Carrito(producto2, 2);
        serviceCarrito.saveCarrito(carrito2);

        System.out.println("Datos iniciales creados: usuario, productos y carritos.");
    }
}
