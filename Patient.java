
public class Patient {
	
	private String firstName, middleName, lastName;
	private String streetAddress, city, state, phoneNumber, emgContact, emgContactNum;
	private String zipCode;
	
	public Patient()
	{
		
	}
	 public Patient(String givFirstName, String givSecondName, String givLastName)
	 {
		 firstName = givFirstName;
		 middleName = givSecondName;
		 lastName = givLastName;
	 }
	 
	 public String getFirstName()
	 {
		 return firstName;
	 }
	 public void setFirstName(String givFirstName)
	 {
		 firstName = givFirstName;
	 }

	 public String getMiddleName()
	 {
		 return middleName;
	 }
	 public void setMiddleName(String givMiddleName)
	 {
		 middleName = givMiddleName;
	 }

	 public String getLastName()
	 {
		 return lastName;
	 }
	 public void setLastName(String givLastName ) 
	 {
		 lastName = givLastName;
	 }

	 public String getAddress()
	 {
		 return streetAddress;
	 }
	 public void setAddress(String givAddress )
	 {
		 streetAddress = givAddress;
	 }

	 public String getCity()
	 {
		 return city;
	 }
	 public void setCity(String givCity )
	 {
		 city = givCity;
	 }

	 public String getState()
	 {
		 return state;
	 }
	 public void setState(String givState)
	 {
		 state = givState;
	 }

	 public String getZipCode()
	 {
		 return zipCode;
	 }
	 
	 public void setZipCode(String givZipCode) 
	 {
		 zipCode = givZipCode;
	 }

	 public String getPhoneNumber() 
	 {
		 return phoneNumber;
	 }
	 public void setPhoneNumber(String givPhoneNumber) 
	 {
		 phoneNumber = givPhoneNumber;
	 }

	 public String getEmgContactName() 
	 {
		 return emgContact;
	 }
	 
	 public void setEmgContactName(String givName) 
	 {
		 emgContact = givName;
	 }

	 public String getEmgContactNum() 
	 {
		 return emgContactNum;
	 }
	 
	 public void setEmgContactNum(String givNum) 
	 {
		 emgContactNum = givNum;
	 }

	 public String buildFullName()
	 {
		 return firstName + " " + middleName + " " + lastName;
	 }
	 public String buildAddress()
	 {
		 return streetAddress + " " + city + " " + state + " " + zipCode;
	 }
	 public String buildEmergencyContact()
	 {
		 return emgContact + " " + emgContactNum;
	 }
	 @Override
	 
	 public String toString()
	 {
		 return "Name: " + buildFullName() +"\nAddress: " + buildAddress()
		+ "\nPhone Number: " + getPhoneNumber() + "\nEmergency Contact: " + buildEmergencyContact();
	 }
	 public String getLastFirstMiddle() 
	 {
		 return lastName + " " + firstName + " " + middleName;
	 }
	 public boolean hasSameCityState(String city, String state)
	 {
		 if (this.city.equals(city))
		 {
			 if (this.state.equals(state))
			 {
				 return true;
			 }
		 }
		 return false;
	 }
	 public void updateAddress(String street, String city, String state, String zip)
	 {
		 this.streetAddress = street;
		 this.city = city;
		 this.state = state;
		 this.zipCode = zip;
	 }
	 
	 public String getContactSummary()
	 {
		 
		 return "Phone Number: " + phoneNumber + " Emergency Contact: " + buildEmergencyContact();
	 }

	 public boolean isValidPhoneNumber()
	 {
		
		 if (phoneNumber.length() != 12)
		 {
			 return false;
		 }
		 
		 for (int i = 0; i < 12; i++)
		 {
			 if (i == 3 || i == 7)
			 {
				 if (phoneNumber.charAt(i) == '-')
				 {
					 continue;
				 }
				 else
				 {
					 return false;
				 }
			 }
			 else
			 {
				 if (Character.isDigit(phoneNumber.charAt(i)))
				 {
					 continue;
				 }
				 else
				 {
					 return false;
				 }
			 }
		 }
	
		 return true;
	 }
	 
	 public boolean isValidEmgNumber()
	 {
		 if (emgContactNum.length() != 12)
		 {
			 return false;
		 }
		 
		 for (int i = 0; i < 12; i++)
		 {
			 if (i == 3 || i == 7)
			 {
				 if (emgContactNum.charAt(i) == '-')
				 {
					 continue;
				 }
				 else
				 {
					 return false;
				 }
			 }
			 else
			 {
				 if (Character.isDigit(emgContactNum.charAt(i)))
				 {
					 continue;
				 }
				 else
				 {
					 return false;
				 }
			 }
		 }
	
		 return true;
	 }
	 
	 public void updateAddress(String city, String state)
	 {
		 this.city = city;
		 this.state = state;
		 
	 }
	 
}
