/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class EmployeeDirectory {
    
    private ArrayList<Employee> employeeList;

    public EmployeeDirectory() {
        employeeList = new ArrayList<>();
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }
    
    public Employee createEmployee(String name){
        Employee employee = new Employee();
        employee.setName(name);
        employeeList.add(employee);
        return employee;
    }
    
    public Resident createResident(){
        Resident resident=new Resident();
        employeeList.add(resident);
        return resident;
    }
    
    public boolean checkIfEmpnameIsUnique(String empname){
        for (Employee emp: getEmployeeList()){
            if (emp.getName().equals(empname))
                return false;
        }
        return true;
    }
}