package jdbc.dao;

import java.util.List;

import jdbc.model.Employee;

public interface EmpDAO {
	Employee getEmployeeByNo(Integer eno);

	List<Employee> getAllEmployees();

	boolean deleteEmployee(Employee e);

	boolean updateEmployee(Employee e);

	boolean createEmployee(Employee e);
}