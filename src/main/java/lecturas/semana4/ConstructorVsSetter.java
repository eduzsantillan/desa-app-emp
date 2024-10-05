package lecturas.semana4;

public class ConstructorVsSetter {

    public static void main(String[] args){

        Alumno alumno = new Alumno("Jose Eduardo", "Zuñiga", "7326376377");
//        Por aca obtengo apellido Materno y celular

        alumno.setApellidoMaterno("Santillan");
        alumno.setNumeroCelular("91238712837812");

        System.out.println(alumno);

    }
}
