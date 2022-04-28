package conexionBBDD;

import java.sql.SQLException;

public class ejercicio7 {

	/*
	 * Realiza un programa que inserte en una tabla los números primos del 1 al
	 * 1000. Una vez insertados los datos, realiza las siguientes consultas: a.
	 * Mostrar cuántos números primos existen entre 500 y 1000. b. Mostrar cuántos
	 * números primos existen entre 100 y 900. c. Mostrar cuál es el número primero
	 * más alto. d. Mostrar cuántos números primos existen. e. Mostrar la media de
	 * los números primos.
	 */

	public static void main(String[] args) {

		conexion_BBDD conexion = new conexion_BBDD();

		conexion.conectar();

		/*
		 * try {
		 * 
		 * for (int i = 1; i <=1000; i++) { int contador=0; for (int j = 1; j <=1000;
		 * j++) { if(i%j==0) { ++contador; if (contador>2) { break; } } } if
		 * (contador==2) {
		 * conexion.consultaNumerosPrimos("insert  into numeros_primos values(?)",i); }
		 * 
		 * }
		 */
		try {
			conexion.consultaPrimos(100, 900);
			conexion.numeroPrimoAlto();
			conexion.mediaPrimos();
		}
		

		catch (

		SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
