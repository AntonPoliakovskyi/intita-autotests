package pages.courses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BasePage;


import java.util.ArrayList;
import java.util.HashMap;

public class CoursesPage extends BasePage {


    private final static By courseBox = By.xpath("//div[@class=\"courseBox\"]");

    private final static By courseName = By.xpath("//div[@class=\"courseName\"]/a[contains(.,'%s')]");

    private final static String courseBoxByName = "//a[contains(.,'%s')]/ancestor::div[@class=\"courseBox\"]";


    public CoursesPage() {
       waitForPageTobeLoaded();
    }


   public ArrayList<String> getCourseNameList(){
       ArrayList<CourseBox> boxes = getCourseBoxes();
       ArrayList<String> names = new ArrayList<>();
       for(CourseBox box : boxes){
           names.add(box.getCourseName());
       }
       return names;
   }

    private ArrayList<CourseBox> getCourseBoxes(){
        ArrayList<WebElement> courseBoxesE = (ArrayList<WebElement>) findElements(courseBox);
        ArrayList<CourseBox> courseBoxes = new ArrayList<>();
        for (WebElement el : courseBoxesE) {
            courseBoxes.add(new CourseBox(el));
        }
        return courseBoxes;
    }

    private CourseBox getCourseBoxByName(String courseName){
        return new CourseBox(findElement(By.xpath(String.format(courseBoxByName, courseName))));
    }

    public void printCourseObjectsMap(){
        ArrayList<CourseBox> courseBoxes = new ArrayList<>();
        courseBoxes = getCourseBoxes();
        for (CourseBox box : courseBoxes){
            System.out.println(box.getCourseHashMap());
        }

    }




}