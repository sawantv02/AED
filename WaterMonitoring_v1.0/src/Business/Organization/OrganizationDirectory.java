/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
      
        if (type.getValue().equals(Type.MonitoringExecutives.getValue())){
            organization = new MonitoringExecutivesOrganization();
            organizationList.add(organization);
        }    
        else if (type.getValue().equals(Type.MaintainanceExecutives.getValue())){
            organization=new MaintainanceExecutiveOrganization();
            organizationList.add(organization);
        }
        else if(type.getValue().equals(Type.Building.getValue())){
            organization=new BuildingOrganization();
            organizationList.add(organization);
        }
        return organization;
    }
    
    public boolean checkIfOrganizationExists(Type type)
    {
        for(Organization org:getOrganizationList()){
            if(org.getName().contains(type.getValue()))
                return false;
        }
        return true;
        
    }
}