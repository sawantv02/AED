/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author vishakha
 */
public class EnterpriseDirectory {
    
    private ArrayList<Enterprise> enterpriseList;
    
    public EnterpriseDirectory(){
      enterpriseList=new ArrayList<>();
    }
    
    public Enterprise createEnterprise(String name,Enterprise.EnterpriseType type){
        Enterprise enterprise=null;
        if(type==Enterprise.EnterpriseType.Complex){
            enterprise=new ComplexEnterprise(name);
            enterpriseList.add(enterprise);
        }
        return enterprise;
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }
    
    public boolean checkIfEnterpriseUnique(String name)
    {
        for(Enterprise enterprise:getEnterpriseList())
        {
            if(enterprise.getName().equals(name))
             return true;
        }
        return false;
    }
}
