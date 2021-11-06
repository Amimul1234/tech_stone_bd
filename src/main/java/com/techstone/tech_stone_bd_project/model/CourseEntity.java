package com.techstone.tech_stone_bd_project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.AUTO;

/**
 * @Author Amimul Ehsan
 * @Created at 11/7/21
 * @Project tech_stone_bd_project
 */

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "course")
public class CourseEntity extends AbstractAuditingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long courseId;

    @Column(name = "name", nullable = false, length = 400)
    private String name;

    @Column(name = "description", nullable = false, length = 3000)
    private String description;

    @Column(name = "full_marks", nullable = false)
    private Double fullMarks;

    @OneToMany(mappedBy = "courseEntity", fetch = LAZY,
            cascade = {PERSIST, MERGE, DETACH, REFRESH})
    private List<ResultEntity> resultEntities = new ArrayList<>();

    @ManyToOne
    @JsonBackReference
    private ExamEntity examEntity;
}
