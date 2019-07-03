package dv.android.com.baseshop.dto;

public class NotificacionDTO {
    private String idNotificacion;
    private String idUsuarioNotifica;
    private String idUsuarioNotificado;
    private String leido;
    private String fechaCreacion;

    //Getter and Setter Methods.
    public String getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(String idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public String getIdUsuarioNotifica() {
        return idUsuarioNotifica;
    }

    public void setIdUsuarioNotifica(String idUsuarioNotifica) {
        this.idUsuarioNotifica = idUsuarioNotifica;
    }

    public String getIdUsuarioNotificado() {
        return idUsuarioNotificado;
    }

    public void setIdUsuarioNotificado(String idUsuarioNotificado) {
        this.idUsuarioNotificado = idUsuarioNotificado;
    }

    public String getLeido() {
        return leido;
    }

    public void setLeido(String leido) {
        this.leido = leido;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
