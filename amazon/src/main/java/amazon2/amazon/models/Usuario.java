package amazon2.amazon.models;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios", uniqueConstraints = {
    @UniqueConstraint(columnNames = "nombre")
})
public class Usuario {
    
    //Atributos
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, unique = true)
    private String nombre;

    @Column(name = "password", nullable = false, unique = false)
    private String password;


    //Constructores
    public Usuario() {
    }

    public Usuario(Long id, String nombre, String password) {
        this.id = id;
        this.nombre = nombre;
        this.password = password;
    }


    //Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    //toString
    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nombre=" + nombre + ", password=" + password + "]";
    }
}
