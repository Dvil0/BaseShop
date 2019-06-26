package dv.android.com.baseshop.dto;

public class CalificacionDTO {
    private Long idCalificacion;
    private Long idUsuarioCalifica; //Uusuario que califica.
    private Long idUsuarioCalificado; //Usuario calificado.
    private Long rating; //(5/5)
    private String fechaCreacion;

    //Getter and Setter Methods.
    public Long getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(Long idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public Long getIdUsuarioCalifica() {
        return idUsuarioCalifica;
    }

    public void setIdUsuarioCalifica(Long idUsuarioCalifica) {
        this.idUsuarioCalifica = idUsuarioCalifica;
    }

    public Long getIdUsuarioCalificado() {
        return idUsuarioCalificado;
    }

    public void setIdUsuarioCalificado(Long idUsuarioCalificado) {
        this.idUsuarioCalificado = idUsuarioCalificado;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
