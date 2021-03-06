package main;
/**
 * Clase principal para comprobar el correcto funcionamiento de los 
 * métodos que interactúan con la base de datos.
 * 
 * ENTREGO PROVISIONALMENTE POR SI NO PUEDO ANTES DE LAS 23:59H
 * LA LIBRERÍA NO TENDRÁ TODA LA FUNCIONALIDAD AÚN
 * 
 * @author LuciaLM
 * @version 1.0
 */
public class TestMetodos {
	public static void main(String[] args) {
		DatabaseConnection databaseConnection = new DatabaseConnection();
		if(databaseConnection.conectar(
				"jdbc:mysql://127.0.0.1:3307/tiendacoches?user=tiendacoches&password=tiendacoches")) {		
			MetodosSQL metodos = new MetodosSQL(databaseConnection.getConexion());
			
			// Ir descomentando para probar:
			
			// metodos.aniadirFabricante(7, "Subaru");
			// metodos.aniadirCoche(7, "Forester", 20000, 2020, 4000, 7);
			// Se pueden ir modificando con distintas combinaciones de parámetros.
			// metodos.modificarRegistro("coche", "modelo", "Outback", "modelo", "Forester");
			// metodos.modificarRegistro("coche", "km", 45, "km", 500);
			// Descomentar solo un eliminar a la vez, las foreign key no están configuradas ON DELETE CASCADE.
			metodos.eliminarRegistro("coche", "modelo", "Outback");
			metodos.eliminarRegistro("fabricante", "id", 7);
			metodos.mostrarRegistrosSinFiltro("fabricante", "id", "asc");
			// metodos.mostrarRegistrosFiltrando("coche", "id", "Prius", "id", "asc");
		}
	}
}