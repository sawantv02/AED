/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class WorkQueue {
    
    private ArrayList<WorkRequest> workRequestList;

    public WorkQueue() {
        workRequestList = new ArrayList<>();
    }

    public ArrayList<WorkRequest> getWorkRequestList() {
        return workRequestList;
    }
    
    public enum RequestType{
        WaterQualityWorkRequest("WaterQualityWorkRequest"),
        WaterPressureWorkRequest("WaterPressureWorkRequest"),
        WaterPipeLeakWorkRequest("WaterPipeLeakWorkRequest");
     
        private String value;
        private RequestType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public WorkRequest createWorkRequest(RequestType type)
    {
        WorkRequest request = null;
        if (type.getValue().equals(RequestType.WaterPipeLeakWorkRequest.getValue())){
            request = new WaterPipeLeakWorkRequest();
            workRequestList.add(request);
        }
        else if (type.getValue().equals(RequestType.WaterPressureWorkRequest.getValue())){
            request = new WaterPressureWorkRequest();
            workRequestList.add(request);
        }    
        else if (type.getValue().equals(RequestType.WaterQualityWorkRequest.getValue())){
            request=new WaterQualityWorkRequest();
            workRequestList.add(request);
        }
        return request;
    }
}
