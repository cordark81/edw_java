package conexionBBDD;

import java.sql.SQLException;

public class ejercicio3 {

	/*
	 * Haz un método para borrar un cliente de la BD y pruébalo para borrar el
	 * cliente insertado anteriormente. Utiliza parámetros de E/S en el método para
	 * hacerlo más flexible.
	 */

	public static void main(String[] args) {

		conexion_BBDD conexion = new conexion_BBDD();

		conexion.conectar();
		try {
			conexion.eUEejercicio3(7);
			conexion.eUEejercicio3(8);
			conexion.cerrar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
