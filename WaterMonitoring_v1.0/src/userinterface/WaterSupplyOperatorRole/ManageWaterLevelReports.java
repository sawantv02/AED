/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.WaterSupplyOperatorRole;

import Business.Organization.MaintainanceExecutiveOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WaterPipeLeakWorkRequest;
import Business.WorkQueue.WaterPressureWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.util.HashMap;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author vishakha
 */
public class ManageWaterLevelReports extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private MaintainanceExecutiveOrganization maintainanceExecutiveOrganization;
    
    public ManageWaterLevelReports(JPanel userProcessContainer,UserAccount userAccount,MaintainanceExecutiveOrganization maintainanceExecutiveOrganization) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.userAccount=userAccount;
        this.maintainanceExecutiveOrganization=maintainanceExecutiveOrganization;
        populateReport();
        
    }

        public DefaultTableModel populateReportTable()
    {
        DefaultTableModel model = (DefaultTableModel)tblReport.getModel();
        
        model.setRowCount(0);
        
        for(WorkRequest request : maintainanceExecutiveOrganization.getWorkQueue().getWorkRequestList()){
            if(request instanceof WaterPressureWorkRequest)
            {   
            if(request.getResolveDate()!=null)  
             {    
                Object[] row = new Object[5];
                row[0] = request.toString();
                //row[1] = request.getMessage();
                row[1] = ((WaterPressureWorkRequest)request).getCategory();           
                row[2] = request.getRequestDate().toString();
                row[3] = request.getResolveDate().toString();
                row[4] = request.getAssignedTo() == null ? " " : request.getAssignedTo().getEmployee().getName();

                model.addRow(row);
             }
            }
        }
        return model;
    }
    
    public void populateReport()
    {
        //DefaultTableModel model=populateReportTable();
        JasperPrint jasperPrint = null;
        //TableModelData();
        DefaultTableModel model=populateReportTable();
        try {
            JasperCompileManager.compileReportToFile("Reports/report2.jrxml");
            jasperPrint = JasperFillManager.fillReport("Reports/report2.jasper", new HashMap(),
                    new JRTableModelDataSource(model));
            JasperViewer jasperViewer = new JasperViewer(jasperPrint);
            //jasperViewer.setVisible(true);
            jasperViewer.viewReport(jasperPrint,false);
        } catch (JRException ex) {
            ex.printStackTrace();
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReport = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Report for the raised Cases");

        tblReport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Case ID", "Case Category", "Request Date", "Resolved Date", "Assigned To"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblReport);

        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnBack)
                .addContainerGap(221, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblReport;
    // End of variables declaration//GEN-END:variables
}
