package Opportunities;

import org.testng.annotations.Test;

import com.generic.utilities.BaseClass;

import object.repository.ContactPage;
import object.repository.CreateNewContactPage;
import object.repository.HomePage;

public class CreateOpportunitiesWithContactsTest extends BaseClass{

	@Test
	public void createOpportunitiesWithContactsTest() {
		
		String LASTNAME="LASTNAME";
		
		HomePage hp=new HomePage(d);
		hp.clickOnContactLink();
		
		ContactPage cp=new ContactPage(d);
		cp.clickOnCreateContactLookUpImg();
		
		CreateNewContactPage cnp=new CreateNewContactPage(d);
		cnp.createNewContact(d, LASTNAME);
	}
	
}
