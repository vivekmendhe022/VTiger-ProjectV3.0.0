package SalesOrder;

import org.testng.annotations.Test;

import com.generic.utilities.BaseClass;

import object.repository.HomePage;
import object.repository.salesorder.SalesOrderPage;

public class CreateSalesOrderTest extends BaseClass{

	@Test
	public void createSalesOrderTest() {
		
		HomePage hp=new HomePage(d);
		hp.clickOnSalesOrderLinkText(d);
		
		SalesOrderPage sop=new SalesOrderPage(d);
		sop.clickOnSalesOrderLookUpImg();
		
		
	}
}
