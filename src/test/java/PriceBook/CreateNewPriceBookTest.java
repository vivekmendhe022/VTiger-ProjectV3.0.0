package PriceBook;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.generic.utilities.BaseClass;

import object.repository.HomePage;
import object.repository.pricebook.CreateNewPriceBookPage;
import object.repository.pricebook.PriceBookInfoPage;
import object.repository.pricebook.PriceBookPage;

public class CreateNewPriceBookTest extends BaseClass {

	@Test
	public void createNewPriceBookTest() {

		int r = jutil.getRandom();

		String PriceBookName = "HP Book " + r;
		String Description = "This is HP Book price book " + r + ".";

		HomePage hp = new HomePage(d);
		hp.clickOnPriceBooksLinkText(d);

		PriceBookPage pbp = new PriceBookPage(d);
		pbp.clickOnPriceBooksLookUpImg();

		CreateNewPriceBookPage cnpb = new CreateNewPriceBookPage(d);
		cnpb.createNewPriceBook(PriceBookName, Description);

		PriceBookInfoPage pbip = new PriceBookInfoPage(d);
		String priceBookHeaderInfo = pbip.priceBookHeaderInfo();
		Assert.assertTrue(priceBookHeaderInfo.contains(PriceBookName));

	}
}
