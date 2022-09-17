package na.pham.student.service;

import na.pham.student.FeignClients.AddressFeignClients;
import na.pham.student.entity.Student;
import na.pham.student.repository.StudentRepository;
import na.pham.student.request.CreateStudentRequest;
import na.pham.student.response.AddressResponse;
import na.pham.student.response.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AddressFeignClients addressFeignClients;

    public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {
        Student student = new Student();
        student.setFirstName(createStudentRequest.getFirstName());
        student.setLastName(createStudentRequest.getLastName());
        student.setEmail(createStudentRequest.getEmail());
        student.setAddressId(createStudentRequest.getAddressId());

        studentRepository.save(student);
        return new StudentResponse(student);
    }

    public StudentResponse getById(Long id) {
        Student student = studentRepository.findById(id).get();
        StudentResponse studentResponse = new StudentResponse(student);
        studentResponse.setAddressResponse(getAddressById(student.getAddressId()));
        return studentResponse;
    }

    private AddressResponse getAddressById(Long addressId) {
        return addressFeignClients.getAddressById(addressId);
    }
}
