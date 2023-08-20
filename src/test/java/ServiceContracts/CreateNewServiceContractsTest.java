package ServiceContracts;

import org.testng.annotations.Test;

import com.generic.utilities.BaseClass;

import object.repository.HomePage;

public class CreateNewServiceContractsTest extends BaseClass{

	@Test
	public void createNewServiceContractsTest() {
		HomePage hp=new HomePage(d);
		hp.clickOnServiceContractsLinkText(d);
	}
}
