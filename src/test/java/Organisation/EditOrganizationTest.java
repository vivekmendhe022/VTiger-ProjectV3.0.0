package Organisation;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.generic.utilities.BaseClass;

import object.repository.CreateNewOrganizationPage;
import object.repository.HomePage;
import object.repository.OrganizationsPage;

@Listeners(com.generic.utilities.ListenersImplementation.class)
public class EditOrganizationTest extends BaseClass {

	@Test
	public void editOrganizationTest() throws EncryptedDocumentException, IOException {

		int r = jutil.getRandom();

		String ORGNAME = eutil.readDataFromExcel("Organisation", 7, 2) + r;
		String INDUSTRY = eutil.readDataFromExcel("Organisation", 7, 3);
		String DESCRIPTION = eutil.readDataFromExcel("Organisation", 7, 4);

		HomePage hp = new HomePage(d);
		hp.clickOnOrganizationLink();

		OrganizationsPage op = new OrganizationsPage(d);
		op.clickOnEditLinkText();

		CreateNewOrganizationPage cno = new CreateNewOrganizationPage(d);
		cno.editOrganisation(ORGNAME, INDUSTRY, DESCRIPTION);

		String textHeader = d.findElement(By.xpath("//a[normalize-space()='" + ORGNAME + "']")).getText();
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(textHeader.contains(ORGNAME));
		sa.assertAll();
	}
}
