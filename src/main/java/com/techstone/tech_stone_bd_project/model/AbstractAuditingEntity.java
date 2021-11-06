package com.techstone.tech_stone_bd_project.model;

import lombok.*;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * @Author Amimul Ehsan
 * @Created at 11/6/21
 * @Project tech_stone_bd_project
 */

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@MappedSuperclass
public class AbstractAuditingEntity {
    private String createdBy;
    private LocalDateTime createdAt;
    private String creationIp;
    private String updatedBy;
    private LocalDateTime updatedAt;
    private String updateIp;
}
