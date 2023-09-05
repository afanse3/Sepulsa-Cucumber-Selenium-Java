package pages;

import config.env_target;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Product extends env_target {

    private By phoneField = By.id("phone_number");

    @When("User clicks Pulsa product menu")
    public void userClicksPulsaProductMenu(){
        clickButtonId("product_type_0");
    }
    @Then("User is being redirected to Isi Pulsa page")
    public void userIsBeingRedirectedToIsiPulsaPage(){
        waitVisibleId(5, "phone_number");
    }
    @When("User fills phone number")
    public void userFillsPhoneNumber(){
        clickButtonId("phone_number");
        setPhoneNumber("081311112222");
    }
    @And("User select the nominal credit")
    public void userSelectTheNominalCredit(){
        waitVisibleXpath(5, "//p[contains(.,'Telkomsel Rp5.000')]");
        clickButtonXpath("//p[contains(.,'Telkomsel Rp5.000')]");
    }
    @Then("User is being redirected to Payment page")
    public void userIsBeingRedirectedToPaymentPage(){
        waitVisibleXpath(5, "//*[@id=\"checkout_detail\"]");
        tearDown();
    }
    @When("User fills invalid phone number")
    public void userFillsInvalidPhoneNumber(){
        clickButtonId("phone_number");
        setPhoneNumber("080000000000"); //fake number
    }
    @Then("User wont see credit selection menu")
    public void userWontSeeCreditSelectionMenu(){
        waitVisibleXpath(5, "//p[contains(.,'Telkomsel Rp5.000')]");
        tearDown();
    }

    private void setPhoneNumber(String phoneNumber){
        driver.findElement(phoneField).sendKeys(phoneNumber);
    }


    private void waitVisibleId(int seconds, String idElement) {
        Duration duration = Duration.ofSeconds(seconds);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id(idElement))
        );
    }

    private void waitVisibleXpath(int seconds, String xpathElement) {
        Duration duration = Duration.ofSeconds(seconds);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathElement))
        );
    }

    private void waitClickable(int seconds, String xpathElement) {
        Duration duration = Duration.ofSeconds(seconds);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath(xpathElement))
        );
    }

    private void clickButtonId(String idButton){
        WebElement button = driver.findElement(By.id(idButton));
        button.click();
    }

    private void clickButtonXpath(String xpathButton){
        WebElement button = driver.findElement(By.xpath(xpathButton));
        Actions actions = new Actions(driver);
        actions.moveToElement(button).click().perform();;
    }

    private void tearDown(){
        driver.quit();
    }
}
