package Calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class EnglishSystem extends BaseTest{
    Select weightSelect = new Select(driver.findElement(By.name("opt1")));
    Select ftHeightSelect = new Select(driver.findElement(By.name("opt2")));
    Select inchHeightSelect = new Select(driver.findElement(By.name("opt3")));
}
