package com.techstone.tech_stone_bd_project.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

/**
 * @Author Amimul Ehsan
 * @Created at 11/9/21
 * @Project tech_stone_bd_project
 */

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class StudentFeesEntity extends AbstractAuditingEntity implements Serializable {
    @Id
    private Long id;

    @Column(name = "student_id", nullable = false)
    private Long studentId;

    @OneToOne
    private FeeEntity feeEntity;
}
