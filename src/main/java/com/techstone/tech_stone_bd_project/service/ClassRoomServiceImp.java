package com.techstone.tech_stone_bd_project.service;

import com.techstone.tech_stone_bd_project.common.CommonResponse;
import com.techstone.tech_stone_bd_project.dto.ClassRoomDto;
import com.techstone.tech_stone_bd_project.exception.NotFoundException;
import com.techstone.tech_stone_bd_project.mapper.ClassRoomMapper;
import com.techstone.tech_stone_bd_project.model.ClassRoomEntity;
import com.techstone.tech_stone_bd_project.model.ExamEntity;
import com.techstone.tech_stone_bd_project.repositories.ClassRoomRepo;
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
public class ClassRoomServiceImp implements ClassRoomService {

    private final ClassRoomRepo classRoomRepo;
    private final ExamRepo examRepo;

    private final ClassRoomMapper classRoomMapper;

    @Override
    public CommonResponse createNewClass( ClassRoomDto classRoomDto ) {
        log.info("ClassRoomServiceImp::createNewClass() method called ... ");

        ClassRoomEntity classRoom = classRoomMapper.dtoToEntity(classRoomDto);

        AuditingManager.setCreationAuditingFields(classRoom);

        ClassRoomEntity response = classRoomRepo.save(classRoom);

        return HttpReqRespUtils.sendResponseToClient(OK, "SUCCESS!",
                classRoomMapper.entityToDto(response));
    }

    @Transactional
    @Override
    public CommonResponse assignExamToClass( Long classId, Long examId ) {
        log.info("ClassRoomServiceImp::assignExamToClass() method called ... ");

        ClassRoomEntity classRoom = classRoomRepo.findById(classId).orElseThrow(() ->
                new NotFoundException("Class with given id not found"));

        ExamEntity examEntity = examRepo.findById(examId).orElseThrow(() ->
                new NotFoundException("Exam with given id not found"));

        examEntity.setClassRoom(classRoom);
        classRoom.getExamEntities().add(examEntity);

        AuditingManager.setUpdateAuditingFields(classRoom);
        AuditingManager.setUpdateAuditingFields(examEntity);

        ClassRoomEntity response = classRoomRepo.save(classRoom);

        return HttpReqRespUtils.sendResponseToClient(OK, "SUCCESS!",
                classRoomMapper.entityToDto(response));
    }
}
