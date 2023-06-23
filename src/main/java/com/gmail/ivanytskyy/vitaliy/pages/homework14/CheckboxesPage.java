package com.gmail.ivanytskyy.vitaliy.pages.homework14;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 15/06/2023
 */
public class CheckboxesPage extends BasePage{
    @FindBy(xpath = "//form/input[1]")
    private WebElement checkbox1;
    @FindBy(xpath = "//form/input[2]")
    private WebElement checkbox2;

    public CheckboxesPage() {
        PageFactory.initElements(webDriver, this);
    }
    public CheckboxesPage selectCheckbox1(){
        selectCheckbox(checkbox1);
        return this;
    }
    public CheckboxesPage selectCheckbox2(){
        selectCheckbox(checkbox2);
        return this;
    }
    public boolean isCheckBox1Selected(){
        return checkbox1.isSelected();
    }
    public boolean isCheckBox2Selected(){
        return checkbox2.isSelected();
    }
}