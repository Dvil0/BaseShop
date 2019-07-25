package dv.android.com.baseshop.entities;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ProductoDTO implements Serializable {
    private Long idProducto;
    private String nombre;
    private String descripcion;
    private Long idTipoProducto;
    private String estado;
    private Long precio;
    private String usuarioCrea;
    private String fechaCreacion;

//Getter and Setter Methods.
    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getIdTipoProducto() {
        return idTipoProducto;
    }

    public void setIdTipoProducto(Long idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
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

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }
}
