package utilitarios;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Usuario {

    private String nombre;
    private String apellido;
    private String email;
    private int edad;
    private String nroDocumento;

    public Usuario(String nombre, String apellido, String email, int edad, String nroDocumento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.edad = edad;
        this.nroDocumento = nroDocumento;
    }
}
