/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Building.Building;
import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author raunak
 */
public abstract class WorkRequest {

    private String message;
    private UserAccount assignedTo;
    //private String [] statusList= {"Assigned","Work in Progress","On Hold","Completed"};
    private String status;
    private Date requestDate;
    private Date resolveDate;
    private int caseID;
    private static int count=0;
    private String location;
    private Building building;
    
    public WorkRequest(){
        requestDate = new Date();
        count++;
        caseID=count;
        building=new Building();
    }

    public int getCaseID() {
        return caseID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public UserAccount getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(UserAccount assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    public String[] getStatusList() {
        String [] statusList= {"Assigned","Work in Progress","On Hold","Completed"};
        System.out.println(statusList[0]);
        return statusList;
    }

    public Building getBuilding() {
        return building;
    }

    
    @Override
    public String toString() {
        return String.valueOf(caseID);
    }
    
    
}
