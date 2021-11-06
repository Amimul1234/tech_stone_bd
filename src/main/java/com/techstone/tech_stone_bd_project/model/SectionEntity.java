package com.techstone.tech_stone_bd_project.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.AUTO;

/**
 * @Author Amimul Ehsan
 * @Created at 11/6/21
 * @Project tech_stone_bd_project
 */

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "section")
public class SectionEntity extends AbstractAuditingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "serial")
    private Long serial;

    @Column(name = "name", nullable = false, length = 70)
    private String name;

    @Column(name = "status", nullable = false)
    private Boolean status;
}
