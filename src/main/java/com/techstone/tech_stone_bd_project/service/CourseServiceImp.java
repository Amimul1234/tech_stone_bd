package com.techstone.tech_stone_bd_project.service;

import com.techstone.tech_stone_bd_project.common.CommonResponse;
import com.techstone.tech_stone_bd_project.dto.CourseDto;
import com.techstone.tech_stone_bd_project.exception.NotFoundException;
import com.techstone.tech_stone_bd_project.mapper.CourseMapper;
import com.techstone.tech_stone_bd_project.model.CourseEntity;
import com.techstone.tech_stone_bd_project.model.ResultEntity;
import com.techstone.tech_stone_bd_project.repositories.CourseRepo;
import com.techstone.tech_stone_bd_project.repositories.ResultRepo;
import com.techstone.tech_stone_bd_project.utils.AuditingManager;
import com.techstone.tech_stone_bd_project.utils.HttpReqRespUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
    private final ResultRepo resultRepo;

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

        CourseEntity previous = courseRepo.findById(courseDto.getCourseId()).orElseThrow(() ->
                new NotFoundException("Course with id : " + courseDto.getCourseId() + " not found"));

        CourseEntity updated = courseMapper.dtoToEntity(courseDto);
        setUpdatedFields(updated, previous);
        AuditingManager.setUpdateAuditingFields(previous);

        CourseEntity response = courseRepo.save(previous);

        return HttpReqRespUtils.sendResponseToClient(OK, "SUCCESS!",
                courseMapper.entityToDto(response));
    }

    @Transactional
    @Override
    public CommonResponse assignResultToCourse( Long courseId, Long resultId ) {
        log.debug("CourseServiceImp::assignResultToCourse() method called ... ");

        CourseEntity courseEntity = courseRepo.findById(courseId).orElseThrow(() ->
                new NotFoundException("Course with given id not found"));

        ResultEntity resultEntity = resultRepo.findById(resultId).orElseThrow(() ->
                new NotFoundException("Result with given id not found"));

        resultEntity.setCourseEntity(courseEntity);
        courseEntity.getResultEntities().add(resultEntity);

        AuditingManager.setUpdateAuditingFields(courseEntity);
        AuditingManager.setUpdateAuditingFields(resultEntity);

        CourseEntity response = courseRepo.save(courseEntity);

        return HttpReqRespUtils.sendResponseToClient(OK, "SUCCESS!",
                courseMapper.entityToDto(response));
    }

    private void setUpdatedFields( CourseEntity updated, CourseEntity previous ) {
        previous.setName(updated.getName());
        previous.setDescription(updated.getDescription());
        previous.setFullMarks(updated.getFullMarks());
    }
}
