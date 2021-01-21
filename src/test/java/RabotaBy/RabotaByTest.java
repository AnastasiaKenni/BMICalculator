package RabotaBy;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class RabotaByTest extends BaseTest {

    @Test
    public void checkNameCompany() {
        driver.findElement(By.cssSelector("[data-qa='search-input']")).sendKeys("QA");
        driver.findElement(By.cssSelector("[data-qa='search-button']")).click();
        driver.findElement(By.cssSelector("[data-position='0']")).click();

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        String companyName = driver.findElement(By.cssSelector("[data-qa='vacancy-company-name']")).getText();
        Assert.assertEquals(companyName, "HeadHunter::Департамент маркетинга");

    }
}
