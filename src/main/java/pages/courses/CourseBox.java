package pages.courses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

class CourseBox {

    private final WebElement courseBox;

    private final static By courseNameBy = By.xpath("./descendant::div[@class='courseName']/a");
    private final String courseName;

    private final static By courseLevelBy = By.xpath("./descendant::span[@class='courseLevel']");
    private final String courseLevel;


    enum CourseBoxFields {
        COURSE_NAME,
        COURSE_LEVEL
    }

    public CourseBox(WebElement courseBox) {
        this.courseBox = courseBox;

        this.courseName = courseBox.findElement(courseNameBy).getText();
        this.courseLevel = courseBox.findElement(courseLevelBy).getText();
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseLevel() {
        return courseLevel;
    }

    public HashMap<CourseBoxFields, String> getCourseHashMap() {
        HashMap<CourseBoxFields, String> courseBoxStringHashMap = new HashMap<>();
        courseBoxStringHashMap.put(CourseBoxFields.COURSE_NAME, getCourseName());
        courseBoxStringHashMap.put(CourseBoxFields.COURSE_LEVEL, getCourseLevel());
        return courseBoxStringHashMap;
    }

}
