package cyber;

import dbConnect.dbconnect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import net.proteanit.sql.DbUtils;

public class displayMember extends javax.swing.JPanel {

    Connection con=null;
    JScrollPane sp;
    DefaultTableModel dtm;
    public displayMember() {
        initComponents();
        setValue();
    }
    private void setValue(){
    
        con=dbconnect.getDBConnection();
        int noofrows=0;
        try{
        
            Statement st=con.createStatement();
            String sql="select * from tbl_member";
            ResultSet rs=st.executeQuery(sql);
            rs.last();
            noofrows=rs.getRow();
        }catch(Exception e){
        
            JOptionPane.showConfirmDialog(null, e);
        }
        
        String[] cols={"ID","Name","Gender","Phone","Email","Address","Date"};
        dtm=new DefaultTableModel(cols,noofrows);
        jTable1.setModel(dtm);
        
        try{
        
            Statement st1=con.createStatement();
            String sql1="select * from tbl_member";
            ResultSet rs1=st1.executeQuery(sql1);
            int x=0;
            while(rs1.next()){
            
                jTable1.setValueAt(rs1.getString(1),x,0);
                jTable1.setValueAt(rs1.getString(2),x,1);
                jTable1.setValueAt(rs1.getString(3),x,2);
                jTable1.setValueAt(rs1.getString(4),x,3);
                jTable1.setValueAt(rs1.getString(5),x,4);
                jTable1.setValueAt(rs1.getString(6),x,5);
                jTable1.setValueAt(rs1.getString(7),x,6);
                x++;
            }
        }catch(Exception e){
        
            JOptionPane.showMessageDialog(null, e);
        }
        
        TableColumnModel col=jTable1.getColumnModel();
        TableColumn c=col.getColumn(0);
        c.setMaxWidth(0);
        c.setMinWidth(0);
        c.setPreferredWidth(0);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Display Member", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/1420591263_OK.png"))); // NOI18N
        jLabel1.setText("Add");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/1420591308_Settings.png"))); // NOI18N
        jLabel2.setText("Edit");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/1420591154_No.png"))); // NOI18N
        jLabel3.setText("Delete");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel4.setText("Name");

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        jLabel5.setText("Date");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel1)
                        .addGap(53, 53, 53)
                        .addComponent(jLabel2)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(93, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        userFrame.addContentPanel(new addMember());
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        boolean isrowselected=jTable1.getSelectedRowCount()>0;
        if(isrowselected==true){
            
            int selectedRow=jTable1.getSelectedRow();
            Object m_id=jTable1.getValueAt(selectedRow,0);
            userFrame.addContentPanel(new editMember(m_id)); 
        }else{
        
            JOptionPane.showConfirmDialog(this, "Please select a record to edit!!!","Alert",JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
       boolean isrowselected=jTable1.getSelectedRowCount()>0;
       if(isrowselected==true){
       
           int selectedRow=jTable1.getSelectedRow();
           Object m_id=jTable1.getValueAt(selectedRow, 0);
           int confirmdelete=JOptionPane.showConfirmDialog(this,"Are you sure you want to delete this?","Confirm Delete",JOptionPane.YES_NO_OPTION);
           
           if(confirmdelete==0){
           
               if(selectedRow>-1){
               
                   dtm.removeRow(selectedRow);
                   String sql="delete from tbl_member where m_id="+m_id;
               
                   try{
                   
                       Statement st=con.createStatement();
                       
                       st.execute(sql);
                       
                   }catch(Exception e){
                   
                       JOptionPane.showMessageDialog(null, "Data not deleted!!!");
                   }
               }
           }
       }else{
       
           JOptionPane.showConfirmDialog(this, "Please select a record to delete!!","Alert",JOptionPane.PLAIN_MESSAGE);
           
       }
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
          jTable1.repaint();
       try{
       
          Statement st=con.createStatement();
          String sql="select name,gender,phone,email,address,date from tbl_member where name LIKE '"+jTextField1.getText()+"%'";
          ResultSet rs=st.executeQuery(sql);
          jTable1.setModel(DbUtils.resultSetToTableModel(rs));
       }catch(Exception e){
       
           System.out.println("eroor");
       }
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        // TODO add your handling code here
         jTable1.repaint();
       try{
       
          Statement st=con.createStatement();
          String sql="select name,gender,phone,email,address,date from tbl_member where date LIKE '"+jTextField2.getText()+"%'";
          ResultSet rs=st.executeQuery(sql);
          jTable1.setModel(DbUtils.resultSetToTableModel(rs));
       }catch(Exception e){
       
           System.out.println("eroor");
       }
    }//GEN-LAST:event_jTextField2KeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
