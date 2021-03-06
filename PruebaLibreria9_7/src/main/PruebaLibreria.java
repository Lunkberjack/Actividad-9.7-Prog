package main;
/**
 * Prueba del uso correcto de la librería.
 * @author LuciaLM
 * @version 1.0
 */
public class PruebaLibreria {
	public static void main(String[] args) {
		DatabaseConnection conexion = new DatabaseConnection();
		conexion.conectar("jdbc:mysql://127.0.0.1:3307/tiendacoches?user=tiendacoches&password=tiendacoches");
		MetodosSQL metodos = new MetodosSQL(conexion.getConexion());
		
		// Se muestran los coches ordenados de mayor a menor id.
		// Comprobamos que la librería funciona.
		metodos.mostrarRegistrosSinFiltro("coche", "id", "DESC");
	}
}
