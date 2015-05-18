package clientescaracasgas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author UCV
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

	public static void insertClient(String ci, String name, String numcont, int bomb, int zone, String dt, String address) {
		
	}

	public static void updateClient(int idx, String ci, String name, String numcont, int bomb, int zone, String dt, String address) {
		
	}
	
	
}
