package xml;

import java.util.List;

public class Employee {
	String firstName, lastName;
	int ID, age, salary;
		
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "<Employee ID=" + ID + ">\n"
				+ "\t<Firstname>" + firstName + "</Firstname>\n"
				+ "\t<Lastname>" + lastName + "</Lastname>\n"
				+ "\t<Age>" + age + "</Age>\n"
				+ "\t<Salary>" + 2500 + "</Salary>\n"
				+ "</Employee>;";
	}
	
	
	   
}
