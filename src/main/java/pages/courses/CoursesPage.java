package pages.courses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

public class CoursesPage extends BasePage {

    private final static By courseBox = By.xpath("//div[@class=\"courseBox\"]");
    private final static By courseName = By.xpath("//div[@class=\"courseName\"]/a[contains(.,'%s')]");
    private final static String courseBoxByName = "//a[contains(.,'%s')]/ancestor::div[@class=\"courseBox\"]";

    public CoursesPage(WebDriver driver) {
        super(driver);
        waitForPageTobeLoaded();
    }


    public ArrayList<String> getCourseNameList() {
        ArrayList<CourseBox> boxes = getCourseBoxes();
        ArrayList<String> names = new ArrayList<>();
        for (CourseBox box : boxes) {
            names.add(box.getCourseName());
        }
        return names;
    }

    private ArrayList<CourseBox> getCourseBoxes() {
        ArrayList<WebElement> courseBoxesE = (ArrayList<WebElement>) findElements(courseBox);
        ArrayList<CourseBox> courseBoxes = new ArrayList<>();
        for (WebElement el : courseBoxesE) {
            courseBoxes.add(new CourseBox(el));
        }
        return courseBoxes;
    }

    private CourseBox getCourseBoxByName(String courseName) {
        return new CourseBox(findElement(By.xpath(String.format(courseBoxByName, courseName))));
    }

    public CoursesPage filterCourses(CourseFilters filter) {
        findElement(filter.getFilter()).click();
        return this;
    }

    public ArrayList<HashMap<CourseBox.CourseBoxFields, String>> getCoursesMap() {
        ArrayList<CourseBox> courseBoxes;
        ArrayList<HashMap<CourseBox.CourseBoxFields, String>> mapArrayList = new ArrayList<>();
        courseBoxes = getCourseBoxes();
        for (CourseBox box : courseBoxes) {
            if (box.getCourseName().contains(",")) {
                mapArrayList.add(getFilteredMapForCsv(box));
            } else {
                mapArrayList.add(box.getCourseHashMap());
            }
        }
        return mapArrayList;
    }

    private HashMap<CourseBox.CourseBoxFields, String> getFilteredMapForCsv(CourseBox box) {
        HashMap<CourseBox.CourseBoxFields, String> map = box.getCourseHashMap();
        map.replace(CourseBox.CourseBoxFields.COURSE_NAME, box.getCourseName().replace(",", ""));
        return map;
    }

    public ArrayList<HashMap<CourseBox.CourseBoxFields, String>> getExpectedMapListFromCVS(CourseFilters filters) {
        ArrayList<HashMap<CourseBox.CourseBoxFields, String>> mapArrayList = new ArrayList<>();
        String relativePath = "examples/%s.csv";
        String path = String.format(relativePath, filters.getFilterName());
        BufferedReader reader = new BufferedReader(new InputStreamReader(CoursesPage.class.getClassLoader().getResourceAsStream(path), StandardCharsets.UTF_8));
        reader.lines().forEach(s -> {
            String[] strArr = s.split(",");
            HashMap<CourseBox.CourseBoxFields, String> map = new HashMap<>();
            map.put(CourseBox.CourseBoxFields.COURSE_NAME, strArr[0]);
            map.put(CourseBox.CourseBoxFields.COURSE_LEVEL, strArr[1]);
            mapArrayList.add(map);
        });
        return mapArrayList;
    }
}