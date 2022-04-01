package com.imdb.pages;

import com.imdb.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class AcademyAwardsPage extends BasePage{

    public WebElement getLocatorWithText(String text){

        WebElement element= Driver.get().findElement(By.xpath("//*[text()='"+text+"']"));
        return element;

    }

}
