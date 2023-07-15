package TroubleTickets;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.generic.utilities.BaseClass;

import object.repository.ContactInfoPage;
import object.repository.ContactPage;
import object.repository.CreateNewContactPage;
import object.repository.CreateNewOrganizationPage;
import object.repository.HomePage;
import object.repository.OrganizationInfoPage;
import object.repository.OrganizationsPage;
import object.repository.product.CreateNewProductPage;
import object.repository.product.ProductInfoPage;
import object.repository.product.ProductPage;
import object.repository.trouble_tickets.CreateNewTicketPage;
import object.repository.trouble_tickets.TroubleTicketInfoPage;
import object.repository.trouble_tickets.TroubleTicketsPage;

public class CreateTroubleTicketsWithAllCredentialsTest extends BaseClass {

	@Test
	public void createTroubleTicketUsingOrg() throws InterruptedException, EncryptedDocumentException, IOException {
		int r = jutil.getRandom();
		String TITLE = "XRZ" + r;
		String ASSIGNEDTO = "group";
		String STATUS = "Open";

		String ORGNAME = eutil.readDataFromExcel("Organisation", 4, 2) + r;

		String PRODUCT = "Hp SUXRT" + r;
		String HANDLER = "user";

		String PRIORITY = "High";
		String SEVERITY = "Critical";
		String CATEGORY = "Big Problem";
		String DESCRIPTION = "All Credentials Completed.";

		HomePage hp = new HomePage(d);

		// Create New Organisation
		hp.clickOnOrganizationLink();

		OrganizationsPage op = new OrganizationsPage(d);
		op.clickOnCreateOrgLookUpImg();

		CreateNewOrganizationPage cno = new CreateNewOrganizationPage(d);
		cno.createOrg(ORGNAME);
		Reporter.log("Organisation & Industry entered successful", true);

		OrganizationInfoPage organizationInfoPage = new OrganizationInfoPage(d);
		String orgheader = organizationInfoPage.getHeader();
		Assert.assertTrue(orgheader.contains(ORGNAME));

		// Create New Product
		hp.clickOnProductLinkText();

		ProductPage pp = new ProductPage(d);
		pp.clickOnCreateTroubleTicketsLookUpIcon();

		CreateNewProductPage cnp = new CreateNewProductPage(d);
		cnp.createNewProduct(PRODUCT, HANDLER);

		ProductInfoPage pip = new ProductInfoPage(d);
		String headerInfo = pip.getProductHeaderInfo();
		Assert.assertTrue(headerInfo.contains(PRODUCT));

		// Create Trouble Ticket
		hp.clickOnTroubleTicketsLinkText();

		TroubleTicketsPage ttp = new TroubleTicketsPage(d);
		ttp.clickOnCreateTroubleTicketsLookUpIcon();

		CreateNewTicketPage cntp = new CreateNewTicketPage(d);
		cntp.createTroubleTicketUsingGroupWithTeamSellingTest(d, TITLE, ORGNAME, ASSIGNEDTO, STATUS);

		cntp.createTroubleTicketWithAllCredentials(d, TITLE, ORGNAME, PRODUCT, ASSIGNEDTO, PRIORITY, STATUS, SEVERITY,
				CATEGORY, DESCRIPTION);
		

		TroubleTicketInfoPage ttip = new TroubleTicketInfoPage(d);
		String header = ttip.getTroubleTicketHeaderInfo();
		Assert.assertTrue(header.contains(TITLE));

	}
}
