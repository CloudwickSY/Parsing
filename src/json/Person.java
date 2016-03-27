package json;

import java.util.List;

public class Person {
	String firstName, lastName;
	int age;
	Address address;
	List<PhoneNumber> phoneNumbers;

	class Address {
		String streetAddress, city, state;
		int postalCode;

		@Override
		public String toString() {
			return "\"streetAddress\": \"" + this.streetAddress + "\",\n\"city\": \"" + this.city + "\",\n\"state\": \""
					+ this.state + "\",\n\"postalCode\": \"" + this.postalCode + "\"";
		}
	}

	class PhoneNumber {
		String type, number;
		@Override
		public String toString() {
			return "\"type\": \"" + this.type + "\",\n\"number\": \"" + this.number + "\"";
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "fistName: " + firstName+
				"lastName: " + lastName+
				"age: " + age +
				"address: " + address.toString()+
				"phoneNumbers: " + phoneNumbers.toString();
	}
}
