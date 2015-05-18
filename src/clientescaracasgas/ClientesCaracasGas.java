package clientescaracasgas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class ClientesCaracasGas extends javax.swing.JFrame {

	public ClientesCaracasGas() throws ClassNotFoundException, SQLException {
		initComponents();
		fillTable();   
	}
	
	public void fillTable() throws ClassNotFoundException, SQLException {
		DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
		while(model.getRowCount() > 0) model.removeRow(0);
		ManejadorBD.readDB(model);
	}

	@SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    dateChooserPanel2 = new datechooser.beans.DateChooserPanel();
    dateChooserDialog1 = new datechooser.beans.DateChooserDialog();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTable1 = new javax.swing.JTable();
    jLabel2 = new javax.swing.JLabel();
    nuevo = new javax.swing.JButton();
    modificar = new javax.swing.JButton();
    eliminar = new javax.swing.JButton();
    jSeparator1 = new javax.swing.JSeparator();
    exportar = new javax.swing.JButton();
    importar = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Clientes Caracas Gas");

    jTable1.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null}
      },
      new String [] {
        "CI", "Nombre", "Nº de Contrato", "Fecha de Contrato", "Tipo de Bombona", "Zona", "Dirección"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
      };
      boolean[] canEdit = new boolean [] {
        false, false, false, false, false, false, false
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jTable1.setRowHeight(20);
    jTable1.setRowMargin(5);
    jScrollPane1.setViewportView(jTable1);
    if (jTable1.getColumnModel().getColumnCount() > 0) {
      jTable1.getColumnModel().getColumn(0).setResizable(false);
      jTable1.getColumnModel().getColumn(1).setResizable(false);
      jTable1.getColumnModel().getColumn(2).setResizable(false);
      jTable1.getColumnModel().getColumn(3).setResizable(false);
      jTable1.getColumnModel().getColumn(4).setResizable(false);
      jTable1.getColumnModel().getColumn(5).setResizable(false);
      jTable1.getColumnModel().getColumn(6).setResizable(false);
    }

    jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
    jLabel2.setText("Sistema para el control de clientes de Caracas Gas");

    nuevo.setText("Nuevo Cliente");
    nuevo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        nuevoActionPerformed(evt);
      }
    });

    modificar.setText("Modificar Cliente");
    modificar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        modificarActionPerformed(evt);
      }
    });

    eliminar.setText("Eliminar Cliente");

    exportar.setText("Exportar Clientes");

    importar.setText("Importar Clientes");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(20, 20, 20)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jLabel2)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                      .addComponent(nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                      .addComponent(modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                      .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 9, Short.MAX_VALUE))
              .addComponent(jSeparator1))
            .addContainerGap())
          .addGroup(layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(importar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(exportar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(19, 19, 19))))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addGap(29, 29, 29)
        .addComponent(jLabel2)
        .addGap(29, 29, 29)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(35, 35, 35)
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(eliminar)
            .addComponent(modificar)
            .addComponent(nuevo)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(exportar)
          .addComponent(importar))
        .addContainerGap(24, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
	  ModificarCliente md = new ModificarCliente(true, -1);
	  md.setVisible(true);
  }//GEN-LAST:event_nuevoActionPerformed

  private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
		ModificarCliente md = new ModificarCliente(false, 0);
		md.setVisible(true);
  }//GEN-LAST:event_modificarActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		/* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Windows".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(ClientesCaracasGas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ClientesCaracasGas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ClientesCaracasGas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ClientesCaracasGas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
        //</editor-fold>
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
                            try {
                                new ClientesCaracasGas().setVisible(true);
                            } catch (ClassNotFoundException ex) {
                                Logger.getLogger(ClientesCaracasGas.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (SQLException ex) {
                                Logger.getLogger(ClientesCaracasGas.class.getName()).log(Level.SEVERE, null, ex);
                            }
			}
		});
	}

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private datechooser.beans.DateChooserDialog dateChooserDialog1;
  private datechooser.beans.DateChooserPanel dateChooserPanel2;
  private javax.swing.JButton eliminar;
  private javax.swing.JButton exportar;
  private javax.swing.JButton importar;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JSeparator jSeparator1;
  private javax.swing.JTable jTable1;
  private javax.swing.JButton modificar;
  private javax.swing.JButton nuevo;
  // End of variables declaration//GEN-END:variables
}
