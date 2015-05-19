package clientescaracasgas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luis Arguello
 * @author Rosmeli Quintero
 */
public class ManejadorBD {
	public static void readDB(DefaultTableModel model) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "CCSGAS", "clientescaracasgas");
		Statement stmt = con.createStatement();
		ResultSet rset = stmt.executeQuery("SELECT * FROM CLIENTE");
		while (rset.next()){
				model.addRow(new Object[]{rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(8), rset.getString(5), rset.getString(6), rset.getString(7)});
		}   
	}
	
	public static void getClient(ModificarCliente md, int id) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "CCSGAS", "clientescaracasgas");
		Statement stmt = con.createStatement();
		ResultSet rset = stmt.executeQuery("SELECT * FROM CLIENTE WHERE ID = " + Integer.toString(id));
		while (rset.next()){
		  String ci = rset.getString(2);
		  String ciNum = ci.substring(2);
		  char type = ci.charAt(0);
		  md.setValues(type, ciNum, rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6), rset.getString(8), rset.getString(7));
		}		
	}

	public static void insertClient(String ci, String name, String numcont, int bomb, int zone, String dt, String address) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "CCSGAS", "clientescaracasgas");
		Statement stmt = con.createStatement();
		//System.out.println("INSERT INTO CLIENTE VALUES(CLIENTE_ID.NEXTVAL, '" + ci + "', '" + name + "', " + numcont + ", " + bomb + ", " + zone + ", '" + address + "', '" + dt + "')");
		ResultSet rset = stmt.executeQuery("INSERT INTO CLIENTE VALUES(CLIENTE_ID.NEXTVAL, '" + ci + "', '" + name + "', " + numcont + ", " + bomb + ", " + zone + ", '" + address + "', '" + dt + "')");
	}

	public static void updateClient(int idx, String ci, String name, String numcont, int bomb, int zone, String dt, String address) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "CCSGAS", "clientescaracasgas");
		Statement stmt = con.createStatement();
		//System.out.println("UPDATE CLIENTE SET CEDULA = '" + ci + "', NOMBRE = '" + name + "', N_CONT = " + numcont + ", TIPO_BOMB = " + bomb + ", ZONA = " + zone + ", DIRECCION = '" + address + "', FECHA_CONTRATO = '" + dt + "' WHERE ID = " + idx);
		ResultSet rset = stmt.executeQuery("UPDATE CLIENTE SET CEDULA = '" + ci + "', NOMBRE = '" + name + "', N_CONT = " + numcont + ", TIPO_BOMB = " + bomb + ", ZONA = " + zone + ", DIRECCION = '" + address + "', FECHA_CONTRATO = '" + dt + "' WHERE ID = " + idx);
	}

	public static void deleteClient(int idx) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "CCSGAS", "clientescaracasgas");
		Statement stmt = con.createStatement();
		System.out.println("DELETE FROM CLIENTE WHERE ID =" + idx);
		ResultSet rset = stmt.executeQuery("DELETE FROM CLIENTE WHERE ID = " + idx);
	}

	public static void exportDB(String filename) throws ClassNotFoundException, SQLException, IOException {
		final String COMMA_DELIMITER = ";";
		final String NEW_LINE_SEPARATOR = "\n";
		final String FILE_HEADER = "CI;Nombre completo;Numero de Contrato;Tipo de Bombona;Zona;Fecha de contrato;Direccion";
		File f = new File(filename);
		FileWriter fileWriter = new FileWriter(f);
		fileWriter.append(FILE_HEADER);
		fileWriter.append(NEW_LINE_SEPARATOR);
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "CCSGAS", "clientescaracasgas");
		Statement stmt = con.createStatement();
		ResultSet rset = stmt.executeQuery("SELECT * FROM CLIENTE");
		while (rset.next()){
		  fileWriter.append(rset.getString(2));
		  fileWriter.append(COMMA_DELIMITER);
		  fileWriter.append(rset.getString(3));
		  fileWriter.append(COMMA_DELIMITER);
		  fileWriter.append(rset.getString(4));
		  fileWriter.append(COMMA_DELIMITER);
		  fileWriter.append(rset.getString(5));
		  fileWriter.append(COMMA_DELIMITER);
		  fileWriter.append(rset.getString(6));
		  fileWriter.append(COMMA_DELIMITER);
		  fileWriter.append(rset.getString(8));
		  fileWriter.append(COMMA_DELIMITER);
		  fileWriter.append(rset.getString(7));
		  fileWriter.append(NEW_LINE_SEPARATOR);
		}
		fileWriter.flush();
		fileWriter.close();
	}
}
