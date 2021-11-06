package com.techstone.tech_stone_bd_project.utils;

import com.techstone.tech_stone_bd_project.model.AbstractAuditingEntity;

import java.time.LocalDateTime;

/**
 * @Author Amimul Ehsan
 * @Created at 11/6/21
 * @Project tech_stone_bd_project
 */

public class AuditingManager {

    public static void setCreationAuditingFields( AbstractAuditingEntity abstractAuditingEntity ) {
        abstractAuditingEntity.setCreatedBy(HttpReqRespUtils.getClient());
        abstractAuditingEntity.setCreatedAt(LocalDateTime.now());
        abstractAuditingEntity.setCreationIp(HttpReqRespUtils.getClientIpAddressIfServletRequestExist());
    }

    public static void setUpdateAuditingFields( AbstractAuditingEntity abstractAuditingEntity ) {
        abstractAuditingEntity.setUpdatedBy(HttpReqRespUtils.getClient());
        abstractAuditingEntity.setUpdatedAt(LocalDateTime.now());
        abstractAuditingEntity.setUpdateIp(HttpReqRespUtils.getClientIpAddressIfServletRequestExist());
    }
}
