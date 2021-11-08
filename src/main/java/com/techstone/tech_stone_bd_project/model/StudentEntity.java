package com.techstone.tech_stone_bd_project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.techstone.tech_stone_bd_project.constants.Gender;
import com.techstone.tech_stone_bd_project.constants.Group;
import com.techstone.tech_stone_bd_project.constants.Religion;
import com.techstone.tech_stone_bd_project.constants.Section;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.AUTO;

/**
 * @Author Amimul Ehsan
 * @Created at 11/6/21
 * @Project tech_stone_bd_project
 */

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "student")
public class StudentEntity extends AbstractAuditingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Column(name = "father_name", nullable = false, length = 500)
    private String fatherName;

    @Column(name = "mother_name", nullable = false, length = 500)
    private String motherName;

    @Column(name = "image_url", length = 3000)
    private String imageUrl;

    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;

    @Column(name = "join_date", nullable = false)
    private Date joinDate;

    @Column(name = "mobile_number", length = 15)
    private String mobileNumber;

    @Column(name = "email_id", length = 500)
    private String emailId;

    @Enumerated(STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @Enumerated(STRING)
    @Column(name = "religion", nullable = false)
    private Religion religion;

    @Enumerated(STRING)
    @Column(name = "group_name", nullable = false)
    private Group group;

    @Enumerated(STRING)
    @Column(name = "section", nullable = false)
    private Section section;

    @OneToMany(mappedBy = "studentEntity", fetch = LAZY,
            cascade = {PERSIST, MERGE, DETACH, REFRESH})
    private List<AttendanceEntity> attendanceEntities = new ArrayList<>();

    @ManyToMany
    private List<FeeEntity> feeEntities = new ArrayList<>();

    @OneToMany(mappedBy = "studentEntity", fetch = LAZY,
            cascade = {PERSIST, MERGE, DETACH, REFRESH})
    private List<ResultEntity> resultEntities = new ArrayList<>();

    @ManyToOne
    @JsonBackReference
    private ClassRoomEntity classRoom;
}
