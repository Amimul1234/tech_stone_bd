package com.techstone.tech_stone_bd_project.dto;

import lombok.Data;
import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Date;

/**
 * @Author Amimul Ehsan
 * @Created at 11/7/21
 * @Project tech_stone_bd_project
 */

@Data
public class StudentDto {

    private Long studentId;

    @NotNull
    @Size(max = 100)
    private String firstName;

    @NotNull
    @Size(min = 100)
    private String lastName;

    @NotNull
    @Size(max = 500)
    private String fatherName;

    @NotNull
    @Size(max = 500)
    private String motherName;

    @URL
    @Size(max = 3000)
    private String imageUrl;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateOfBirth;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date joinDate;

    @NotNull
    @Pattern(regexp = "^(?:\\+88|01)?(?:\\d{11}|\\d{13})$",
            message = "Phone number format does not match")
    private String mobileNumber;

    @Email
    @Size(max = 500)
    private String emailId;

    @NotNull
    private Long classId;

    @NotNull
    private String gender;

    @NotNull
    private String religion;

    @NotNull
    private String group;

    @NotNull
    private String section;
}
