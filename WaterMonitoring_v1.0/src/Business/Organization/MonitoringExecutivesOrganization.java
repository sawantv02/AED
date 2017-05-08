/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;


import Business.Role.MonitoringSupervisorRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class MonitoringExecutivesOrganization extends Organization{

    public MonitoringExecutivesOrganization() {
        super(Organization.Type.MonitoringExecutives.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new MonitoringSupervisorRole());
        return roles;
    }
     
   
    
    
}
