package configuration;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class ConexionBd {
    Connection connection;
    public abstract Connection getConnection() throws SQLException, ClassNotFoundException;
}
