import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
@Execution(ExecutionMode.CONCURRENT)
public class SimpleTest extends BaseTest {


    @Test
    public void test() {



    }


    @Test
    public void test2() {
        mainPage.navigateToCoursesPage();
    }

    @Test
    public void test3() {
        mainPage.navigateToCoursesPage();
    }

}
