/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Building.Building;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author raunak
 */
public class WaterPipeLeakWorkRequest extends WorkRequest{
    
    private String comment;
    private ArrayList<String> caseCat;
    private String category;
    private String description;
  
    
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getCaseCategory() {
        
        caseCat=new ArrayList<String>();
        caseCat.add("Gusher water supply pipe water leaks");
        caseCat.add("Drip and pinhole water supply pipe leaks");
        caseCat.add("A visible water faucet leak ");
        caseCat.add("A hidden water faucet leak");
        caseCat.add("Plumbing drain leaks");
        //System.out.println(caseCat);
        return caseCat;
    }


    

    
    
    
    
}
