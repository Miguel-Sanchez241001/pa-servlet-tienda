package pe.edu.autonoma.tienda.entity;

public class Producto {
    private Integer id;
    private String descripcion;
    private Integer stock;
    private String marca;
    private String categoria;

    public Producto(String descripcion, Integer stock, String marca, String categoria) {
        this.descripcion = descripcion;
        this.stock = stock;
        this.marca = marca;
        this.categoria = categoria;
    }

    public Producto(Integer id, String descripcion, Integer stock, String marca, String categoria) {
        this.id = id;
        this.descripcion = descripcion;
        this.stock = stock;
        this.marca = marca;
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
