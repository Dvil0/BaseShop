package dv.android.com.baseshop.entities;

public class ChatDTO {
    private String idChat;
    private String idUsuarioSolicita;
    private String idUsuarioResponde;
    private String estado;
    private String fechaCreacion;

    //Getter and Setter Methods.
    public String getIdChat() {
        return idChat;
    }

    public void setIdChat(String idChat) {
        this.idChat = idChat;
    }

    public String getIdUsuarioSolicita() {
        return idUsuarioSolicita;
    }

    public void setIdUsuarioSolicita(String idUsuarioSolicita) {
        this.idUsuarioSolicita = idUsuarioSolicita;
    }

    public String getIdUsuarioResponde() {
        return idUsuarioResponde;
    }

    public void setIdUsuarioResponde(String idUsuarioResponde) {
        this.idUsuarioResponde = idUsuarioResponde;
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
