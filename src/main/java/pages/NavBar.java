package pages;

import pages.courses.CoursesPage;
import org.openqa.selenium.By;

public interface NavBar {
     String menuItem = "//tr[@class=\"main\"]/descendant::node()/a[text()[contains(.,'%s')]]";
     By coursesBtn = By.xpath(String.format(menuItem, "Курси") + "|" + String.format(menuItem, "pages.courses.AvailableCourses") + "|" + String.format(menuItem, "Курсы"));

     default CoursesPage navigateToCoursePage(){

         return new CoursesPage();
     }
}
