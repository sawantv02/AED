/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.MonitoringSupervisorRole;

import Business.Building.Building;
import Business.Enterprise.ComplexEnterprise;
import Business.Enterprise.Enterprise;
import Business.Building.Sensor;
import Business.Building.SensorDirectory;
import Business.Building.SensorDirectory.SensorType;
import Business.Organization.BuildingOrganization;
import Business.Organization.MaintainanceExecutiveOrganization;
import Business.Organization.MonitoringExecutivesOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WorkQueue;
import Business.WorkQueue.WorkQueue.RequestType;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import static java.rmi.server.LogStream.log;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vishakha
 */
public class MonitoringTasksJPanel extends javax.swing.JPanel implements ListSelectionListener{

    private JPanel userProcessContainer;
    private WorkQueue workQueue;
    private UserAccount userAccount;
    private MonitoringExecutivesOrganization monitoringExecutivesOrganization;
    private ComplexEnterprise buildingEnterprise;
    private BuildingOrganization buildingOrganization;
    
    public MonitoringTasksJPanel(JPanel userProcessContainer,UserAccount userAccount,Organization organization,Enterprise enterprise) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.userProcessContainer=userProcessContainer;
        this.userAccount=userAccount;
        this.monitoringExecutivesOrganization=(MonitoringExecutivesOrganization)organization;
        this.buildingEnterprise=(ComplexEnterprise)enterprise;
        tblSensorsOutput.getSelectionModel().addListSelectionListener(this);

       
        for(Organization org:enterprise.getOrganizationDirectory().getOrganizationList())
        {
            if(org instanceof BuildingOrganization)
            {
                buildingOrganization=(BuildingOrganization)org;
            }
        }
        
        //Sensor s=new Sensor();
        //buildingEnterprise.getSensorDirectory().getSensorList();
        
        populateRequestTypeComboBox();
        populateCasesComboBox();
    }

    
    public void populatePHSensorReading()
    {
      Random randomGenerator=new Random();
      for(Building building:buildingOrganization.getBuildingDirectory().getBuildingList()){
      for(Sensor sensor:building.getSensorDirectory().getSensorList())
      {
          if(sensor.getSensorType().equals(SensorType.PH.getValue()))
          {
            for (int idx = 1; idx <= 2; ++idx){
             int randomInt = randomGenerator.nextInt(15);        
                 sensor.setSensorReading(randomInt);
             }     
          }
      }
      }
    }
    public void populatePressureSensorReadings()
    {
       Random randomGenerator = new Random();
       int min=40;
       int max=60;
       for(Building building:buildingOrganization.getBuildingDirectory().getBuildingList()){
       for(Sensor sensor:building.getSensorDirectory().getSensorList()){
           if(sensor.getSensorType().equals(SensorType.Pressure.getValue()))
           {    
            for (int idx = 1; idx <= 10; ++idx){
             int randomInt = randomGenerator.nextInt((max-min)+1)+min;        
                 sensor.setSensorReading(randomInt);
             }   
           }
        }
       }
    }
    
    public void populateQuantitySensorReading()
    {
      Random randomGenerator = new Random();
       int min=90;
       int max=122;
       for(Building building:buildingOrganization.getBuildingDirectory().getBuildingList()){
       for(Sensor sensor:building.getSensorDirectory().getSensorList()){
           if(sensor.getSensorType().equals(SensorType.Quantity.getValue()))
           {    
            //for (int idx = 1; idx <= 10; ++idx){
             int randomInt = randomGenerator.nextInt((max-min)+1)+min;        
                 sensor.setSensorReading(randomInt);
             //}   
           }
        }
       }
      
    }
    public void populateTableSensorOutput()
    {
      boolean flag=false; 
      int count=0;
      populatePHSensorReading();
      populatePressureSensorReadings();
      populateQuantitySensorReading();
      DefaultTableModel model = (DefaultTableModel)tblSensorsOutput.getModel();
        
        model.setRowCount(0);
       for(Building building:buildingOrganization.getBuildingDirectory().getBuildingList()){        
       for(Sensor sensor:building.getSensorDirectory().getSensorList()){
           if(sensor.getSensorType().equals(SensorType.PH.getValue()))
              flag=building.getSensorDirectory().checkPHValidity(sensor);
            
           if(sensor.getSensorType().equals(SensorType.Pressure.getValue())) 
           { 
              if(sensor.getLocation().contains("#"))
              flag=building.getSensorDirectory().checkLeakPressure(sensor);              
           } 
           if(sensor.getSensorType().equals(SensorType.Quantity.getValue()))
           {
               flag=building.getSensorDirectory().checkQuantity(sensor);
           }
            if(flag==true)
            {
            Object[] row = new Object[5];
            row[0] = sensor;
            row[1] = sensor.getSensorType();
            row[2] = sensor.getLocation();
            row[3] = sensor.getSensorReading();  
            row[4] = building;
            model.addRow(row);
            }
        } 
       }
    }
    
    public void populateRequestTypeComboBox()
    {
        RequestTypeComboBox.removeAllItems();
        for (RequestType type : WorkQueue.RequestType.values()){
                RequestTypeComboBox.addItem(type);
        }
    }
    
    public void populateCasesComboBox()
    {
        casesComboBox.removeAllItems();
        for (RequestType type : WorkQueue.RequestType.values()){
            casesComboBox.addItem(type);
        }
    }
    
    public void populateTableCases(RequestType type)
    {
       
        DefaultTableModel model = (DefaultTableModel)tblCases.getModel();
        
        model.setRowCount(0);
        
        for(WorkRequest request :userAccount.getWorkQueue().getWorkRequestList()){
           if(type!=null)
           {    
           if(request.getClass().getName().contains(type.getValue()))
            {
            Object[] row = new Object[6];
            row[0] = request;
            row[1] = request.getRequestDate();
            row[2] = request.getAssignedTo() == null ? null : request.getAssignedTo().getEmployee().getName();
            row[3] = request.getResolveDate();
            //request.setStatus("waiting");
            row[4] = request.getStatus()== null ? "waiting" : request.getStatus();
            row[5]=request.getMessage();

            
            
            model.addRow(row);

            }
           }
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

        btnStartSensors = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSensorsOutput = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        RequestTypeComboBox = new javax.swing.JComboBox();
        btnAssign = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        casesComboBox = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCases = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnMoreDetails = new javax.swing.JButton();

        btnStartSensors.setBackground(new java.awt.Color(255, 51, 0));
        btnStartSensors.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnStartSensors.setForeground(new java.awt.Color(0, 255, 0));
        btnStartSensors.setText("Start the Sensors");
        btnStartSensors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartSensorsActionPerformed(evt);
            }
        });

        tblSensorsOutput.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SensorID", "Sensor Type", "Location", "Sensor Reading", "Building Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblSensorsOutput);

        jLabel1.setText("Type of Request");

        RequestTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAssign.setText("Assign");
        btnAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignActionPerformed(evt);
            }
        });

        jLabel2.setText("Assigned Cases");

        casesComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        casesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casesComboBoxActionPerformed(evt);
            }
        });

        tblCases.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CaseID", "Request Date", "Assigned Person", "Resolved Date", "Status", "Message"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblCases);

        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnMoreDetails.setText("More details");
        btnMoreDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoreDetailsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(casesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(55, 55, 55)
                                .addComponent(RequestTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(60, 60, 60)
                        .addComponent(btnAssign))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(btnBack)
                        .addGap(208, 208, 208)
                        .addComponent(btnMoreDetails))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnStartSensors))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(btnStartSensors)
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(RequestTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAssign))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(casesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnMoreDetails))
                .addContainerGap(66, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignActionPerformed
       
        DefaultTableModel model = (DefaultTableModel)tblSensorsOutput.getModel();
        int selectedRow = tblSensorsOutput.getSelectedRow();
        
        if (selectedRow < 0){
            return;
        }
        
        Organization org = null;
        for (Organization organization : buildingEnterprise.getOrganizationDirectory().getOrganizationList()){
            if (organization instanceof MaintainanceExecutiveOrganization){
                org = organization;
                break;
            }
        }
        if (org!=null){
            Sensor sensordata=(Sensor)tblSensorsOutput.getValueAt(selectedRow,0);
            RequestType type=(RequestType)RequestTypeComboBox.getSelectedItem();
            WorkRequest request=userAccount.getWorkQueue().createWorkRequest(type);
            request.setLocation(sensordata.getLocation());
            Building build=(Building)tblSensorsOutput.getValueAt(selectedRow,4);
            request.getBuilding().setBuildingName(build.getBuildingName());
            org.getWorkQueue().getWorkRequestList().add(request);
            //userAccount.getWorkQueue().getWorkRequestList().add(request);
            casesComboBox.setSelectedItem(type);
            model.removeRow(selectedRow);
            populateTableCases(type);
            if(tblSensorsOutput.getRowCount()!=0)
            tblSensorsOutput.setRowSelectionInterval(0,0);
            
        }
        
    }//GEN-LAST:event_btnAssignActionPerformed

    private void casesComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casesComboBoxActionPerformed
        RequestType type=(RequestType)casesComboBox.getSelectedItem();
        populateTableCases(type);
    }//GEN-LAST:event_casesComboBoxActionPerformed

    private void btnMoreDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoreDetailsActionPerformed
       int selectedRow = tblCases.getSelectedRow();
        
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null,"Select the row to see the details");
            return;
        }
        RequestType type=(RequestType)casesComboBox.getSelectedItem();
        WorkRequest request=(WorkRequest)tblCases.getValueAt(selectedRow,0);
        CaseDetailsJPanel caseDetailsJPanel=new CaseDetailsJPanel(userProcessContainer,request,type);
        userProcessContainer.add("CaseDetailsJPanel",caseDetailsJPanel);
        CardLayout cardLayout=(CardLayout)userProcessContainer.getLayout();
        cardLayout.next(userProcessContainer);
              
    }//GEN-LAST:event_btnMoreDetailsActionPerformed

    private void btnStartSensorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartSensorsActionPerformed
      populateTableSensorOutput();
      
    }//GEN-LAST:event_btnStartSensorsActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox RequestTypeComboBox;
    private javax.swing.JButton btnAssign;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnMoreDetails;
    private javax.swing.JButton btnStartSensors;
    private javax.swing.JComboBox casesComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblCases;
    private javax.swing.JTable tblSensorsOutput;
    // End of variables declaration//GEN-END:variables

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int selectedRow = tblSensorsOutput.getSelectedRow();
        if(selectedRow<0)
            return;
        else
        {    
        Sensor s=(Sensor)tblSensorsOutput.getValueAt(selectedRow,0);
        if(s.getSensorType().equals(SensorType.PH.getValue()))
            RequestTypeComboBox.setSelectedItem(RequestType.WaterQualityWorkRequest);
        if(s.getSensorType().equals(SensorType.Pressure.getValue()))
            RequestTypeComboBox.setSelectedItem(RequestType.WaterPipeLeakWorkRequest);
        if(s.getSensorType().equals(SensorType.Quantity.getValue()))
            RequestTypeComboBox.setSelectedItem(RequestType.WaterPressureWorkRequest);
        }
    }



    
   
}
