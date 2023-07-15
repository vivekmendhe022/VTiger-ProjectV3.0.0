package Product;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.generic.utilities.BaseClass;

import object.repository.HomePage;
import object.repository.product.CreateNewProductPage;
import object.repository.product.ProductInfoPage;
import object.repository.product.ProductPage;

public class CreateProductTest extends BaseClass {

	@Test
	public void createProductTest() {

		int r = jutil.getRandom();

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

	}
}
