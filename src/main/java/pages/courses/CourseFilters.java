package pages.courses;

import org.openqa.selenium.By;

//todo change 3-7 xpath
public enum CourseFilters {

    OUR_COURSE(By.xpath("//a[@href=\"/courses/all/ourcourses/\"]"), ""),
    PARTHERS_COURSES(By.xpath("//a[@href=\"/courses/all/partnerscourses/\"]"), ""),
    ALL_MODULES(By.xpath("//a[@href=\"/courses/all/ourcourses/\"]"), ""),
    FOR_BEGINNERS(By.xpath("//a[@href=\"/courses/junior/allcourses/\"]"), "for_beginners"),
    FOR_PROFESSIONALS(By.xpath("//a[@href=\"/courses/middle/ourcourses/\"]"), "for_professionals"),
    FOR_EXPERTS(By.xpath("//a[@href=\"/courses/all/ourcourses/\"]"), ""),
    ALL_LEVELS(By.xpath("//a[@href=\"/courses/all/ourcourses/\"]"), "all_levels");

    private By filter;
    private String filterName;

    CourseFilters(By by, String s) {
        this.filter = by;
        this.filterName = s;
    }

    public By getFilter() {
        return filter;
    }

    public String getFilterName() {
        return filterName;
    }

}
