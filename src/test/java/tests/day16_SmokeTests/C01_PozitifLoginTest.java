package tests.day16_SmokeTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_PozitifLoginTest {

    @Test
    public void pozitifLoginTest(){

        // qualitydemy anasayfaya git

        //gitmek istediğimiz sayfanın url'ini girmemiz gerekiyor.
        //manuel olarak htpps çeklinde girmemek için bunu dinamik yapmalıyız
        //test datalarımızı configration.proporties file'ına yükledik
        //bu file java dışında olduğu için buna direk ulaşamayız, configReader üzerinden ulaşabilriz

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        QualitydemyPage qualitydemyPage= new QualitydemyPage();
        qualitydemyPage.cookiesAccept.click();
        qualitydemyPage.ilkLoginLinki.click();

        qualitydemyPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));

        qualitydemyPage.loginButonu.click();

        ReusableMethods.bekle(2);

        Assert.assertTrue(qualitydemyPage.basariliGirisCoursesLinki.isDisplayed());
        Driver.closeDriver();

        //bu class'taki her şey dinamik
        //değişen bir şey olursa diğerlerine gider ve orada güncelleriz
        //bu şekilde tüm bilgiler güncellenmiş olur
    }
}
