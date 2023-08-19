package Organisation;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.generic.utilities.BaseClass;

import object.repository.CreateNewOrganizationPage;
import object.repository.HomePage;
import object.repository.OrganizationInfoPage;
import object.repository.OrganizationsPage;

@Listeners(com.generic.utilities.ListenersImplementation.class)
public class CreateOrganizationWithChemicalsTest extends BaseClass {

	@Test(groups = { "SmokeSuit", "RegressionSuit" })
	public void createOrganizationWithChemicalsTest() throws EncryptedDocumentException, IOException {

		String expectedOrganisationPageTitle = "Administrator - Organizations - vtiger CRM 5 - Commercial Open Source CRM";

		int r = jutil.getRandom();

		String ORGNAME = eutil.readDataFromExcel("Organisation", 4, 2) + r;
		String INDUSTRY = eutil.readDataFromExcel("Organisation", 4, 3);

		// Click on Organisation link.
		HomePage hp = new HomePage(d);
		hp.clickOnOrganizationLink();
		Assert.assertEquals(d.getTitle(), expectedOrganisationPageTitle, "Error");
		Reporter.log("Organisation link click successful", true);

		// Click on CreateOrgLookUpImg
		OrganizationsPage organizationsPage = new OrganizationsPage(d);
		organizationsPage.clickOnCreateOrgLookUpImg();
		Assert.assertEquals(d.getTitle(), expectedOrganisationPageTitle, "Error");
		Reporter.log("Create Organisation look up IMG link click successful", true);

		// Enter Orgnization name text field.
		CreateNewOrganizationPage createNewOrganizationPage = new CreateNewOrganizationPage(d);

		// Enter Orgnization name text field & Select Chemical from drop down list.
		createNewOrganizationPage.createOrgWithIndustry(ORGNAME, INDUSTRY);
		Assert.assertEquals(createNewOrganizationPage.getORGNameTextField().getAttribute("value"), ORGNAME,
				"Error: Organisation  entered not successful");
		Assert.assertEquals(createNewOrganizationPage.getIndustryDropDownList().getAttribute("value"), INDUSTRY,
				"Error: Industry entered not successful");
		Reporter.log("Organisation & Industry entered successful", true);

		// Validate
		OrganizationInfoPage organizationInfoPage = new OrganizationInfoPage(d);
		String header = organizationInfoPage.getHeader();
		Assert.assertTrue(header.contains(ORGNAME));
		Reporter.log(ORGNAME + " create successfully...!", true);
	}

}
