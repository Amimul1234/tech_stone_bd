package com.techstone.tech_stone_bd_project.model;

import com.techstone.tech_stone_bd_project.constants.Gender;
import com.techstone.tech_stone_bd_project.constants.Religion;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.AUTO;

/**
 * @Author Amimul Ehsan
 * @Created at 11/6/21
 * @Project tech_stone_bd_project
 */

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class StudentEntity extends AbstractAuditingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @Column(nullable = false)
    private Long rollNumber;

    @Column(nullable = false, length = 3000)
    private String name;

    @Enumerated(value = STRING)
    @Column(nullable = false)
    private Gender gender;

    @Enumerated(value = STRING)
    @Column(nullable = false)
    private Religion religion;

    @Column(nullable = false, length = 3000)
    private String fatherName;

    @Column(nullable = false, length = 3000)
    private String motherName;

    @Column(length = 15)
    private String mobileNumber;


}
