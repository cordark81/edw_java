package conexionBBDD;

import java.sql.SQLException;

public class ejercicio4 {

	/*
	 * Haz un método que actualice la dirección de un cliente. Pruébalo con el
	 * cliente número 6, de tal forma que la nueva dirección será ESQUINA, 77.
	 */

	public static void main(String[] args) {

		conexion_BBDD conexion = new conexion_BBDD();

		conexion.conectar();
		try {
			conexion.eUEjercicio4("Esquina, 77",6);
			conexion.cerrar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
