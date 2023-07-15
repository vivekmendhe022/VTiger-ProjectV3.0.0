package TroubleTickets;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.generic.utilities.BaseClass;

import object.repository.CreateNewOrganizationPage;
import object.repository.HomePage;
import object.repository.OrganizationInfoPage;
import object.repository.OrganizationsPage;
import object.repository.trouble_tickets.CreateNewTicketPage;
import object.repository.trouble_tickets.TroubleTicketInfoPage;
import object.repository.trouble_tickets.TroubleTicketsPage;

public class CreateTroubleTicketsWithOrgTest extends BaseClass {
	@Test
	public void createTroubleTicketsWithOrgTest() throws InterruptedException, EncryptedDocumentException, IOException {
		int r = jutil.getRandom();
		String TITLE = "XRZ" + r;
		String ASSIGNEDTO = "user";
		String STATUS = "Open";

		String ORGNAME = eutil.readDataFromExcel("Organisation", 4, 2) + r;

		// Click on Organisation link.
		HomePage hp = new HomePage(d);
		hp.clickOnOrganizationLink();

		// Click on CreateOrgLookUpImg
		OrganizationsPage op = new OrganizationsPage(d);
		op.clickOnCreateOrgLookUpImg();

		// Enter Orgnization name text field.
		CreateNewOrganizationPage cno = new CreateNewOrganizationPage(d);
		cno.createOrg(ORGNAME);
		Reporter.log("Organisation & Industry entered successful", true);

		// Validate
		OrganizationInfoPage organizationInfoPage = new OrganizationInfoPage(d);
		String orgheader = organizationInfoPage.getHeader();
		Assert.assertTrue(orgheader.contains(ORGNAME));

		hp.clickOnTroubleTicketsLinkText();

		TroubleTicketsPage ttp = new TroubleTicketsPage(d);
		ttp.clickOnCreateTroubleTicketsLookUpIcon();

		CreateNewTicketPage cntp = new CreateNewTicketPage(d);
		cntp.createNewTicketWithOrg(d, TITLE, ORGNAME, ASSIGNEDTO, STATUS);

		TroubleTicketInfoPage ttip = new TroubleTicketInfoPage(d);
		String header = ttip.getTroubleTicketHeaderInfo();
		Assert.assertTrue(header.contains(TITLE));

	}
}
