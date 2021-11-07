package com.techstone.tech_stone_bd_project.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.techstone.tech_stone_bd_project.constants.Group;
import com.techstone.tech_stone_bd_project.constants.Section;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
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
@Table(name = "class_room")
public class ClassRoomEntity extends AbstractAuditingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "class_id")
    private Long classId;

    @Column(name = "class_name", nullable = false, length = 500)
    private String className;

    @Enumerated(STRING)
    @Column(name = "class_group", nullable = false)
    private Group group;

    @Enumerated(STRING)
    @Column(name = "section", nullable = false)
    private Section section;

    @Column(name = "remarks", length = 200)
    private String remarks;

    @OneToMany(mappedBy = "classRoom", fetch = LAZY,
            cascade = {PERSIST, MERGE, DETACH, REFRESH})
    @JsonManagedReference
    private List<ExamEntity> examEntities = new ArrayList<>();

    @OneToMany(mappedBy = "classRoom", fetch = LAZY,
            cascade = {PERSIST, MERGE, DETACH, REFRESH})
    @JsonManagedReference
    private List<StudentEntity> studentEntityList = new ArrayList<>();
}
