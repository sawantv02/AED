/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Building;

/**
 *
 * @author vishakha
 */
public class Building {
    
    private String buildingName;
    private String buildingNumber;
    private SensorDirectory sensorDirectory;
    
    public Building() {
         sensorDirectory=new SensorDirectory();
    }

    public SensorDirectory getSensorDirectory() {
        return sensorDirectory;
    }
    
    

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    @Override
    public String toString() {
        return buildingName;
    }
    
    
}
