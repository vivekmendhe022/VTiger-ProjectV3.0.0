package Invoices;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.generic.utilities.BaseClass;

import object.repository.HomePage;
import object.repository.invoice.CreateInvoicePage;
import object.repository.invoice.InvoiceInfoPage;
import object.repository.invoice.InvoicePage;

public class CreateInvoiceTest extends BaseClass {

	@Test
	public void createInvoiceTest() {

		String SUBJECT = "Mocrisoft360 Product";
		String ORG = "395Microsoft";
		String BillingAddress = "White Street Billboard";
		String ShippingAddress = "Black Street Billboard";
		String PRODUCT = "Gandhi394";
		String QTY = "10";

		HomePage hp = new HomePage(d);
		hp.clickOnInvoiceLinkText(d);

		InvoicePage ip = new InvoicePage(d);
		ip.clickOnCreateInvoiceLookUpIcon();

		CreateInvoicePage cnip = new CreateInvoicePage(d);
		cnip.createNewInvoice(d, SUBJECT, ORG, BillingAddress, ShippingAddress, PRODUCT, QTY);

		InvoiceInfoPage iip = new InvoiceInfoPage(d);
		String headerInfo = iip.getInvoiceHeaderInfo();

		Assert.assertTrue(headerInfo.contains(SUBJECT));

	}
}
