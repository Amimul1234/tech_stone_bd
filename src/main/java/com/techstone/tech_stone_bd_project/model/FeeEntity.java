package com.techstone.tech_stone_bd_project.model;

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
@Table(name = "fee")
public class FeeEntity extends AbstractAuditingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "fee_id", nullable = false)
    private Long feeId;

    @Column(name = "fee_name", nullable = false, length = 500)
    private String feeName;

    @Column(name = "fee_amount", nullable = false)
    private Double feeAmount;

    @Column(name = "is_enabled", nullable = false)
    private Boolean isEnabled;
}
