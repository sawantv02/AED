/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.MonitoringSupervisorRole;
import Business.Role.QualityManagerRole;
import Business.Role.Role;
import Business.Role.TechnicianRole;
import Business.Role.WaterSupplyOperatorRole;
import java.util.ArrayList;

/**
 *
 * @author vishakha
 */
public class MaintainanceExecutiveOrganization extends Organization{
    
    public MaintainanceExecutiveOrganization()
    {
        super(Organization.Type.MaintainanceExecutives.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
    ArrayList<Role> roles = new ArrayList<>();
    roles.add(new WaterSupplyOperatorRole());
    roles.add(new TechnicianRole());
    roles.add(new QualityManagerRole());
    return roles;
    }
    
}
