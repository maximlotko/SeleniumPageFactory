package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[@href='/ru/']")
    public WebElement switchLangToRuLink;
    @FindBy(xpath = "//*[@href='/lv/']")
    public WebElement switchLangToLvLink;
    @FindBy(xpath = "//*[@class='a1'][@href='/ru/electronics/']")
    public WebElement goToElectronicsLink;

    @FindBy(xpath = "//img[@class='page_header_logo']")
    public WebElement pageHeaderLogo;

    @FindBy(xpath = "//*[@class='page_header_head']/h1")
    public WebElement pageHeaderHead;

    @FindBy(xpath = "//*[contains(@href,'/search/')]")
    public WebElement pageHeaderSearch;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(pageHeaderLogo));
    }

    public HomePage switchLangTo(char language) {
        switch (language) {
            case 'L':
                if (switchLangToLvLink.isDisplayed()) {
                    switchLangToLvLink.click();
                    break;
                }
            case 'R':
                if (switchLangToRuLink.isDisplayed()) {
                    switchLangToRuLink.click();
                }
        }
        return this;
    }

}


