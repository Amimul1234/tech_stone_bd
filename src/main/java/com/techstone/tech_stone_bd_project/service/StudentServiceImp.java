package com.techstone.tech_stone_bd_project.service;

import com.techstone.tech_stone_bd_project.common.CommonResponse;
import com.techstone.tech_stone_bd_project.constants.Gender;
import com.techstone.tech_stone_bd_project.constants.Group;
import com.techstone.tech_stone_bd_project.constants.Religion;
import com.techstone.tech_stone_bd_project.constants.Section;
import com.techstone.tech_stone_bd_project.dto.StudentDto;
import com.techstone.tech_stone_bd_project.exception.NotFoundException;
import com.techstone.tech_stone_bd_project.mapper.ClassRoomMapper;
import com.techstone.tech_stone_bd_project.mapper.StudentMapper;
import com.techstone.tech_stone_bd_project.model.ClassRoomEntity;
import com.techstone.tech_stone_bd_project.model.StudentEntity;
import com.techstone.tech_stone_bd_project.repositories.ClassRoomRepo;
import com.techstone.tech_stone_bd_project.repositories.StudentRepo;
import com.techstone.tech_stone_bd_project.utils.AuditingManager;
import com.techstone.tech_stone_bd_project.utils.HttpReqRespUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static org.springframework.http.HttpStatus.OK;

/**
 * @Author Amimul Ehsan
 * @Created at 11/8/21
 * @Project tech_stone_bd_project
 */

@RequiredArgsConstructor
@Slf4j
@Service
public class StudentServiceImp implements StudentService {

    private final StudentRepo studentRepo;
    private final ClassRoomRepo classRoomRepo;

    private final StudentMapper studentMapper;
    private final ClassRoomMapper classRoomMapper;

    @Transactional
    @Override
    public CommonResponse createNewStudentRecord( StudentDto studentDto ) {
        log.debug("StudentServiceImp::createNewStudentRecord() method called ... ");

        ClassRoomEntity classRoom = classRoomRepo.findById(studentDto.getClassId()).orElseThrow(() ->
                new NotFoundException("Class with given id not found"));

        StudentEntity studentEntity = studentMapper.dtoToEntity(studentDto);

        studentEntity.setClassRoom(classRoom);
        classRoom.getStudentEntityList().add(studentEntity);

        AuditingManager.setCreationAuditingFields(studentEntity);
        AuditingManager.setUpdateAuditingFields(classRoom);

        ClassRoomEntity response = classRoomRepo.save(classRoom);

        return HttpReqRespUtils.sendResponseToClient(OK, "SUCCESS!",
                classRoomMapper.entityToDto(response));
    }

    @Override
    public CommonResponse getAllGenders() {
        return HttpReqRespUtils.sendResponseToClient(OK, "SUCCESS!",
                Gender.values());
    }

    @Override
    public CommonResponse getAllReligions() {
        return HttpReqRespUtils.sendResponseToClient(OK, "SUCCESS!",
                Religion.values());
    }

    @Override
    public CommonResponse getAllGroups() {
        return HttpReqRespUtils.sendResponseToClient(OK, "SUCCESS!",
                Group.values());
    }

    @Override
    public CommonResponse getAllSections() {
        return HttpReqRespUtils.sendResponseToClient(OK, "SUCCESS!",
                Section.values());
    }


}
