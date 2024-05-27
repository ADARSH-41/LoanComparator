package jdbc.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet resultSet, int i) throws SQLException {

		Employee emp = new Employee();
		emp.setEmpNo(resultSet.getInt("eid"));
		emp.setEName(resultSet.getString("ename"));
		emp.setJob(resultSet.getString("jobrole"));
		emp.setSalary(resultSet.getDouble("salary"));
		emp.setDeptNo(resultSet.getInt("deptno"));
		return emp;
	}

}
