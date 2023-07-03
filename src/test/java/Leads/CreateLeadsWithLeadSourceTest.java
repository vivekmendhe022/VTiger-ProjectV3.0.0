package Leads;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.generic.utilities.BaseClass;

import object.repository.CreateNewLeadPage;
import object.repository.HomePage;
import object.repository.LeadsInfoPage;
import object.repository.LeadsPage;

@Listeners(com.generic.utilities.ListenersImplementation.class)
public class CreateLeadsWithLeadSourceTest extends BaseClass {
	@Test
	public void createLeadWithLeadSourceTest() throws EncryptedDocumentException, IOException {

		String expecedLeadsPageTitle = "Administrator - Leads - vtiger CRM 5 - Commercial Open Source CRM";

		HomePage hp = new HomePage(d);
		hp.clickOnLeadsLink();
		Assert.assertEquals(d.getTitle(), expecedLeadsPageTitle, "Error: Leads page not display");
		Reporter.log("Leads page is display ", true);

		LeadsPage lead = new LeadsPage(d);
		lead.clickOnCreateLeadsLookUpImg();
		Assert.assertEquals(d.getTitle(), expecedLeadsPageTitle, "Error: Create New Lead page not display");
		Reporter.log("Create New Lead page is display ", true);

		String LASTNAME = eutil.readDataFromExcel("Leads", 4, 2);
		String LEADSOURCE = eutil.readDataFromExcel("Leads", 4, 3);
		String COMPANY = eutil.readDataFromExcel("Leads", 4, 4);

		CreateNewLeadPage newLeadPage = new CreateNewLeadPage(d);
		newLeadPage.createNewLeadWithSource(LASTNAME, COMPANY, LEADSOURCE);

		LeadsInfoPage infoPage = new LeadsInfoPage(d);
		String header = infoPage.getLeadsHeader();
		Assert.assertTrue(header.contains(LASTNAME));
		Reporter.log("New Leads created sucessfully..!", true);
	}
}
