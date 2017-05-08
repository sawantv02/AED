/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Building;

import java.util.ArrayList;

/**
 *
 * @author vishakha
 */
public class SensorDirectory {
    
    private ArrayList<Sensor> sensorList;
    private ArrayList<String> sensorLocation;
    private double MAX_PH=9;
    private double MIN_PH=6.5;
    

    public SensorDirectory()
    {
        sensorList=new ArrayList<>();
    }

    public enum SensorType{
        PH("PH"),
        Pressure("Pressure"),
        Quantity("Quantity");
     
        private String value;
        private SensorType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public ArrayList<Sensor> getSensorList() {
        return sensorList;
    }

    public void setSensorList(ArrayList<Sensor> sensorList) {
        this.sensorList = sensorList;
    }
    
    public Sensor createSensor()
    {
        Sensor sensor=new Sensor();
        sensorList.add(sensor);
        return sensor;
    }
    
    public boolean checkPHValidity(Sensor s)
    {
       boolean checkPH=false;
       if(s.getSensorReading()> MAX_PH || s.getSensorReading()<MIN_PH) 
         checkPH=true;  
       return checkPH;
    }
        
    public boolean checkLeakPressure(Sensor s)
    {
      int reading=s.getSensorReading();
      int up=s.getSensorValue()+1;
      int down=s.getSensorValue()-1;
      boolean critical=false;
      if(reading>up || reading<down)
        critical=true;
      return critical;
    }
    
    public Boolean checkQuantity(Sensor consumption)
    {
        //boolean supply=false;
//        int difference=base.getSensorValue()-top.getSensorValue();
//        int readingDifference=base.getSensorReading()-top.getSensorReading();
//        if(readingDifference>0)
//        {
//            if(readingDifference<(difference-1))
//                return top;
//            else
//                if(readingDifference>(difference+1))
//                return base;
//        }
//         return null;
        boolean supply=false;
        int difference=consumption.getSensorReading()-consumption.getSensorValue();
        if(difference>=26)
            supply=true;
        return supply;
    }

    public ArrayList<String> getSensorLocation() {
        sensorLocation=new ArrayList<>();
        sensorLocation.add("TopSensor");
        sensorLocation.add("1F#11");
        sensorLocation.add("2F#21");
        sensorLocation.add("3F#31");
        sensorLocation.add("4F#41");
        sensorLocation.add("5F#51");
        sensorLocation.add("BaseSensor");
        sensorLocation.add("QuantityTopSensor");
        return sensorLocation;
    }
    
    public Sensor checkIfExist(String type,String location)
    {
        for(Sensor sensor:getSensorList())
        {
            if(sensor.getSensorType().equals(type) && sensor.getLocation().equals(location))
                return sensor;
        }
        return null;
    }
    
    
}
