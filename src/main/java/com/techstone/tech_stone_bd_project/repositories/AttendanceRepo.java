package com.techstone.tech_stone_bd_project.repositories;

import com.techstone.tech_stone_bd_project.model.AttendanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author Amimul Ehsan
 * @Created at 11/7/21
 * @Project tech_stone_bd_project
 */

@Repository
public interface AttendanceRepo extends JpaRepository<AttendanceEntity, Long> {
}
