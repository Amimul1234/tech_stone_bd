package com.techstone.tech_stone_bd_project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.AUTO;

/**
 * @Author Amimul Ehsan
 * @Created at 11/7/21
 * @Project tech_stone_bd_project
 */

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "result")
public class ResultEntity extends AbstractAuditingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long resultId;

    @Column(name = "marks", nullable = false)
    private Double marks;

    @ManyToOne
    @JsonBackReference
    private CourseEntity courseEntity;

    @ManyToOne
    @JsonBackReference
    private StudentEntity studentEntity;

    @ManyToOne
    @JsonBackReference
    private ExamEntity examEntity;
}
