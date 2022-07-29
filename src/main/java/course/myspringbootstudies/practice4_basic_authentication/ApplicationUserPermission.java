package course.myspringbootstudies.practice4_basic_authentication;

public enum ApplicationUserPermission {
    STUDENT_READ("student:read"),STUDENT_WRITE("student:write");


    private final String permission;

    public String getPermission() {
        return permission;
    }

    ApplicationUserPermission(String permission) {
        this.permission=permission;

    }
}
