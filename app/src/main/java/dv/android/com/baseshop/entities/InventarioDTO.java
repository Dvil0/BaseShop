package dv.android.com.baseshop.entities;

public class InventarioDTO {
    private Long idInventario;
    private String codigoBarras;
    private String codigoQr;
    private Long idUsuario; //Usuario vendedor del producto.
    private String imagenProducto;
    private Long cantidad;
    private Long valorProducto;
    private Long valorIva;
    private Long valorDescuento;
    private String estado;
    private String usuarioCrea;
    private String fechaCreacion;

    //Getter and Setter Methods.
    public Long getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(Long idInventario) {
        this.idInventario = idInventario;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getCodigoQr() {
        return codigoQr;
    }

    public void setCodigoQr(String codigoQr) {
        this.codigoQr = codigoQr;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getImagenProducto() {
        return imagenProducto;
    }

    public void setImagenProducto(String imagenProducto) {
        this.imagenProducto = imagenProducto;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Long getValorProducto() {
        return valorProducto;
    }

    public void setValorProducto(Long valorProducto) {
        this.valorProducto = valorProducto;
    }

    public Long getValorIva() {
        return valorIva;
    }

    public void setValorIva(Long valorIva) {
        this.valorIva = valorIva;
    }

    public Long getValorDescuento() {
        return valorDescuento;
    }

    public void setValorDescuento(Long valorDescuento) {
        this.valorDescuento = valorDescuento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUsuarioCrea() {
        return usuarioCrea;
    }

    public void setUsuarioCrea(String usuarioCrea) {
        this.usuarioCrea = usuarioCrea;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
