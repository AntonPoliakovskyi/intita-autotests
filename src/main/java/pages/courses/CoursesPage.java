package pages.courses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CoursesPage extends BasePage {

    private WebDriver driver;
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

    public CoursesPage coursesFilter(CourseFilters filter) {
        findElement(filter.getFilter()).click();
        return this;
    }

    public void printCourseObjectsMap() {
        ArrayList<CourseBox> courseBoxes;
        courseBoxes = getCourseBoxes();
        for (CourseBox box : courseBoxes) {
            System.out.println(box.getCourseHashMap());
        }

    }

    public ArrayList<HashMap<CourseBox.CourseBoxFields, String>> getCoursesMap() {
        ArrayList<CourseBox> courseBoxes;
        ArrayList<HashMap<CourseBox.CourseBoxFields, String>> mapArrayList = new ArrayList<>();
        courseBoxes = getCourseBoxes();
        for (CourseBox box : courseBoxes) {
            mapArrayList.add(box.getCourseHashMap());
        }
        return mapArrayList;
    }

    public void exportCoursesToCSV() {
        String eol = System.getProperty("line.separator");
        ArrayList<HashMap<CourseBox.CourseBoxFields, String>> mapArrayList = getCoursesMap();
        try {
            FileWriter writer = new FileWriter("C:\\Users\\Anton_Poliakovskyi\\IdeaProjects\\intita-autotests\\src\\test\\resources\\courses.csv", false);
            //   String keys = mapArrayList.get(0).keySet().toString();
            //  writer.append(keys.substring(1, keys.length() - 1))
            //           .append(eol);
            for (HashMap<CourseBox.CourseBoxFields, String> listEntry : mapArrayList) {
                for (Map.Entry<CourseBox.CourseBoxFields, String> mapEntry : listEntry.entrySet()) {
                    String value = mapEntry.getValue();
                    if (value.contains(","))
                        value = value.replace(",", "");
                    writer.append(value)
                            .append(',');
                }
                writer.append(eol);
            }
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }

    public ArrayList<HashMap<CourseBox.CourseBoxFields, String>> getExpectedMapListFromCVS() {
        ArrayList<HashMap<CourseBox.CourseBoxFields, String>> mapArrayList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Anton_Poliakovskyi\\IdeaProjects\\intita-autotests\\src\\test\\resources\\courses.csv"));
            reader.lines().forEach(s -> {
                String[] strArr = s.split(",");
                HashMap<CourseBox.CourseBoxFields, String> map = new HashMap<>();
                map.put(CourseBox.CourseBoxFields.COURSE_NAME, strArr[0]);
                map.put(CourseBox.CourseBoxFields.COURSE_LEVEL, strArr[1]);
                mapArrayList.add(map);
            });
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
        return mapArrayList;
    }
}