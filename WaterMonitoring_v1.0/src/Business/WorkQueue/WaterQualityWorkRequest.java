/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Building.Building;
import java.util.ArrayList;

/**
 *
 * @author vishakha
 */
public class WaterQualityWorkRequest extends WorkRequest{
  
    private String comment;
    private ArrayList<String> caseCategory;
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
     
    
    public ArrayList<String> getCaseCategory()
    {
        caseCategory=new ArrayList<>();
        caseCategory.add("Physical contaminants");
        caseCategory.add("Chemical contaminants");
        caseCategory.add("Biological contaminants");
        caseCategory.add("Radiological contaminants");
        return caseCategory;
    }

    
}
