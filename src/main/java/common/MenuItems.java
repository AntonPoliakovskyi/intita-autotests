package common;

public enum MenuItems {
    COURSES("courses"),
    TEAM("teachers"),
    ALUMNI("graduate"),
    ABOUT_US("aboutus"),
    VACANCIES("robotamolodi"),
    EVENTS("upcomingevents"),
    PARTNERS("forPartners"),
    LIBRARY("library");
    private String item;

    MenuItems(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }
}
