package Creational;

public class User {
	private final String firstName;		// required
	private final String lastName;		// required
	private final int age;
	private final String phone;
	private final String address;
	
	public User(UserBuilder a){
		this.firstName = a.firstName;
		this.lastName = a.lastName;
		this.age = a.age;
		this.phone = a.phone;
		this.address = a.address;
	}
	
	public static class UserBuilder{
		private final String firstName;
		private final String lastName;
		private int age;
		private String phone;
		private String address;
		
		public UserBuilder(String fName, String lName){
			this.firstName = fName;
			this.lastName = lName;
		}
		
		public UserBuilder age(int age){
			this.age = age;
			return this;
		}
		
		public UserBuilder phone(String phone){
			this.phone = phone;
			return this;
		}
		
		public UserBuilder address(String address){
			this.address = address;
			return this;
		}
		
		public User build(){
			return new User(this);
		}
		
	}
}