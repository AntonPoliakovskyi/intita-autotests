package pages.courses;

import org.openqa.selenium.By;
//todo change 3-7 xpath
public enum CourseFilters {

    OUR_COURSE(By.xpath("//a[@href=\"/courses/all/ourcourses/\"]")),
    PARTHERS_COURSES(By.xpath("//a[@href=\"/courses/all/partnerscourses/\"]")),
    ALL_MODULES(By.xpath("//a[@href=\"/courses/all/ourcourses/\"]")),
    FOR_BEGINNERS(By.xpath("//a[@href=\"/courses/all/ourcourses/\"]")),
    FOR_PROFESSIONALS(By.xpath("//a[@href=\"/courses/all/ourcourses/\"]")),
    FOR_EXPERTS(By.xpath("//a[@href=\"/courses/all/ourcourses/\"]")),
    ALL_LEVELS(By.xpath("//a[@href=\"/courses/all/ourcourses/\"]"));

    private By filter;
    CourseFilters(By by) {
        this.filter = by;
    }

    public By getFilter() {
        return filter;
    }
}
