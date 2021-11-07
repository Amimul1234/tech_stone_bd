package com.techstone.tech_stone_bd_project.service;

import com.techstone.tech_stone_bd_project.common.CommonResponse;
import com.techstone.tech_stone_bd_project.dto.CourseDto;
import com.techstone.tech_stone_bd_project.mapper.CourseMapper;
import com.techstone.tech_stone_bd_project.model.CourseEntity;
import com.techstone.tech_stone_bd_project.repositories.CourseRepo;
import com.techstone.tech_stone_bd_project.utils.AuditingManager;
import com.techstone.tech_stone_bd_project.utils.HttpReqRespUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static org.springframework.http.HttpStatus.OK;

/**
 * @Author Amimul Ehsan
 * @Created at 11/7/21
 * @Project tech_stone_bd_project
 */

@RequiredArgsConstructor
@Slf4j
@Service
public class CourseServiceImp implements CourseService {

    private final CourseRepo courseRepo;
    private final CourseMapper courseMapper;

    @Override
    public CommonResponse createNewCourse( CourseDto courseDto ) {
        log.debug("CourseServiceImp::createNewCourse() method called ... ");

        CourseEntity courseEntity = courseMapper.dtoToEntity(courseDto);

        AuditingManager.setCreationAuditingFields(courseEntity);

        CourseEntity response = courseRepo.save(courseEntity);

        return HttpReqRespUtils.sendResponseToClient(OK, "SUCCESS!",
                courseMapper.entityToDto(response));
    }

    @Override
    public CommonResponse updateExistingCourse( CourseDto courseDto ) {
        log.debug("CourseServiceImp::updateExistingCourse() method called ... ");



        return null;
    }
}
