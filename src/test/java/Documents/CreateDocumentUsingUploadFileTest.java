package Documents;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.generic.utilities.BaseClass;

import object.repository.HomePage;
import object.repository.documents.CreateNewDocumentPage;
import object.repository.documents.DocumentsPage;
import object.repository.documents.DocumnetsInfoPage;

public class CreateDocumentUsingUploadFileTest extends BaseClass {

	@Test
	public void createDocumentTest() throws InterruptedException {
		int r = jutil.getRandom();
		String TITLE = "Test Case_" + r;
		String AssignedTo = "group";

		HomePage hp = new HomePage(d);
		hp.clickOnDocumentsLinkText();

		DocumentsPage dp = new DocumentsPage(d);
		dp.clickOnCreateDocumnetsLookUpIcon();

		CreateNewDocumentPage cnd = new CreateNewDocumentPage(d);
		cnd.createNewDocumentUsingUploadFile(d, TITLE, AssignedTo);

		Thread.sleep(5000);

		DocumnetsInfoPage dip = new DocumnetsInfoPage(d);
		String header = dip.getDocumentsHeaderInfo();
		Assert.assertTrue(header.contains(TITLE));

	}
}
