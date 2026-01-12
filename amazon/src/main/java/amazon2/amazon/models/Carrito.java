package amazon2.amazon.models;

//import java.util.*;
import jakarta.persistence.*;

@Entity
@Table(
    name = "carrito",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"product_id"})
    }
)

public class Carrito {
  
    //Atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private Integer cantidad = 1;

    //Constructor

    public Carrito() {
    }

    public Carrito(Product product , Integer cantidad) {
        this.product = product;
        this.cantidad = cantidad;
    }

    //Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getCantidad() {
        return cantidad;
    }
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Carrito{id=" + id + ", product=" + product + ", cantidad=" + cantidad + "} <br>";
    }
}
