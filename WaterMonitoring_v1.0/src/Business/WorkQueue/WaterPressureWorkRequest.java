/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Building.Building;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class WaterPressureWorkRequest extends WorkRequest{
    
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
        caseCategory.add("Water Meter Repair");
        caseCategory.add("Main shut off valve repair");
        caseCategory.add("Pressure Regulator Repair");
        return caseCategory;
    }


    
}
