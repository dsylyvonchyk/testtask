package Steps;

import Pages.ValuesPage;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;

public class ValuesSteps {

    ValuesPage page;

    @Step("Open TestTask page")
    public void OpenTestTask(){
        page.open();//this is serenity native method that will make driver to load page mentioned in DefaultUrl annotation of TestTaskPage class
    }


    @Step("Validate all elements on Alarm Subscription page are displayed")
    public void VisibilityOfElements(){
        Assertions.assertThat(page.VisibilityOfElements())
                .as("Some elements are not displayed")
                .isTrue();
    }

    @Step("Verify the right count of values appear on the screen and values are formatted as currencies")
    public void RightCount(){
        Assertions.assertThat(page.ValueLengthFormat(page.Value1_GetValue()))
                .as("Value 1 has incorrect format")
                .isTrue();
        Assertions.assertThat(page.ValueLengthFormat(page.Value2_GetValue()))
                .as("Value 2 has incorrect format")
                .isTrue();
        Assertions.assertThat(page.ValueLengthFormat(page.Value3_GetValue()))
                .as("Value 3 has incorrect format")
                .isTrue();
        Assertions.assertThat(page.ValueLengthFormat(page.Value4_GetValue()))
                .as("Value 4 has incorrect format")
                .isTrue();
        Assertions.assertThat(page.ValueLengthFormat(page.Value5_GetValue()))
                .as("Value 5 has incorrect format")
                .isTrue();
        Assertions.assertThat(page.ValueLengthFormat(page.ValueTotal_GetValue()))
                .as("Total value has incorrect format")
                .isTrue();
    }

    @Step("Verify the values on the screen are greater than 0")
    public void ValuesGraterThanNull(){
        Assertions.assertThat(page.ParseDouble(page.Value1_GetValue()))
                .as("Value 1 is not grater than 0")
                .isGreaterThan(0);
        Assertions.assertThat(page.ParseDouble(page.Value2_GetValue()))
                .as("Value 2 is not grater than 0")
                .isGreaterThan(0);
        Assertions.assertThat(page.ParseDouble(page.Value3_GetValue()))
                .as("Value 3 is not grater than 0")
                .isGreaterThan(0);
        Assertions.assertThat(page.ParseDouble(page.Value4_GetValue()))
                .as("Value 4 is not grater than 0")
                .isGreaterThan(0);
        Assertions.assertThat(page.ParseDouble(page.Value5_GetValue()))
                .as("Value 5 is not grater than 0")
                .isGreaterThan(0);
        Assertions.assertThat(page.ParseDouble(page.ValueTotal_GetValue()))
                .as("Total value is not grater than 0")
                .isGreaterThan(0);
    }

    @Step("Verify he total balance is correct based on the values listed on the screen and total balance matches the sum of the values")
    public void ValuesSumIsCorrect(){
        Assertions.assertThat(page.ParseDouble(page.Value1_GetValue())+page.ParseDouble(page.Value2_GetValue())+page.ParseDouble(page.Value3_GetValue())+page.ParseDouble(page.Value4_GetValue())+page.ParseDouble(page.Value5_GetValue()))
                .as("Value 1 is not grater than 0")
                .isEqualTo(page.ParseDouble(page.ValueTotal_GetValue()));
    }
}
