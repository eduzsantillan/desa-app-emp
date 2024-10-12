package model;

public class Usuario {
    private String nombresCompletos;
    private String usuario;
    private String password;

    public Usuario(String nombresCompletos, String usuario, String password){
        this.nombresCompletos= nombresCompletos;
        this.usuario= usuario;
        this.password= password;
    }

    public String getNombresCompletos() {
        return nombresCompletos;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }
}
