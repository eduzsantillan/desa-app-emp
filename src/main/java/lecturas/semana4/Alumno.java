package lecturas.semana4;

public class Alumno {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String documentoIdentidad;
    private String numeroCelular;

    public Alumno(String nombre, String apellidoPaterno, String documentoIdentidad){
        this.nombre= nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.documentoIdentidad = documentoIdentidad;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", documentoIdentidad='" + documentoIdentidad + '\'' +
                ", numeroCelular='" + numeroCelular + '\'' +
                '}';
    }
}
