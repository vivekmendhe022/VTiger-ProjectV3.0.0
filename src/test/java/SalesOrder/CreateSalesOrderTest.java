package SalesOrder;

import org.testng.annotations.Test;

import com.generic.utilities.BaseClass;

import object.repository.HomePage;
import object.repository.salesorder.CreateNewSalesOrderPage;
import object.repository.salesorder.SalesOrderPage;

public class CreateSalesOrderTest extends BaseClass{

	@Test
	public void createSalesOrderTest() {
		
		String SUBJECT="Hp Laptop";
		String STATUS="Approved";
		String ORGNAME="395Microsoft";
		String INSTATUS="Created";
		String BillingAddress="White Street";
		String ShippingAddress="White Street";
		String PRODUCT="Gandhi394";
		String QTY="12";
		
		HomePage hp=new HomePage(d);
		hp.clickOnSalesOrderLinkText(d);
		
		SalesOrderPage sop=new SalesOrderPage(d);
		sop.clickOnSalesOrderLookUpImg();
		
		CreateNewSalesOrderPage cnsp=new CreateNewSalesOrderPage(d);
		cnsp.createNewSalesOrder(d, SUBJECT, STATUS, ORGNAME, INSTATUS, BillingAddress, ShippingAddress, PRODUCT);
		
		
	}
}
