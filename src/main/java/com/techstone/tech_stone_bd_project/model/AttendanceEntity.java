package com.techstone.tech_stone_bd_project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

import static javax.persistence.GenerationType.AUTO;

/**
 * @Author Amimul Ehsan
 * @Created at 11/7/21
 * @Project tech_stone_bd_project
 */

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "attendance")
public class AttendanceEntity extends AbstractAuditingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "attendance_id")
    private Long attendanceId;

    @Column(name = "attendance_date", nullable = false)
    private Date attendanceDate;

    @Column(name = "is_present", nullable = false)
    private Boolean isPresent;

    @Column(name = "remarks", nullable = false, length = 500)
    private String remarks;

    @ManyToOne
    @JsonBackReference
    private StudentEntity studentEntity;
}
