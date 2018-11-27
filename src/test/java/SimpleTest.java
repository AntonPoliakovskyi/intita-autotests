import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import pages.courses.CourseFilters;
import pages.courses.CoursesPage;

import static org.junit.jupiter.api.Assertions.assertEquals;


@Execution(ExecutionMode.CONCURRENT)
public class SimpleTest extends BaseTest {
    private CoursesPage coursesPage;

    @BeforeEach
    public void openCoursePage() {
        coursesPage = mainPage.navigateToCoursesPage();
    }

    @Test
    public void test() {
        assertEquals(coursesPage.getExpectedMapListFromCVS(CourseFilters.ALL_LEVELS),
                coursesPage.getCoursesMap());
    }

    @Test
    public void test2() {
        assertEquals(coursesPage.getExpectedMapListFromCVS(CourseFilters.FOR_BEGINNERS),
                coursesPage.filterCourses(CourseFilters.FOR_BEGINNERS).getCoursesMap());
    }
}
