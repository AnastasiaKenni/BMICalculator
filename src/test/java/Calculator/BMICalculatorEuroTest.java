package Calculator;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BMICalculatorEuroTest extends BaseTest{


    @Test
    public void normalCategoryShouldBeShown() {
        //by id (1)
        //by.name

        driver.findElement(By.name("wg")).sendKeys("85");
        driver.findElement(By.name("ht")).sendKeys("185");
        driver.findElement(By.name("cc")).click();

        String category = driver.findElement(By.name("desc")).getAttribute("value");
        Assert.assertEquals(category, "Your category is Normal");

        String index = driver.findElement(By.name("si")).getAttribute("value");
        Assert.assertEquals(index, "24.84");
    }

    @Test
    public void starvationCategoryShouldBeShown() {
        driver.findElement(By.name("wg")).sendKeys("40");
        driver.findElement(By.name("ht")).sendKeys("185");
        driver.findElement(By.name("cc")).click();

        String category = driver.findElement(By.name("desc")).getAttribute("value");
        Assert.assertEquals(category, "Your category is Starvation");

        String index = driver.findElement(By.name("si")).getAttribute("value");
        Assert.assertEquals(index, "11.69");
    }

    @Test
    public void obeseCategoryShouldBeShown() {
        driver.findElement(By.name("wg")).sendKeys("140");
        driver.findElement(By.name("ht")).sendKeys("185");
        driver.findElement(By.name("cc")).click();

        String category = driver.findElement(By.name("desc")).getAttribute("value");
        Assert.assertEquals(category, "Your category is Obese");

        String index = driver.findElement(By.name("si")).getAttribute("value");
        Assert.assertEquals(index, "40.91");
    }

    @Test
    public void nothingShouldBeShownThenUseLetters() {
        driver.findElement(By.name("wg")).sendKeys("ddfg");
        driver.findElement(By.name("ht")).sendKeys("fg");
        driver.findElement(By.name("cc")).click();

        String category = driver.findElement(By.name("desc")).getAttribute("value");
        Assert.assertEquals(category, "");

        String index = driver.findElement(By.name("si")).getAttribute("value");
        Assert.assertEquals(index, "NaN");
    }
}

