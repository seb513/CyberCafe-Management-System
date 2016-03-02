package cyber;

import dbConnect.dbconnect;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class newBill extends javax.swing.JPanel {
    Connection con=null;
    int cuid=0;
    int member_id=0;
    int c_id=0;
    int customer_id=0;
    String start_time=null;
    String cabin=null;
    String currenttime=null;
    int noofhours=0;
    int tarrif=0;
    long diffHours=0;
    
    public newBill()
    {
        
    }
    public newBill(Object cu_id) {
        initComponents();
        
        Calendar cal = Calendar.getInstance();
    	cal.getTime();
    	SimpleDateFormat osdf1 = new SimpleDateFormat("HH:mm:ss");
    	currenttime=osdf1.format(cal.getTime());
       
        
        con=dbconnect.getDBConnection();
        String sql="SELECT * FROM tbl_customer WHERE cu_id="+cu_id;
        try{
            Statement st1=con.createStatement();
	    ResultSet rs1=st1.executeQuery(sql);
	    int x=0;
	    if(rs1.next()){
                this.cuid=rs1.getInt(1);
                this.member_id=rs1.getInt(2);
                this.c_id=rs1.getInt(3);
                this.customer_id=rs1.getInt(4);
                this.start_time=rs1.getString(5);
                
                DateFormat df1 = new SimpleDateFormat("hh:mm:ss");
                //DateFormat df2 = new SimpleDateFormat("hh:mm:ss");

                try {

                    Date start_dt = df1.parse(this.start_time); 
                    Date current_time=df1.parse(currenttime);
                    long timediff=current_time.getTime() - start_dt.getTime();
                    diffHours = timediff / (60 * 60 * 1000) % 24;
                    diffHours=diffHours+1;
                    //noofhours = Long.toString(diffHours);
                    jLabel12.setText(String.valueOf(diffHours));

                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                           
                String sq="SELECT * FROM tbl_cabin WHERE c_id="+this.c_id;
                try{
                    Statement stq=con.createStatement();
                    ResultSet rq=stq.executeQuery(sq);
                    if(rq.next()){
                        this.cabin=rq.getString(2);
                    }
                }catch(Exception seq){
                    
                }
                
                
            
            }
        }catch(Exception e){
            System.out.println("Not executed");
        }
        
        if(this.member_id==0){
            String sql3="SELECT * FROM tbl_cust_info WHERE ci_id="+this.customer_id;
            try{
                Statement st3=con.createStatement();
                ResultSet rs3=st3.executeQuery(sql3);
                if(rs3.next()){
                    jLabel1.setText(this.cabin);
                    jLabel3.setText(rs3.getString(2));
                    jLabel6.setText(this.start_time);
                    jLabel7.setText(this.currenttime);
                   // System.out.println(sql);

                }
                
            }catch(Exception e1){
                   System.out.println("Customer query not executed");

            }
            
            String msql1="SELECT * FROM tbl_tariff WHERE title='Regular'";
            try{
                Statement mst1=con.createStatement();
                ResultSet mrs1=mst1.executeQuery(msql1);
                if(mrs1.next()){
                    this.tarrif=mrs1.getInt(3);
                }
                
            }catch(Exception me1){
                   System.out.println("Customer tarrif query not executed");

            }
            
        }else{
             String sql4="SELECT * FROM tbl_member WHERE m_id="+this.member_id;
            try{
                Statement st4=con.createStatement();
                ResultSet rs4=st4.executeQuery(sql4);
                if(rs4.next()){
                    jLabel1.setText(this.cabin);
                    jLabel3.setText(rs4.getString(2));
                    jLabel6.setText(this.start_time);
                    jLabel7.setText(this.currenttime);
                }
                
            }catch(Exception e1){
                   System.out.println("Member query not executed");

            }
            
            String msql2="SELECT * FROM tbl_tariff WHERE title='Member'";
            try{
                Statement mst2=con.createStatement();
                ResultSet mrs2=mst2.executeQuery(msql2);
                if(mrs2.next()){
                    this.tarrif=mrs2.getInt(3);
                }
                
            }catch(Exception me2){
                   System.out.println("Member tarrif query not executed");

            }
            
            
        }
        
        jLabel9.setText(String.valueOf(this.diffHours*this.tarrif));
        
        
        
        
        
       // CurrentDate();
       // System.out.println(cu_id);
    }

    
       
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "New Bill", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel2.setText("Cabin No.");

        jLabel4.setText("Name");

        jLabel8.setText("Entry Time");

        jLabel10.setText("Exit Time(HH:MM)");

        jLabel11.setText("Total Time(Hour)");

        jLabel13.setText("Amount");

        jButton2.setText("Save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10))
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(191, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(43, 43, 43))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jButton2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(118, 118, 118))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

            try{
                
                String sqlupdate="UPDATE tbl_customer SET end_time='"+this.currenttime+"'"+" WHERE cu_id="+this.cuid;
                Statement stupdate=con.createStatement();
                stupdate.executeUpdate(sqlupdate);
                
            }catch(Exception e){
                System.out.println("Data Customer Not Updated");
            }
            
             try{
                
                String sqlupdatecabin="UPDATE tbl_cabin SET status='Free' WHERE c_id="+this.c_id;
                Statement stupdate2=con.createStatement();
                stupdate2.executeUpdate(sqlupdatecabin);
                
            }catch(Exception eee){
                System.out.println("Data Cabin Not Updated");
            }      
             
   
             
      PrinterJob job = PrinterJob.getPrinterJob();
            job.setJobName("jPanel1");

            job.setPrintable (new Printable() {    
            
                public int print(Graphics pg, PageFormat pf, int pageNum){
                     if (pageNum > 0){
                     return Printable.NO_SUCH_PAGE;
                     }

            Graphics2D g2 = (Graphics2D) pg;
            g2.translate(pf.getImageableX(), pf.getImageableY());
            jPanel1.paint(g2);
            return Printable.PAGE_EXISTS;
                }
            });
    
            boolean ok = job.printDialog();
     if (ok) {
         try {
              job.print();
         } catch (PrinterException ex) {
         
         }
     }           
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
