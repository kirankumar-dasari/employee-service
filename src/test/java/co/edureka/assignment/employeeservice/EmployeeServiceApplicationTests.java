package co.edureka.assignment.employeeservice;

import co.edureka.assignment.employeeservice.controller.EmployeeController;
import co.edureka.assignment.employeeservice.data.Employee;
import co.edureka.assignment.employeeservice.service.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(value = EmployeeController.class, secure = false)
public class EmployeeServiceApplicationTests {

    private MockMvc mockMvc;

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    @Before
    public void init() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }

    @Test
    public void testGetAllEmployees() throws Exception {

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee(10, "emp10", "designation5", 600000));

        Mockito.when(employeeService.findAll()).thenReturn(employees);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employees").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "[{id: 10, name: emp10, designation: designation5, salary: 600000}]";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);

    }

}
