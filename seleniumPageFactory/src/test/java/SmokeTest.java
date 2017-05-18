import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pageobjects.HomePage;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class SmokeTest extends BaseTest{
    HomePage homePage;

    @Test
    public void testInitialLanguage() {
        //Arrange
        homePage = new HomePage(driver);

        //Assert
        assertEquals("SLUDINĀJUMI", homePage.pageHeaderHead.getText());
    }

    @Test
    public void testSwitchingLanguageToRu() {
        //Arrange
        homePage = new HomePage(driver);

        //Act
        homePage.switchLangTo('R');

        //Assert
        assertEquals("ОБЪЯВЛЕНИЯ", homePage.pageHeaderHead.getText());
    }

    @Test
    public void testSwitchingLanguageToLv() {
        //Arrange
        homePage = new HomePage(driver);

        //Act
        homePage.switchLangTo('R');
        homePage.switchLangTo('L');

        //Assert
        assertEquals("SLUDINĀJUMI", homePage.pageHeaderHead.getText());
    }
}
