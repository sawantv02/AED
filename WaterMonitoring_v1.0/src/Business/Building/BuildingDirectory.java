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
public class BuildingDirectory {
    
    private ArrayList<Building> buildingList;

    public BuildingDirectory() {
        buildingList=new ArrayList<>();
    }

    public ArrayList<Building> getBuildingList() {
        return buildingList;
    }
    
    public Building createBuilding()
    {
        Building building=new Building();
        buildingList.add(building);
        return building;
    }
}
