/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.MonitoringSupervisorRole;


import Business.Employee.Resident;
import Business.Validator;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author vishakha
 */
public class ViewResidentsProfileJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Resident resident;
    public ViewResidentsProfileJPanel(JPanel userProcessContainer,Resident resident) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.resident=resident;

        txtName.setText(resident.getName());
        txtApartment.setText(String.valueOf(resident.getApartment()));
        txtContactNumber.setText(String.valueOf(resident.getPhoneNumber()));
        txtEmail.setText(resident.getEmail());
        txtFloor.setText(resident.getFloor());
        
    }

    @SuppressWarnings("unchecked")
    
    public boolean validateFields()
    {
        boolean flag=false;
        boolean check[]=new boolean[5];
        boolean falseList[]=new boolean[5];
        int count=0;
        int run=0;
       Validator validator=new Validator();
       check[0]=validator.validateEmail(txtEmail.getText());
       check[1]=validator.validateNumber(txtApartment.getText());
       check[2]=validator.validateNumber(txtFloor.getText());
       check[3]=validator.validateLetters(txtName.getText());
       check[4]=validator.validatePhoneNumber(txtContactNumber.getText());
       
       for(int i=0;i<check.length;i++)
       {
           if(check[i])
               count++;               
       }
 
       if(count==5)
           flag=true;
       
       return flag;
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtFloor = new javax.swing.JTextField();
        txtApartment = new javax.swing.JTextField();
        txtContactNumber = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Residents Profile");

        txtEmail.setEnabled(false);

        txtName.setEnabled(false);

        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel2.setText("Name");

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jLabel3.setText("Floor");

        jLabel4.setText("Apartment");

        jLabel5.setText("Contact Number");

        jLabel6.setText("Email Address");

        txtFloor.setEnabled(false);

        txtApartment.setEnabled(false);
        txtApartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApartmentActionPerformed(evt);
            }
        });

        txtContactNumber.setEnabled(false);

        btnSave.setText("Save");
        btnSave.setEnabled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(85, 85, 85)
                        .addComponent(btnUpdate)
                        .addGap(64, 64, 64)
                        .addComponent(btnSave))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2))
                        .addGap(88, 88, 88)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFloor)
                            .addComponent(txtApartment)
                            .addComponent(txtContactNumber)
                            .addComponent(txtEmail)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1))
                .addContainerGap(183, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(txtFloor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtApartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnUpdate)
                    .addComponent(btnSave))
                .addContainerGap(85, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ManageResidentsJPanel dwjp = (ManageResidentsJPanel) component;
        dwjp.populateResidentsTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtApartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApartmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApartmentActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        txtApartment.setEnabled(true);
        txtContactNumber.setEnabled(true);
        txtEmail.setEnabled(true);
        txtFloor.setEnabled(true);
        txtName.setEnabled(true);
        btnSave.setEnabled(true);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
       
       boolean flag=validateFields();
       if(flag) 
       {    
       resident.setApartment(Integer.parseInt(txtApartment.getText()));
       resident.setEmail(txtEmail.getText());
       resident.setFloor(txtFloor.getText());
       resident.setName(txtName.getText());
       resident.setPhoneNumber(String.valueOf(txtContactNumber.getText()));
       btnUpdate.setEnabled(false);
       txtApartment.setEnabled(false);
       txtContactNumber.setEnabled(false);
       txtEmail.setEnabled(false);
       txtFloor.setEnabled(false);
       txtName.setEnabled(false);
       
       JOptionPane.showMessageDialog(null,"Resident Updated Successfully");
       btnSave.setEnabled(false);
       btnUpdate.setEnabled(true);
       }
       
       else
       {
           JOptionPane.showMessageDialog(null,"Invalid Input!");
       } 
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtApartment;
    private javax.swing.JTextField txtContactNumber;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFloor;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
