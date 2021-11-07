package com.techstone.tech_stone_bd_project.service;

import com.techstone.tech_stone_bd_project.common.CommonResponse;
import com.techstone.tech_stone_bd_project.dto.ExamDto;
import com.techstone.tech_stone_bd_project.exception.NotFoundException;
import com.techstone.tech_stone_bd_project.mapper.ExamMapper;
import com.techstone.tech_stone_bd_project.model.CourseEntity;
import com.techstone.tech_stone_bd_project.model.ExamEntity;
import com.techstone.tech_stone_bd_project.repositories.CourseRepo;
import com.techstone.tech_stone_bd_project.repositories.ExamRepo;
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
public class ExamServiceImp implements ExamService {

    private final ExamRepo examRepo;
    private final CourseRepo courseRepo;

    private final ExamMapper examMapper;

    @Override
    public CommonResponse createNewExam( ExamDto examDto ) {
        log.debug("ExamServiceImp::createNewExam() method called ... ");

        ExamEntity examEntity = examMapper.dtoToEntity(examDto);

        AuditingManager.setCreationAuditingFields(examEntity);

        ExamEntity response = examRepo.save(examEntity);

        return HttpReqRespUtils.sendResponseToClient(OK, "Successfully created exam!",
                examMapper.entityToDto(response));
    }

    @Override
    public CommonResponse updateExam( ExamDto examDto ) {
        log.debug("ExamServiceImp::updateExam() method called ... ");

        ExamEntity examEntity = examRepo.findById(examDto.getExamId()).orElseThrow(() ->
                new NotFoundException("Exam with id: " + examDto.getExamId() + "not found"));

        examEntity.setName(examDto.getName());
        examEntity.setStartDate(examDto.getStartDate());
        examEntity.setEndDate(examDto.getEndDate());

        AuditingManager.setUpdateAuditingFields(examEntity);

        ExamEntity response = examRepo.save(examEntity);

        return HttpReqRespUtils.sendResponseToClient(OK, "Exam updated successfully",
                examMapper.entityToDto(response));
    }

    @Transactional
    @Override
    public CommonResponse assignCourseToExam( Long examId, Long courseId ) {
        log.debug("CourseServiceImp::assignCourseToExam() method called ... ");

        ExamEntity examEntity = examRepo.findById(examId).orElseThrow(() ->
                new NotFoundException("Exam with given id not found"));

        CourseEntity courseEntity = courseRepo.findById(courseId).orElseThrow(() ->
                new NotFoundException("Course with given id not found"));


        examEntity.getCourseEntities().add(courseEntity);
        AuditingManager.setUpdateAuditingFields(examEntity);

        ExamEntity response = examRepo.save(examEntity);

        return HttpReqRespUtils.sendResponseToClient(OK, "SUCCESS!",
                examMapper.entityToDto(response));
    }
}
