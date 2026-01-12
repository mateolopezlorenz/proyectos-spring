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


    //Constructor

    public Carrito() {
    }

    public Carrito(Long id, Product product) {
        this.id = id;
        this.product = product;
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
}
