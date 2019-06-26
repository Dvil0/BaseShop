package dv.android.com.baseshop.dto;

public class EmpresaUsuarioDTO {
    private Long idEmpresaUsuario;
    private Long idEmpresa;
    private Long idUsuario;
    private String estado;
    private String fechaCreacion;

    //Getter and Setter Methods.
    public Long getIdEmpresaUsuario() {
        return idEmpresaUsuario;
    }

    public void setIdEmpresaUsuario(Long idEmpresaUsuario) {
        this.idEmpresaUsuario = idEmpresaUsuario;
    }

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
