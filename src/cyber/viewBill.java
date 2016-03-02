/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cyber;

import dbConnect.dbconnect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author seeba
 */
public class viewBill extends javax.swing.JPanel {
    DefaultTableModel dtm;

    /**
     * Creates new form viewBill
     */
    public viewBill() {
        initComponents();
        Connection con=dbconnect.getDBConnection();

        String sql="SELECT c.cu_id as cu_id, cb.title as title  FROM tbl_customer as c, tbl_cabin as cb WHERE c.c_id=cb.c_id AND c.end_time='00:00:00'";
        
        int noofrows=0;
        try{
        
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            rs.last();
            noofrows=rs.getRow();
        }catch(Exception e){
        
            JOptionPane.showConfirmDialog(null, e);
        }
        
        String[] cols={"ID","S.no","Cabin"};
        dtm=new DefaultTableModel(cols,noofrows);
        jTable1.setModel(dtm);
        
        try{
        
            Statement st1=con.createStatement();
            ResultSet rs1=st1.executeQuery(sql);
            int x=0;
            int y=1;
            while(rs1.next()){
            
                jTable1.setValueAt(rs1.getString(1),x,0);
                jTable1.setValueAt(y++,x,1);
                jTable1.setValueAt(rs1.getString(2),x,2);
               
                x++;
            }
        }catch(Exception e){
        
            JOptionPane.showMessageDialog(null, e);
        }
        
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "View Bill", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Pay Bill");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean isrowselected = jTable1.getSelectedRowCount() > 0;
            if(isrowselected==true){
                int selectedRow = jTable1.getSelectedRow();
                Object cu_id= jTable1.getValueAt(selectedRow, 0);	
                userFrame.addContentPanel(new newBill(cu_id));
            }else{
                JOptionPane.showConfirmDialog(this, "Please select a record to edit!!!", "Alert",JOptionPane.PLAIN_MESSAGE);
            }
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}