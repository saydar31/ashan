package ru.itis.ashan.entities.employer;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.entities.student.StudentDto;
import ru.itis.ashan.entities.user.UserDto;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class EmployerDto extends UserDto {

    private String companyName;

    private Set<StudentDto> studentDtoSet;

    private String phoneNumber;

    //не юзать, использется в других классах
    public static EmployerDto getDto(Employer employer) {
        return EmployerDto.builder()
                .companyName(employer.getCompanyName())
                .id(employer.getId())
                .phoneNumber(employer.getPhoneNumber())
                .mail(employer.getMail())
                .role(employer.getRole())
                .state(employer.getState())
                .build();
    }

    //для каста из model -> dto
    public static EmployerDto castToDto(Employer employer) {
        EmployerDto employerDto = EmployerDto.builder()
                .companyName(employer.getCompanyName())
                .id(employer.getId())
                .phoneNumber(employer.getPhoneNumber())
                .mail(employer.getMail())
                .role(employer.getRole())
                .state(employer.getState())
                .build();

        if (employer.getStudents() != null) {
            for (Student student : employer.getStudents()) {
                employerDto.studentDtoSet.add(StudentDto.getDto(student));
            }
        }
        return employerDto;
    }


}
