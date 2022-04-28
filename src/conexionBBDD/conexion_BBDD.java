package conexionBBDD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class conexion_BBDD {

	private String bd = "XE";
	private String login = "TALLER";
	private String password = "TALLER";
	private String url = "jdbc:oracle:thin:@localhost:1521:" + bd;
	java.sql.Statement st = null;
	java.sql.ResultSet rs = null;

	Connection connection = null;

	// CONECTAR CON LA BASE DE DATOS
	public void conectar() {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(url, login, password);
			if (connection != null) {
				System.out.println("Conexion realizada correctamente");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// LEER CONTENIDO TABLA
	public String eQEjercicio1() throws SQLException {

		int ncliente;
		String nombre, direccion = null, telefono = null;
		Date fecha_alta = null;
		String salida = "";

		st = connection.createStatement();
		rs = st.executeQuery("select ncliente,nombre,direccion,telefono,fecha_alta from clientes_taller");
		while (rs.next()) {
			ncliente = rs.getInt("ncliente");
			nombre = rs.getString("nombre");
			direccion = rs.getString("direccion");
			telefono = rs.getString("telefono");
			fecha_alta = rs.getDate("fecha_alta");
			salida += " Numero cliente: " + ncliente + " Nombre: " + nombre + " Direccion: " + direccion + " Telefono: "
					+ telefono + " Fecha alta: " + fecha_alta + "\n";
		}
		return salida;

	}

	// CIERRA CONEXCION
	public void cerrar() throws SQLException {

		if (rs != null)
			rs.close();
		if (st != null)
			st.close();
		if (connection != null)
			connection.close();

	}

	// INSERT
	public void eUEjercicio2(int ncliente, String nombre, String direccion, String telefono, String fecha_alta)
			throws SQLException {

		st = connection.createStatement();
		st.executeUpdate("insert into clientes_taller values(" + ncliente + ",'" + nombre + "','" + direccion + "','"
				+ telefono + "','" + fecha_alta + "')");
	}

	// DELETE
	public void eUEejercicio3(int ncliente) throws SQLException {

		st = connection.createStatement();
		st.executeUpdate("delete from clientes_taller where ncliente='" + ncliente + "'");
		if (st != null) {
			System.out.println("El cliente numero " + ncliente + " ha sido eliminado");
		}

	}

	// UPDATE
	public void eUEjercicio4(String direccion, int ncliente) throws SQLException {

		st = connection.createStatement();
		st.executeUpdate(
				"update clientes_taller set direccion = '" + direccion + "' where ncliente = '" + ncliente + "'");
		if (st != null) {
			System.out.println("El cliente numero " + ncliente + " ha sido modificado con la direccion: " + direccion);
		}
	}

	// CONSULTA PREPARADA

	public void ejercutarConsultaPreparada(String consulta) throws SQLException {

		// consulta: "insert into tabla1 values(?)"
		PreparedStatement ps = connection.prepareStatement(consulta);

		/*
		 * Ejemplos de parametros que empiezan por
		 * 
		 * 1 ps.setInt(1,20); ps.executeUpdate();
		 * 
		 * ps=connection.prepareStatement ("select * from tabla1");
		 * rs=ps.executeQuery();
		 * 
		 * Sacar datos de la consulta
		 * 
		 * while(rs.next()) {
		 * 
		 * syso("valor: = " + rs.getInt(1);
		 * 
		 * ps.close }
		 */

	}
	
	//EJERCICIO5

	public void ejercutarInsert_ConsultaPreparadaEj5(String consulta) throws SQLException {

		// consulta: "insert into tabla1 values(?)"
		PreparedStatement ps = connection.prepareStatement(consulta);

		ps.setInt(1, 11);
		ps.setString(2, "Eduardo");
		ps.setString(3, "Calle cooperacion,29");
		ps.setString(4, "654654654");
		ps.setString(5, "01/01/21");
		ps.executeUpdate();

		ps = connection.prepareStatement("select * from clientes_taller");
		rs = ps.executeQuery();

		while (rs.next()) {

			System.out.println("Numero empleado= " + rs.getInt(1) + " nombre= " + rs.getString(2) + " direccion= "
					+ rs.getString(3) + " telefono= " + rs.getString(4) + " fecha alta= " + rs.getString(5));

		}

		ps.close();

	}
	public void ejercutarDelete_ConsultaPreparadaEj5(String consulta) throws SQLException {
		
		
				// consulta: "insert into tabla1 values(?)"
		PreparedStatement ps = connection.prepareStatement(consulta);
		rs = ps.executeQuery();
		if (rs != null) {
			System.out.println("Cliente borrado");
		}
		ps = connection.prepareStatement("select * from clientes_taller");
		rs = ps.executeQuery();

		while (rs.next()) {

			System.out.println("Numero empleado= " + rs.getInt(1) + " nombre= " + rs.getString(2) + " direccion= "
					+ rs.getString(3) + " telefono= " + rs.getString(4) + " fecha alta= " + rs.getString(5));

		}

		ps.close();

	}
	public void ejercutarUpdate_ConsultaPreparadaEj6(String consulta) throws SQLException {
		
		PreparedStatement ps = connection.prepareStatement(consulta);
		rs = ps.executeQuery();
		if (rs != null) {
			System.out.println("Cliente Actualizado");
		}
		
		ps = connection.prepareStatement("select * from clientes_taller");
		rs = ps.executeQuery();

		while (rs.next()) {

			System.out.println("Numero empleado= " + rs.getInt(1) + " nombre= " + rs.getString(2) + " direccion= "
					+ rs.getString(3) + " telefono= " + rs.getString(4) + " fecha alta= " + rs.getString(5));

		}

		ps.close();
		
		
		
	}
	
	public void consultaNumerosPrimos(String consulta,int numero) throws SQLException{
		
		
		PreparedStatement ps = connection.prepareStatement(consulta);
		ps.setInt(1, numero);
		ps.executeUpdate();
		
		
	
		
	}
	
	public int consultaPrimos(int inicio,int fin) throws SQLException{
		
		int vuelta=0;
		PreparedStatement ps=connection.prepareStatement("select count(*) from numeros_primos where numeros>="+inicio+" and numeros<="+fin);
		rs=ps.executeQuery();
		
		while (rs.next()) {
		vuelta=rs.getInt(1);
		}
		
		ps.close();
		return vuelta;
		
		
	}
	public void numeroPrimoAlto() throws SQLException{
		
		PreparedStatement ps=connection.prepareStatement("select max(numeros) from numeros_primos");
		rs=ps.executeQuery();
		
		while (rs.next()) {
		System.out.println(rs.getInt(1));
		}
		
		ps.close();
	}
	
	public void mediaPrimos() throws SQLException{
		
		PreparedStatement ps=connection.prepareStatement("select numeros from numeros_primos");
		rs=ps.executeQuery();
		
		int media=0;
		
		while (rs.next()) {
		media+=rs.getInt(1);
		}
		
		System.out.println("La meida de los mil primero numeros primos es: " +media/consultaPrimos(0, 1000));
		
		ps.close();
	}
	
	

}