package covidtempchecker.backend;

public class User {
	private String name;
	private long employeeNumber;
	private String department;
	
	public User(String name, long employeeNumber, String department) {
		super();
		this.name = name;
		this.employeeNumber = employeeNumber;
		this.department = department;
	}

	public User() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(long employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", employeeNumber=" + employeeNumber +
				", department='" + department + '\'' +
				'}';
	}
}
