package Pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.exercise1.com/values")
public class ValuesPage extends PageObject {

    Locators locators;

    public boolean VisibilityOfElements(){
        return find(locators.TestPage_Value1Label).isDisplayed()&&
                find(locators.TestPage_Value1Text).isDisplayed()&&
                find(locators.TestPage_Value2Label).isDisplayed()&&
                find(locators.TestPage_Value2Text).isDisplayed()&&
                find(locators.TestPage_Value3Label).isDisplayed()&&
                find(locators.TestPage_Value3Text).isDisplayed()&&
                find(locators.TestPage_Value4Label).isDisplayed()&&
                find(locators.TestPage_Value4Text).isDisplayed()&&
                find(locators.TestPage_Value5Label).isDisplayed()&&
                find(locators.TestPage_Value5Text).isDisplayed()&&
                find(locators.TestPage_ValueTotalLabel).isDisplayed()&&
                find(locators.TestPage_ValueTotalText).isDisplayed();
    }

    /**parsing values from page**/
    public String Value1_GetValue(){
        return find(locators.TestPage_Value1Text).getValue();
    }

    public String Value2_GetValue(){
        return find(locators.TestPage_Value2Text).getValue();
    }

    public String Value3_GetValue(){
        return find(locators.TestPage_Value3Text).getValue();
    }

    public String Value4_GetValue(){
        return find(locators.TestPage_Value4Text).getValue();
    }

    public String Value5_GetValue(){
        return find(locators.TestPage_Value5Text).getValue();
    }

    public String ValueTotal_GetValue(){
        return find(locators.TestPage_ValueTotalText).getValue();
    }

    /**parsing values to doubles**/
    public Double ParseDouble(String TextValue) {
        if (TextValue.length() <= 6) {
            return Double.parseDouble(TextValue.substring(1));
        } else if (TextValue.length() > 7 && TextValue.length() < 11) {
            return Double.parseDouble(TextValue.substring(1).substring(4));
        } else {
            return Double.parseDouble(TextValue.substring(1).substring(1).substring(4));
        }
    }

    /**verify format**/
    private boolean CheckTextFormat_Dot(String TextValue){
        return TextValue.charAt(TextValue.length() - 3) == '.'&&
                TextValue.charAt(0)=='$';
    }

    private boolean CheckTextFormat_DotAndComa(String TextValue){
        return TextValue.charAt(TextValue.length() - 3) == '.'&&
                TextValue.charAt(TextValue.length() - 7) == ',';
    }

    private boolean CheckTextFormat_DotAndTwoComas(String TextValue){
        return TextValue.charAt(TextValue.length() - 3) == '.'&&
                TextValue.charAt(TextValue.length() - 7) == ','&&
                TextValue.charAt(TextValue.length() - 11) == ',';
    }

    public boolean ValueLengthFormat(String TextValue){
        if (TextValue.length()<=6){
            return CheckTextFormat_Dot(TextValue);
        }else if (TextValue.length()>7&&TextValue.length()<11){
            return CheckTextFormat_DotAndComa(TextValue);
        }else {
            return CheckTextFormat_DotAndTwoComas(TextValue);
        }
    }

}
