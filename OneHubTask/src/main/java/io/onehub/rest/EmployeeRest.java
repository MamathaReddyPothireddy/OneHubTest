package io.onehub.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.onehub.Employee;
import io.onehub.EmployeeRepository;



@Path("employees")
public class EmployeeRest {
	
	EmployeeRepository employeeRepo=null;
	
	@POST
	@Path("employee")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Employee confirmRide(Employee emp) {
		employeeRepo = new EmployeeRepository();
		return employeeRepo.addEmployee(emp);
		//return emp;
	}
	
	@GET
	public String getRequest(){
		String msg="Rest Task";
		return msg;
	}

}
