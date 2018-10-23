import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.courses.CoursesPage;

public class SimpleTest extends BaseTest {

    @Test
    public void test() throws InterruptedException {
        MainPage mainPage = new MainPage();
        CoursesPage coursesPage = mainPage.navigateToCoursesPage();
       // System.out.println(coursesPage.getCourseNameList());
       coursesPage.printCourseObjectsMap();
    }
}
