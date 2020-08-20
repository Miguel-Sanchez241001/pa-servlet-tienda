package pe.edu.autonoma.tienda.entity;

public class Cliente {
    private Integer id;
    private String apellidoNombre;
    private String tipoDocumento;
    private String numeroDocumento;
    private String direccion;

    public Cliente(String apellidoNombre, String tipoDocumento, String numeroDocumento, String direccion) {
        this.apellidoNombre = apellidoNombre;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.direccion = direccion;
    }

    public Cliente(Integer id, String apellidoNombre, String tipoDocumento, String numeroDocumento, String direccion) {
        this.id = id;
        this.apellidoNombre = apellidoNombre;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.direccion = direccion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApellidoNombre() {
        return apellidoNombre;
    }

    public void setApellidoNombre(String apellidoNombre) {
        this.apellidoNombre = apellidoNombre;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
