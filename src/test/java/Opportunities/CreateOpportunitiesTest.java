package Opportunities;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.generic.utilities.BaseClass;

import object.repository.CreateNewOrganizationPage;
import object.repository.HomePage;
import object.repository.OrganizationInfoPage;
import object.repository.OrganizationsPage;
import object.repository.opportunities.CreatingNewOpportunityPage;
import object.repository.opportunities.OpportunitiesPage;

@Listeners(com.generic.utilities.ListenersImplementation.class)
public class CreateOpportunitiesTest extends BaseClass {

	@Test
	public void createOpportunitiesTest() throws InterruptedException {

		String expectedOpportunitiesTitle = "Administrator - Opportunities - vtiger CRM 5 - Commercial Open Source CRM";

		int r = jutil.getRandom();

		String OPNAME = "Gate";
		String ORGNAME = r + "Microsoft";
		String SALESSTAGE = "Needs Analysis";

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

		CreatingNewOpportunityPage creatingNewOpportunityPage = new CreatingNewOpportunityPage(d);

	}
}
