package na.pham.student.response;

import lombok.Getter;
import lombok.Setter;
import na.pham.student.entity.Student;

@Getter
@Setter
public class StudentResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    private AddressResponse addressResponse;

    public StudentResponse(Student student) {
        this.id = student.getId();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.email = student.getEmail();
//        this.street = student.getEmail();
//        this.city = student.getEmail();

    }
}
