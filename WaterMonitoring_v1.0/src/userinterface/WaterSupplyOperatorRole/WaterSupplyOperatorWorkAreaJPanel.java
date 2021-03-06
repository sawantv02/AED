/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.WaterSupplyOperatorRole;

import Business.EcoSystem;
import Business.Organization.MaintainanceExecutiveOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;
import userinterface.TechnicianRole.ManageTechReportsJPanel;

/**
 *
 * @author vishakha
 */
public class WaterSupplyOperatorWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private MaintainanceExecutiveOrganization maintainanceExecutiveOrganization;
    private EcoSystem business;
    
    public WaterSupplyOperatorWorkAreaJPanel(JPanel userProcessContainer,Organization organization,UserAccount userAccount,EcoSystem business) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.business=business;
        this.userAccount=userAccount;
        this.maintainanceExecutiveOrganization=(MaintainanceExecutiveOrganization)organization;
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
        btnManageWaterSupplyIssues = new javax.swing.JButton();
        ManageWaterLevelReports = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Water Supply Operator Work Area");

        btnManageWaterSupplyIssues.setText("Manage Water Supply Issues");
        btnManageWaterSupplyIssues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageWaterSupplyIssuesActionPerformed(evt);
            }
        });

        ManageWaterLevelReports.setText("Manage Reports");
        ManageWaterLevelReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManageWaterLevelReportsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(ManageWaterLevelReports, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnManageWaterSupplyIssues, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(214, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(74, 74, 74)
                .addComponent(btnManageWaterSupplyIssues)
                .addGap(42, 42, 42)
                .addComponent(ManageWaterLevelReports)
                .addContainerGap(297, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageWaterSupplyIssuesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageWaterSupplyIssuesActionPerformed
        ManageWaterSupplyIssuesJPanel manageWaterSupplyIssuesJPanel= new ManageWaterSupplyIssuesJPanel(userProcessContainer,maintainanceExecutiveOrganization,userAccount);
        userProcessContainer.add("manageWaterSupplyJPanel", manageWaterSupplyIssuesJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageWaterSupplyIssuesActionPerformed

    private void ManageWaterLevelReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageWaterLevelReportsActionPerformed
        ManageWaterLevelReports manageWaterLevelReports= new ManageWaterLevelReports(userProcessContainer,userAccount,maintainanceExecutiveOrganization);
//        userProcessContainer.add("manageWaterLevelReportsJPanel", manageWaterLevelReports);
//        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
//        layout.next(userProcessContainer);
    }//GEN-LAST:event_ManageWaterLevelReportsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ManageWaterLevelReports;
    private javax.swing.JButton btnManageWaterSupplyIssues;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
