package clientescaracasgas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
		//System.out.println("DELETE FROM CLIENTE WHERE ID =" + idx);
		ResultSet rset = stmt.executeQuery("DELETE FROM CLIENTE WHERE ID = " + idx);
	}

	public static void exportDB(String filename) throws ClassNotFoundException, SQLException, IOException {
		final String COMMA_DELIMITER = ";";
		final String NEW_LINE_SEPARATOR = "\n";
		final String FILE_HEADER = "ID;CI;Nombre completo;Numero de Contrato;Tipo de Bombona;Zona;Fecha de contrato;Direccion";
		File f = new File(filename);
		FileWriter fileWriter = new FileWriter(f);
		fileWriter.append(FILE_HEADER);
		fileWriter.append(NEW_LINE_SEPARATOR);
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "CCSGAS", "clientescaracasgas");
		Statement stmt = con.createStatement();
		ResultSet rset = stmt.executeQuery("SELECT * FROM CLIENTE");
		while (rset.next()){
                  fileWriter.append(rset.getString(1));
		  fileWriter.append(COMMA_DELIMITER);
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
                JOptionPane.showMessageDialog(null,"Datos exportados exitosamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void importDB(String filename) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException{
	  BufferedReader br = null;
	  String line = "";
	  String splitBy = ";";
	  Class.forName("oracle.jdbc.driver.OracleDriver");
	  Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "CCSGAS", "clientescaracasgas");
	  Statement d = con.createStatement();
	  br = new BufferedReader(new FileReader(filename));
	  line = br.readLine();
          ResultSet rset = d.executeQuery("SELECT MAX(ID) FROM CLIENTE");
          rset.next();
          //System.out.println(rset.getString(1));
          String seq = rset.getString(1);
          d.executeQuery("DROP SEQUENCE CLIENTE_ID");
          d.executeQuery("DROP TABLE CLIENTE");
          int max = Integer.parseInt(seq);
          d.executeQuery("CREATE TABLE CLIENTE( ID NUMBER NOT NULL PRIMARY KEY,CEDULA VARCHAR2(15),NOMBRE VARCHAR2(100),N_CONT NUMBER,TIPO_BOMB NUMBER,ZONA NUMBER,DIRECCION VARCHAR2(1024),FECHA_CONTRATO VARCHAR2(20))");
	  while ((line = br.readLine()) != null) {
		  String[] col = line.split(splitBy);
		  System.out.println("INSERT INTO CLIENTE VALUES(" + col[0] + " ,'" + col[1] + "', '" + col[2] + "', "+ col[3] + ", "+ col[4] + ", " + col[4] + ", '"+ col[5] + "', '"+ col[6] + "')");
		  d.executeQuery("INSERT INTO CLIENTE VALUES(" + col[0] + " ,'" + col[1] + "', '" + col[2] + "', "+ col[3] + ", "+ col[4] + ", " + col[4] + ", '"+ col[5] + "', '"+ col[6] + "')");
	  }
          //System.out.println("CREATE SEQUENCE CLIENTE_ID START WITH " + seq + " INCREMENT BY 1 MINVALUE 1 MAXVALUE 100000");
          d.executeQuery("CREATE SEQUENCE CLIENTE_ID START WITH " + seq+1 + " INCREMENT BY 1 MINVALUE 1 MAXVALUE 100000");
    }
        
        public static void search(String atributo, String valor, DefaultTableModel model) throws ClassNotFoundException, SQLException{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "CCSGAS", "clientescaracasgas");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rset = null;
            if("ID".equals(atributo) || "Nº Contrato".equals(atributo) || "Bombona".equals(atributo) || "Zona".equals(atributo)){
                System.out.println("SELECT * FROM CLIENTE WHERE " + atributo + " = " + valor);
                try {
                    rset = stmt.executeQuery("SELECT * FROM CLIENTE WHERE " + atributo + " = " + valor);
                } catch (SQLException ex) {
                    Logger.getLogger(ManejadorBD.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null,"Dato invalido","Error",JOptionPane.ERROR_MESSAGE);
                }
            }else{
                System.out.println("SELECT * FROM CLIENTE WHERE " + atributo + " LIKE %" + valor + "%");
                try {
                    rset = stmt.executeQuery("SELECT * FROM CLIENTE WHERE " + atributo + " LIKE '%" + valor + "%'");
                } catch (SQLException ex) {
                    Logger.getLogger(ManejadorBD.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null,"Dato invalido","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
            if(!rset.first()){
                JOptionPane.showMessageDialog(null,"No hay clientes que coincidan con la búsqueda","Informacion",JOptionPane.INFORMATION_MESSAGE);
                
            }else{
                while(model.getRowCount() > 0) model.removeRow(0); 
                rset.previous();
                while (rset.next()){
                    System.out.println(rset.getString(2));
                    model.addRow(new Object[]{rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(8), rset.getString(5), rset.getString(6), rset.getString(7)});
                }
            }
        }
}
