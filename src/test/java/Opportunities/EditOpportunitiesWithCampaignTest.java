package Opportunities;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.generic.utilities.BaseClass;

import object.repository.CreateNewOrganizationPage;
import object.repository.HomePage;
import object.repository.OrganizationInfoPage;
import object.repository.OrganizationsPage;
import object.repository.campaigns.CampaignsPage;
import object.repository.campaigns.CampaingsInfoPage;
import object.repository.campaigns.CreateNewCampaignPage;
import object.repository.opportunities.CreatingNewOpportunityPage;
import object.repository.opportunities.EditOpportunityPage;
import object.repository.opportunities.OpportunitiesPage;
import object.repository.opportunities.OpportunityInfoPage;

@Listeners(com.generic.utilities.ListenersImplementation.class)
public class EditOpportunitiesWithCampaignTest extends BaseClass {

	@Test
	public void editOpportunitiesWithCampaignTest()
			throws InterruptedException, EncryptedDocumentException, IOException {

		String expectedOpportunitiesTitle = "Administrator - Opportunities - vtiger CRM 5 - Commercial Open Source CRM";

		int r = jutil.getRandom();

//		String OPPNAME = r + "Bill Gate";
//		String ORGNAME = r + "Microsoft";
//		String AssignedTo = "user";
//		String SALESSTAGE = "Needs Analysis";
//		String CAMPNAME = r + "Mac Book Pro";
//		String ASSIGNTO = "group";
//		String OPPNAMEFIELD = "Opportunity Name";
//		String CSOURCE = "Campaign Source";

		String OPPNAME = eutil.readDataFromExcel("EditOpportunities", 1, 2) + r;
		String ORGNAME = eutil.readDataFromExcel("EditOpportunities", 1, 3) + r;
		String AssignedTo = eutil.readDataFromExcel("EditOpportunities", 1, 4);
		String SALESSTAGE = eutil.readDataFromExcel("EditOpportunities", 1, 5);
		String CAMPNAME = eutil.readDataFromExcel("EditOpportunities", 1, 6) + r;
		String ASSIGNTO = eutil.readDataFromExcel("EditOpportunities", 1, 7);
		String OPPNAMEFIELD = eutil.readDataFromExcel("EditOpportunities", 1, 8);
		String CSOURCE = eutil.readDataFromExcel("EditOpportunities", 1, 9);

		HomePage hp = new HomePage(d);
		hp.clickOnOrganizationLink();

		OrganizationsPage organizationsPage = new OrganizationsPage(d);
		organizationsPage.clickOnCreateOrgLookUpImg();

		CreateNewOrganizationPage createNewOrganizationPage = new CreateNewOrganizationPage(d);
		createNewOrganizationPage.createOrg(ORGNAME);

		OrganizationInfoPage orgheader = new OrganizationInfoPage(d);
		String oheader = orgheader.getHeader();
		Assert.assertTrue(oheader.contains(ORGNAME));

		hp.clickOnOpportunitiesLink();
		Assert.assertEquals(d.getTitle(), expectedOpportunitiesTitle, "Error: Opportunities page is not diplayed.");
		Reporter.log("Opportunities page is diplayed.", true);

		OpportunitiesPage opportunitiesPage = new OpportunitiesPage(d);
		opportunitiesPage.clickOnCreateOpportunitiesLookUpIcon();

		CreatingNewOpportunityPage newOpportunityPage = new CreatingNewOpportunityPage(d);
		String header = newOpportunityPage.createNewOpportunityHeader();
		Assert.assertTrue(header.equalsIgnoreCase("Creating New Opportunity"));
		Reporter.log("Creating New Opportunity page is displyed.", true);

		CreatingNewOpportunityPage cno = new CreatingNewOpportunityPage(d);
		cno.createOpprtunitiesWithOrgUser(d, OPPNAME, ORGNAME, AssignedTo, SALESSTAGE);

		OpportunityInfoPage cip = new OpportunityInfoPage(d);
		String headerInfo = cip.getOpportunityHeaderInfo();
		Assert.assertTrue(headerInfo.contains(OPPNAME));
		Reporter.log("Opprtunity created", true);

		hp.hoverOnMore(d);
		hp.clickOnCampaingsLinkText();

		CampaignsPage cp = new CampaignsPage(d);
		cp.clickOnCreateCampaignsLookUpIcon();

		CreateNewCampaignPage cnp = new CreateNewCampaignPage(d);
		cnp.createNewCampaignPage(CAMPNAME, ASSIGNTO);

		CampaingsInfoPage cipp = new CampaingsInfoPage(d);
		String cHeader = cipp.getCampaingsHeaderInfo();
		Assert.assertTrue(cHeader.contains(CAMPNAME));
		Reporter.log("Campaigns Created.", true);

		hp.clickOnOpportunitiesLink();
		opportunitiesPage.clickOnEditTextLink(d, OPPNAME, OPPNAMEFIELD);
		System.out.println("Edit page.s.");

		EditOpportunityPage eop = new EditOpportunityPage(d);
		eop.createCampaignsForOpportunity(d, CAMPNAME);

		Thread.sleep(5000);

		opportunitiesPage.verifyCampaingsAddedToOpportunity(d, CSOURCE, CAMPNAME);
		System.out.println("Verify page.s.");

		WebElement OpportunityNameLinkText = d.findElement(By.xpath("(//a[.='" + OPPNAME + "'])[2]"));
		String OppHeader = OpportunityNameLinkText.getText();
		System.out.println(OppHeader);
		if (OppHeader.equalsIgnoreCase(OPPNAME)) {
			System.out.println("Verify");
		} else {
			System.out.println("Failed");
		}
		Assert.assertTrue(OppHeader.equalsIgnoreCase(OPPNAME));

	}

}
