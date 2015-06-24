package ro.chronos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ro.chronos.model.Employee;
import ro.chronos.repository.EmployeeRepository;

import java.util.Collection;

/**
 * Endpoint serving employee information.
 * <p>
 * Created by Alex Macavei on 6/23/15.
 */
@RestController
@RequestMapping("/api/employee")
public class EmployeeEndpoint {

    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping(value = "/whoWorksFor", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Collection<Employee> whoWorksFor(@RequestParam("manager") String aManagerName) {
        return employeeRepository.findForManager(aManagerName);
    }
}
