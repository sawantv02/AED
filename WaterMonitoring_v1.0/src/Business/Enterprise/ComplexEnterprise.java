/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Building.SensorDirectory;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author vishakha
 */
public class ComplexEnterprise extends Enterprise {
    
    private SensorDirectory sensorDirectory;
    public ComplexEnterprise(String name) {
        super(name, EnterpriseType.Complex);
       
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
}
