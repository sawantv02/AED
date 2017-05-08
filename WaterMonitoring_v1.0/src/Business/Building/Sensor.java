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
public class Sensor {
    
    private static int count=0;
    private int sensorId;
    private String location;
    private String sensorType;
    private int sensorValue;
    private int sensorReading;

    public Sensor() 
    {
        count++;
        sensorId=count;
    }

    public int getSensorId() {
        return sensorId;
    }
 
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public int getSensorValue() {
        return sensorValue;
    }

    public void setSensorValue(int sensorValue) {
        this.sensorValue = sensorValue;
    }

    public int getSensorReading() {
        return sensorReading;
    }

    public void setSensorReading(int sensorReading) {
        this.sensorReading = sensorReading;
    }

    @Override
    public String toString() {
        return String.valueOf(sensorId);
    }
    
    
}
