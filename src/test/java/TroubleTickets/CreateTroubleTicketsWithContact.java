package TroubleTickets;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.generic.utilities.BaseClass;

import object.repository.ContactInfoPage;
import object.repository.ContactPage;
import object.repository.CreateNewContactPage;
import object.repository.HomePage;
import object.repository.trouble_tickets.CreateNewTicketPage;
import object.repository.trouble_tickets.TroubleTicketInfoPage;
import object.repository.trouble_tickets.TroubleTicketsPage;

public class CreateTroubleTicketsWithContact extends BaseClass {
	@Test
	public void createTroubleTicketsWithContact() throws InterruptedException {
		int r = jutil.getRandom();
		String TITLE = "XRZ" + r;
		String LASTNAME = "Gandhi483";
		String ASSIGNEDTO = "user";
		String STATUS = "Open";

		HomePage hp = new HomePage(d);
		hp.clickOnContactLink();

		ContactPage cp = new ContactPage(d);
		cp.clickOnCreateContactLookUpImg();

		CreateNewContactPage cncp = new CreateNewContactPage(d);
		cncp.createNewContact(d, LASTNAME);

		ContactInfoPage infoPage = new ContactInfoPage(d);
		String contactHeaderInfo = infoPage.getContactHeaderInfo();
		Assert.assertTrue(contactHeaderInfo.contains(LASTNAME));
		Reporter.log(LASTNAME + " create successfully...!", true);

		hp.clickOnTroubleTicketsLinkText();

		TroubleTicketsPage ttp = new TroubleTicketsPage(d);
		ttp.clickOnCreateTroubleTicketsLookUpIcon();

		CreateNewTicketPage cntp = new CreateNewTicketPage(d);
		cntp.createNewTicketWithContact(d, TITLE, LASTNAME, ASSIGNEDTO, STATUS);

		TroubleTicketInfoPage ttip = new TroubleTicketInfoPage(d);
		String header = ttip.getTroubleTicketHeaderInfo();
		Assert.assertTrue(header.contains(TITLE));

	}
}
