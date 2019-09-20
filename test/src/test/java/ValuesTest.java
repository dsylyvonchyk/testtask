import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import Steps.ValuesSteps;


@RunWith(SerenityRunner.class)
public class ValuesTest {

    @Steps
    ValuesSteps steps;

    @Managed(driver = "Chrome")
    WebDriver driver;

    @Title("TestCase001: Verify the right count of values appear on the screen and values are formatted as currencies")
    @Test
    public void TestTaskPageUITest(){
        steps.OpenTestTask();
        steps.VisibilityOfElements();
    }

    @Title("TestCase002: Verify the right count of values appear on the screen and values are formatted as currencies")
    @Test
    public void RightCountTest(){
        steps.OpenTestTask();
        steps.RightCount();
    }

    @Title("TestCase003: Verify the values on the screen are greater than 0")
    @Test
    public void GraterThanNullTest(){
        steps.OpenTestTask();
        steps.ValuesGraterThanNull();
    }

    @Title("TestCase004: Verify the total balance is correct based on the values listed on the screen and total balance matches the sum of the values")
    @Test
    public void CorrectTotalTest(){
        steps.OpenTestTask();
        steps.ValuesSumIsCorrect();
    }

    /**========================================RESULTS======================================
     First 3 test cases most likely will pass (judging by the way page looks on mockup in powerpoint)
     Last test will fail as current actual sum of values is $997,000.00
     ID parameters of text fields have non consistent numeration that doesn't match numeration of labels, so I would suggest to fix it
     I would also suggest to make total text field of same width as rest of fields, but if it is intended by design and customer's needs it's okay

     For reference: my stack in here is Java + Maven + Serenity(Wrap around selenium for steps) + AssertJ(for detailed assertions)
     **/
}
