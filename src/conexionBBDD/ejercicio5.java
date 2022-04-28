package conexionBBDD;

import java.sql.SQLException;
import java.util.Scanner;

public class ejercicio5 {

	/*
	 * Vuelve a insertar al cliente del ejercicio 2 llamando al método realizado
	 * anteriormente. A continuación, modifica el ejercicio 3 para que ahora el
	 * valor del cliente a borrar se introduzca mediante una consulta preparada en
	 * lugar de meter el valor manualmente. Comprueba que funciona.
	 */

	public static void main(String[] args) {


		conexion_BBDD conexion = new conexion_BBDD();

		conexion.conectar();
		
		try {
			conexion.ejercutarInsert_ConsultaPreparadaEj5("insert into clientes_taller values(?,?,?,?,?)");
			conexion.ejercutarDelete_ConsultaPreparadaEj5("delete from clientes_taller where ncliente=7");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	


}
