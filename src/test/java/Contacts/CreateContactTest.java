package Contacts;

import java.io.IOException;
import java.util.Random;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.generic.utilities.BaseClass;

import object.repository.ContactInfoPage;
import object.repository.ContactPage;
import object.repository.CreateNewContactPage;
import object.repository.CreateNewOrganizationPage;
import object.repository.HomePage;
import object.repository.OrganizationInfoPage;
import object.repository.OrganizationsPage;

@Listeners(com.generic.utilities.ListenersImplementation.class)
public class CreateContactTest extends BaseClass {

	@Test(groups = { "SmokeSuit", "RegressionSuit" })
	public void createContactTest() throws IOException {

		String expectedContactPageTitle = putil.getPageTitleFromPropertyFile("expectedContactPageTitle");
		String expectedOrganisationPageTitle = putil.getPageTitleFromPropertyFile("expectedOrganisationTitile");

		HomePage hp = new HomePage(d);

		int r = jutil.getRandom();

		String ORGNAME = eutil.readDataFromExcel("Organisation", 4, 2) + r;
		String INDUSTRY = eutil.readDataFromExcel("Organisation", 4, 3);
		String LASTNAME = eutil.readDataFromExcel("Contact", 4, 2) + r;

		// Create Orgganization
		// Click on Organisation link.

		hp.clickOnOrganizationLink();
		Assert.assertEquals(d.getTitle(), expectedOrganisationPageTitle, "Error : Organisation link click not successful");
		System.out.println(d.getTitle());
		Reporter.log("Organisation link click successful", true);

		// Click on CreateOrgLookUpImg
		OrganizationsPage organizationsPage = new OrganizationsPage(d);
		organizationsPage.clickOnCreateOrgLookUpImg();
		System.out.println(d.getTitle());
		Assert.assertEquals(d.getTitle(), expectedOrganisationPageTitle, "Error");
		Reporter.log("Create Organisation look up IMG link click successful", true);

		// CreateNewOrganizationPage Object
		CreateNewOrganizationPage createNewOrganizationPage = new CreateNewOrganizationPage(d);
		// Enter Orgnization name text field & Select Chemical from drop down list.
		createNewOrganizationPage.createOrgWithIndustry(ORGNAME, INDUSTRY);
		Assert.assertEquals(createNewOrganizationPage.getORGNameTextField().getAttribute("value"), ORGNAME,
				"Error: Organisation is entered not successful");
		Assert.assertEquals(createNewOrganizationPage.getIndustryDropDownList().getAttribute("value"), INDUSTRY,
				"Error: INDUSTRY is entered not successful");
		Reporter.log("Organisation & Industry entered successful", true);

		// Validate
		OrganizationInfoPage organizationInfoPage = new OrganizationInfoPage(d);
		String header = organizationInfoPage.getHeader();
		Assert.assertTrue(header.contains(ORGNAME));
		Reporter.log(ORGNAME + " create successfully...!", true);

		// click on contact link
		hp.clickOnContactLink();
		Assert.assertEquals(d.getTitle(), expectedContactPageTitle, "Error: Contacts Page not diplay.");
		System.out.println(d.getTitle());
		Reporter.log("Contacts page display", true);

		// click creat contact look up img.
		ContactPage contactPage = new ContactPage(d);
		contactPage.clickOnCreateContactLookUpImg();
		System.out.println(d.getTitle());
		Assert.assertEquals(d.getTitle(), expectedContactPageTitle, "Error: Contacts page click not Successful");
		Reporter.log("Contacts page click Successful", true);

		// create new contact
		CreateNewContactPage newContactPage = new CreateNewContactPage(d);
		newContactPage.createNewContact(d, LASTNAME, ORGNAME);
		Assert.assertEquals(newContactPage.getLastName().getAttribute("value"), LASTNAME,
				"Error: Lasname & OrgName entered not Successful");
		Reporter.log("Lasname & Orgname entered Successful", true);

		// VALIDATE
		ContactInfoPage infoPage = new ContactInfoPage(d);
		String contactHeaderInfo = infoPage.getContactHeaderInfo();
		Assert.assertTrue(contactHeaderInfo.contains(LASTNAME));
		Reporter.log(LASTNAME + " create successfully...!", true);
	}
}
