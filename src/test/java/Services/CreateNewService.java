package Services;

import org.testng.annotations.Test;

import com.generic.utilities.BaseClass;

import object.repository.HomePage;

public class CreateNewService extends BaseClass{

	@Test
	public void createNewServices() {
		HomePage hp=new HomePage(d);
		hp.clickOnServicesLinkText(d);
		
	}
}
