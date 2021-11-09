package com.techstone.tech_stone_bd_project.repositories;

import com.techstone.tech_stone_bd_project.model.StudentFeesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author Amimul Ehsan
 * @Created at 11/9/21
 * @Project tech_stone_bd_project
 */

@Repository
public interface StudentFeesRepo extends JpaRepository<StudentFeesEntity, Long> {
}
