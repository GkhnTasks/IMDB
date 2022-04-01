package com.imdb.pages;

import com.imdb.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OscarsGuidePage extends BasePage{

    public WebElement getEventHistory(String year){

        WebElement element= Driver.get().findElement(By.xpath("//a[text()='"+year+"']"));
        return element;

    }

}
