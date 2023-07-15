package TroubleTickets;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.generic.utilities.BaseClass;

import object.repository.HomePage;
import object.repository.product.CreateNewProductPage;
import object.repository.product.ProductInfoPage;
import object.repository.product.ProductPage;
import object.repository.trouble_tickets.CreateNewTicketPage;
import object.repository.trouble_tickets.TroubleTicketInfoPage;
import object.repository.trouble_tickets.TroubleTicketsPage;

public class CreateNewTroubleTicketWithProductTest extends BaseClass {

	@Test
	public void createNewTroubleTicketWithProductTest() throws InterruptedException {
		int r = jutil.getRandom();
		String TITLE = "XRZ" + r;
		String ASSIGNEDTO = "user";
		String STATUS = "Open";
		
		String PRODUCT = "Hp SUXRT" + r;
		String HANDLER = "user";

		HomePage hp = new HomePage(d);
		
		hp.clickOnProductLinkText();

		ProductPage pp = new ProductPage(d);
		pp.clickOnCreateTroubleTicketsLookUpIcon();

		CreateNewProductPage cnp = new CreateNewProductPage(d);
		cnp.createNewProduct(PRODUCT, HANDLER);

		ProductInfoPage pip = new ProductInfoPage(d);
		String headerInfo = pip.getProductHeaderInfo();
		Assert.assertTrue(headerInfo.contains(PRODUCT));
		
		hp.clickOnTroubleTicketsLinkText();

		TroubleTicketsPage ttp = new TroubleTicketsPage(d);
		ttp.clickOnCreateTroubleTicketsLookUpIcon();

		CreateNewTicketPage cntp = new CreateNewTicketPage(d);
		cntp.createNewTicketWithProduct(d, TITLE, PRODUCT, ASSIGNEDTO, STATUS);

		TroubleTicketInfoPage ttip = new TroubleTicketInfoPage(d);
		String header = ttip.getTroubleTicketHeaderInfo();
		Assert.assertTrue(header.contains(TITLE));

	}
}
