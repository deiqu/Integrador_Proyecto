package Databases;

import Roles.Rol;
import Roles.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author macac
 */
public class Conexion {

    private Connection con;
    private static final String URL = "jdbc:mysql://localhost:3306/database_policlinico";
    private static final String USUARIO = "root";
    private static final String CONTRASENIA = "";

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASENIA);
    }

    public Conexion() {
        String url = "jdbc:mysql://localhost:3306/database_policlinico";
        String user = "root";
        String pass = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    public Connection getConexion() {
        return con;
    }

    public int ejecutarSentenciaSQL(String strSentenciaSQL) {
        try {
            PreparedStatement pstm = con.prepareStatement(strSentenciaSQL);
            pstm.execute();
            return 1;
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        }
    }

    public ResultSet consultar(String strSentenciaSQL) {
        try {
            PreparedStatement pstm = con.prepareStatement(strSentenciaSQL);
            ResultSet respuesta = pstm.executeQuery();
            return respuesta;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public Usuario autenticarUsuario(String nombreUsuario, String password) {
        String sql = "SELECT * FROM usuarios WHERE nombre = ?";
        try (Connection con = obtenerConexion();
                PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, nombreUsuario);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String passwordGuardada = rs.getString("password");
                String rol = rs.getString("rol");
                if (passwordGuardada.equals(password)) {
                    // Crea un objeto Rol con los datos obtenidos de la base de datos
                    Rol usuarioRol = new Rol(0, rol);
                    // Crea un objeto Usuario y devuelve
                    return new Usuario(nombre, password, usuarioRol);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al autenticar al usuario: " + e.getMessage());
        }
        return null;
    }
}
