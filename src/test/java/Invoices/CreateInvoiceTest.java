package Invoices;

import org.testng.annotations.Test;

import com.generic.utilities.BaseClass;

import object.repository.HomePage;
import object.repository.invoice.InvoicePage;

public class CreateInvoiceTest extends BaseClass{

	@Test
	public void createInvoiceTest() {
		HomePage hp=new HomePage(d);
		hp.clickOnInvoiceLinkText(d);
		
		InvoicePage ip=new InvoicePage(d);
		ip.clickOnCreateInvoiceLookUpIcon();
		
		
		
	}
}
