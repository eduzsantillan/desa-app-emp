package lecturas.semana3;

import utilitarios.DBUtilitario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonaDao {

    private final Connection connection;

    public PersonaDao() throws SQLException {
        connection  = DBUtilitario.obtenerConexion();
    }

    public Persona obtenerPersonaPorNombre (String nombre) throws SQLException {
        String query = "select * from persona where upper(nombre) = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, nombre.toUpperCase());
        ResultSet resultSet = preparedStatement.executeQuery();
        Persona persona = new Persona();
        boolean esVacio = true;
        while(resultSet.next()){
            persona.setNombre(resultSet.getString("nombre"));
            persona.setEdad(resultSet.getInt("edad"));
            esVacio = false;
        }
        if(!esVacio){
            return persona;
        }else{
            throw new PersonaNoEncontradaException("La persona con nombre :" + nombre + " no existe");
        }
    }


}
