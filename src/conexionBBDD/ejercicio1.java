package conexionBBDD;

import java.sql.SQLException;

public class ejercicio1 {

	/*
	 * Conéctate a la base de datos y muestra los datos de todos los clientes del
	 * taller. Estructura el código en métodos que te permitan reutilizarlos
	 * posteriormente.
	 */
	
	public static void main(String[] args) {
		
		conexion_BBDD prueba =new conexion_BBDD();
		
		prueba.conectar();
		try {
			prueba.eQEjercicio1();
			prueba.cerrar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}
