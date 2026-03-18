package utilities;

import com.github.javafaker.Faker;

public class FakerUtility {

	Faker fobj = new Faker();

	public String createRandomUsername() {
		return fobj.name().username();
	}

	public String createRandomPasssword() {
		return fobj.internet().password();
	}

	public String createRandomEmail() {
		return fobj.internet().emailAddress();
	}

	public String createRandomAddress() {
		return fobj.address().fullAddress();
	}

	public String createRandomFullname() {
		return fobj.name().fullName();
	}
}
