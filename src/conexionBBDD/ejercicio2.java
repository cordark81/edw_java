package conexionBBDD;

import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class ejercicio2 {

	/*
	 * Realiza un método que inserte un cliente en la tabla clientes_taller y
	 * muestre de nuevo los resultados para comprobar que se ha insertado
	 * correctamente. Los datos del nuevo cliente serán: 
	 * a. ncliente = 7 b. nombre =
	 * ROBERTO URDIALES c. dirección = GRAN VIA, 17 d. teléfono= 698741256 e.
	 * fecha_alta= 2012/10/10 
	 * 
	 * NOTA: ojo con las comillas y con el formato de la
	 * fecha 
	 * 
	 * NOTA2: utiliza parámetros de E/S en el método para hacerlo más
	 * flexible.
	 */
	
	
	 public static void main(String[] args) {
		 
		 Scanner entrada=new Scanner(System.in);
		 
		 conexion_BBDD conexion = new conexion_BBDD();
		 
		 conexion.conectar();
		 
		 System.out.println("Introduzca Numero cliente");
		 int ncliente=entrada.nextInt();
		 System.out.println("Introduzca Nombre");
		 String nombre=entrada.next();
		 System.out.println("Introduzca direccion");
		 String direccion=entrada.next();
		 System.out.println("Introduzca telefono");
		 String telefono=entrada.next();
		 
			
		 
	
		 try {
			conexion.eUEjercicio2(ncliente, nombre, direccion, telefono,"01/01/21");
			String muestra=conexion.eQEjercicio1();
			System.out.println(muestra);
			conexion.cerrar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		 
	}
	

}
