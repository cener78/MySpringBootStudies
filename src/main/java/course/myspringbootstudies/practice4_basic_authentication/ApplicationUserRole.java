package course.myspringbootstudies.practice4_basic_authentication;





import com.google.common.collect.Sets;
// Sets in uzerine tikladik more action, search dependence add google.collection

import java.util.Set;

import static course.myspringbootstudies.practice4_basic_authentication.ApplicationUserPermission.STUDENT_READ;
import static course.myspringbootstudies.practice4_basic_authentication.ApplicationUserPermission.STUDENT_WRITE;

public enum ApplicationUserRole {
    STUDENT(Sets.newHashSet(STUDENT_READ)),ADMIN(Sets.newHashSet(STUDENT_READ,STUDENT_WRITE));


    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions=permissions;
    }


}
