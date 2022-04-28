package conexionBBDD;

import java.sql.SQLException;

public class ejercicio6 {
	
	public static void main(String[] args) {
		
		conexion_BBDD conexion = new conexion_BBDD();

		conexion.conectar();
		
		try {
			conexion.ejercutarUpdate_ConsultaPreparadaEj6("update clientes_taller set direccion = 'Esquina, 76' where ncliente=18");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		
	}

}
