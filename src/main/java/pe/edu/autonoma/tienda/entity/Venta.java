package pe.edu.autonoma.tienda.entity;

public class Venta {
    private Integer id;
    private Cliente clienteId;
    private Producto productoId;
    private Integer monto;
    private Integer cantidad;
    private String fecha;

    public Venta(Integer id, Cliente clienteId, Producto productoId, Integer monto, Integer cantidad, String fecha) {
        this.id = id;
        this.clienteId = clienteId;
        this.productoId = productoId;
        this.monto = monto;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public Venta(Cliente clienteId, Producto productoId, Integer monto, Integer cantidad, String fecha) {
        this.clienteId = clienteId;
        this.productoId = productoId;
        this.monto = monto;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getClienteId() {
        return clienteId;
    }

    public void setClienteId(Cliente clienteId) {
        this.clienteId = clienteId;
    }

    public Producto getProductoId() {
        return productoId;
    }

    public void setProductoId(Producto productoId) {
        this.productoId = productoId;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
