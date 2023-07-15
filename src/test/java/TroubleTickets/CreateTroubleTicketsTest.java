package TroubleTickets;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.generic.utilities.BaseClass;

import object.repository.HomePage;
import object.repository.trouble_tickets.CreateNewTicketPage;
import object.repository.trouble_tickets.TroubleTicketInfoPage;
import object.repository.trouble_tickets.TroubleTicketsPage;

public class CreateTroubleTicketsTest extends BaseClass{

	@Test
	public void createTroubleTicketsTest() throws InterruptedException {
		int r = jutil.getRandom();
		String TITLE="XRZ"+r;
		String ASSIGNEDTO="user";
		String STATUS="Open";
		
		HomePage hp=new HomePage(d);
		hp.clickOnTroubleTicketsLinkText();
		
		TroubleTicketsPage ttp=new TroubleTicketsPage(d);
		ttp.clickOnCreateTroubleTicketsLookUpIcon();
		
		CreateNewTicketPage cntp=new CreateNewTicketPage(d);
		cntp.createNewTicket(TITLE, ASSIGNEDTO, STATUS);
		
		TroubleTicketInfoPage ttip=new TroubleTicketInfoPage(d);
		String header = ttip.getTroubleTicketHeaderInfo();
		Assert.assertTrue(header.contains(TITLE));
		
	}
}
