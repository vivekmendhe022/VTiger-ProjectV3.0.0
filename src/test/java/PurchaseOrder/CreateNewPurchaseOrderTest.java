package PurchaseOrder;

import org.testng.annotations.Test;

import com.generic.utilities.BaseClass;

import object.repository.HomePage;
import object.repository.purchaseOrder.CreateNewPurchaseOrderPage;
import object.repository.purchaseOrder.PurchaseOrderPage;

public class CreateNewPurchaseOrderTest extends BaseClass {

	@Test
	public void createNewPurchaseOrderTest() {
		String SUBJECT = "Purchasing Car Wheel";
		String VENDORNAME = "MohenJo Daro";
		String STATUS = "Created";
		String BILLINGADDRESS = "White Street";
		String SHIPPINGADDRESS = "Black Street";
		String PRODUCT = "Gandhi394";
		String QTY = "50";
		String LISTPRICE = "50.00";

		HomePage hp = new HomePage(d);
		hp.clickOnPurchaseOrderLinkText(d);

		PurchaseOrderPage pop = new PurchaseOrderPage(d);
		pop.clickOnCreateNewPurchaseOrderLookUpImg();

		CreateNewPurchaseOrderPage cnpop = new CreateNewPurchaseOrderPage(d);
		cnpop.createNewPurchaseOrderLookUpImg(d, SUBJECT, VENDORNAME, STATUS, BILLINGADDRESS, SHIPPINGADDRESS, PRODUCT,
				QTY, LISTPRICE);

	}
}
