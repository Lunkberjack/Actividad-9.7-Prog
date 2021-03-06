package main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Clase para enlazar una conexión, desconectarla y devolverla.
 * @author LuciaLM
 * @version 1.0
 * 
 * ENTREGO PROVISIONALMENTE POR SI NO PUEDO ANTES DE LAS 23:59H
 * LA LIBRERÍA NO TENDRÁ TODA LA FUNCIONALIDAD AÚN
 */
public class DatabaseConnection {
	private Connection conexion;
	/**
	 * Registra el driver para JDBC y crea una conexión 
	 * a partir de una cadena de conexión.
	 * @param conexionString
	 * @return false si la conexión no se ha podido establecer, true si sí.
	 */
	public boolean conectar(String conexionString) {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			this.conexion = DriverManager.getConnection(conexionString);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conexion == null ? false : true;
	}
	/**
	 * Cierra la conexión a la base de datos.
	 * @return
	 */
	public boolean desconectar() {
		try {
			this.conexion.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * Devuelve un objeto de tipo Connection (si se ha creado con éxito)
	 * a partir de la cadena de conexión.
	 * @return
	 */
	public Connection getConexion() {
		return this.conexion;
	}
}
