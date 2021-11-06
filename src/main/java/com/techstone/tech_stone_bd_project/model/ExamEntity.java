package com.techstone.tech_stone_bd_project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
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
public class ExamEntity extends AbstractAuditingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "exam_id")
    private Long examId;

    @Column(name = "name", nullable = false, length = 400)
    private String Name;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @OneToMany(mappedBy = "examEntity", fetch = LAZY,
            cascade = {PERSIST, MERGE, DETACH, REFRESH})
    @JsonManagedReference
    private List<CourseEntity> courseEntities;


    @OneToMany(mappedBy = "examEntity", fetch = LAZY,
            cascade = {PERSIST, MERGE, DETACH, REFRESH})
    @JsonManagedReference
    private List<ResultEntity> resultEntities;

    @ManyToOne
    @JsonBackReference
    private ClassRoomEntity classRoom;
}
