package Calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BMICalculatorEnglTest extends BaseTest{

    @Test
    public void normalCategoryShouldBeShown() {
        Select weightSelect = new Select(driver.findElement(By.name("opt1")));
        Select ftHeightSelect = new Select(driver.findElement(By.name("opt2")));
        Select inchHeightSelect = new Select(driver.findElement(By.name("opt3")));

        weightSelect.selectByVisibleText("pounds");
        driver.findElement(By.name("wg")).sendKeys("80");
        ftHeightSelect.selectByVisibleText("6′");
        inchHeightSelect.selectByVisibleText("1″");
        driver.findElement(By.name("cc")).click();


        String category = driver.findElement(By.name("desc")).getAttribute("value");
        Assert.assertEquals(category, "Your category is Normal");

        String index = driver.findElement(By.name("si")).getAttribute("value");
        Assert.assertEquals(index, "10.62");
    }

    @Test
    public void starvationCategoryShouldBeShown() {
        Select weightSelect = new Select(driver.findElement(By.name("opt1")));
        Select ftHeightSelect = new Select(driver.findElement(By.name("opt2")));
        Select inchHeightSelect = new Select(driver.findElement(By.name("opt3")));

        weightSelect.selectByVisibleText("pounds");
        driver.findElement(By.name("wg")).sendKeys("40");
        ftHeightSelect.selectByVisibleText("6′");
        inchHeightSelect.selectByVisibleText("1″");
        driver.findElement(By.name("cc")).click();

        String category = driver.findElement(By.name("desc")).getAttribute("value");
        Assert.assertEquals(category, "Your category is Starvation");

        String index = driver.findElement(By.name("si")).getAttribute("value");
        Assert.assertEquals(index, "5.31");
    }

    @Test
    public void obeseCategoryShouldBeShown() {
        Select weightSelect = new Select(driver.findElement(By.name("opt1")));
        Select ftHeightSelect = new Select(driver.findElement(By.name("opt2")));
        Select inchHeightSelect = new Select(driver.findElement(By.name("opt3")));

        weightSelect.selectByVisibleText("pounds");
        driver.findElement(By.name("wg")).sendKeys("140");
        ftHeightSelect.selectByVisibleText("6′");
        inchHeightSelect.selectByVisibleText("1″");
        driver.findElement(By.name("cc")).click();

        String category = driver.findElement(By.name("desc")).getAttribute("value");
        Assert.assertEquals(category, "Your category is Obese");

        String index = driver.findElement(By.name("si")).getAttribute("value");
        Assert.assertEquals(index, "18.6");
    }

    @Test
    public void nothingShouldBeShownThenUseLetters() {
        Select weightSelect = new Select(driver.findElement(By.name("opt1")));
        Select ftHeightSelect = new Select(driver.findElement(By.name("opt2")));
        Select inchHeightSelect = new Select(driver.findElement(By.name("opt3")));

        weightSelect.selectByVisibleText("pounds");
        driver.findElement(By.name("wg")).sendKeys("ty");
        ftHeightSelect.selectByVisibleText("6′");
        inchHeightSelect.selectByVisibleText("1″");
        driver.findElement(By.name("cc")).click();

        String category = driver.findElement(By.name("desc")).getAttribute("value");
        Assert.assertEquals(category, "");

        String index = driver.findElement(By.name("si")).getAttribute("value");
        Assert.assertEquals(index, "NaN");
    }
}
