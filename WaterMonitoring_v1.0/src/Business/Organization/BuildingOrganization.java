/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Building.BuildingDirectory;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author vishakha
 */
public class BuildingOrganization extends Organization{

    private BuildingDirectory buildingDirectory;
    public BuildingOrganization() {
        super(Organization.Type.Building.getValue());
        buildingDirectory=new BuildingDirectory();
    }

    public BuildingDirectory getBuildingDirectory() {
        return buildingDirectory;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
       return null;
    }
    
}
