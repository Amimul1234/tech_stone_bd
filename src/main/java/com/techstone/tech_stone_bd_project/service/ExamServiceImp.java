package com.techstone.tech_stone_bd_project.service;

import com.techstone.tech_stone_bd_project.common.CommonResponse;
import com.techstone.tech_stone_bd_project.dto.ExamDto;
import com.techstone.tech_stone_bd_project.mapper.ExamMapper;
import com.techstone.tech_stone_bd_project.model.ExamEntity;
import com.techstone.tech_stone_bd_project.repositories.ExamRepo;
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
public class ExamServiceImp implements ExamService {

    private final ExamRepo examRepo;
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
    public CommonResponse updateExamName( ExamDto examDto ) {
        log.debug("ExamServiceImp::updateExamName() method called ... ");
        return null;
    }
}
