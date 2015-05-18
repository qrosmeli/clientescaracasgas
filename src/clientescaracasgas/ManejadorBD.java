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
            System.out.println("execute");
            while (rset.next()){
                System.out.println(rset.getString(1)+ " " + rset.getString(2));
                model.addRow(new Object[]{rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(8), rset.getString(5), rset.getString(6), rset.getString(7)});
            }   
        }
	
	public static void getClient(ModificarCliente md, int id) {
		
	}
}
