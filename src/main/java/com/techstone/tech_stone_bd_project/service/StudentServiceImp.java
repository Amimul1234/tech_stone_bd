package com.techstone.tech_stone_bd_project.service;

import com.techstone.tech_stone_bd_project.common.CommonResponse;
import com.techstone.tech_stone_bd_project.constants.Gender;
import com.techstone.tech_stone_bd_project.constants.Group;
import com.techstone.tech_stone_bd_project.constants.Religion;
import com.techstone.tech_stone_bd_project.constants.Section;
import com.techstone.tech_stone_bd_project.dto.AttendanceDto;
import com.techstone.tech_stone_bd_project.dto.StudentDto;
import com.techstone.tech_stone_bd_project.exception.NotFoundException;
import com.techstone.tech_stone_bd_project.mapper.AttendanceMapper;
import com.techstone.tech_stone_bd_project.mapper.StudentMapper;
import com.techstone.tech_stone_bd_project.model.AttendanceEntity;
import com.techstone.tech_stone_bd_project.model.ClassRoomEntity;
import com.techstone.tech_stone_bd_project.model.StudentEntity;
import com.techstone.tech_stone_bd_project.repositories.ClassRoomRepo;
import com.techstone.tech_stone_bd_project.repositories.StudentRepo;
import com.techstone.tech_stone_bd_project.utils.AuditingManager;
import com.techstone.tech_stone_bd_project.utils.HttpReqRespUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    private final AttendanceMapper attendanceMapper;

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

        classRoomRepo.save(classRoom);

        return HttpReqRespUtils.sendResponseToClient(OK, "SUCCESS!",
                studentMapper.entityToDto(studentEntity));
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

    @Override
    public CommonResponse getAllStudentRecord( int pageNumber, int pageSize ) {
        log.debug("StudentServiceImp::getAllStudentRecord() method called ... ");

        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);

        Page<StudentEntity> allRecords = studentRepo.findAll(pageRequest);

        return HttpReqRespUtils.sendResponseToClient(OK, "SUCCESS!",
                allRecords.map(studentMapper::entityToDto));
    }

    @Transactional
    @Override
    public CommonResponse giveAttendanceToStudent( Long studentId, AttendanceDto attendanceDto ) {
        log.debug("StudentServiceImp::giveAttendanceToStudent() method called ... ");

        StudentEntity studentEntity = studentRepo.findById(studentId)
                .orElseThrow(() -> new NotFoundException("Student with given id not found"));

        AttendanceEntity attendanceEntity = attendanceMapper.dtoToEntity(attendanceDto);

        studentEntity.getAttendanceEntities().add(attendanceEntity);
        attendanceEntity.setStudentEntity(studentEntity);

        AuditingManager.setCreationAuditingFields(attendanceEntity);
        AuditingManager.setUpdateAuditingFields(studentEntity);

        StudentEntity response = studentRepo.save(studentEntity);

        return HttpReqRespUtils.sendResponseToClient(OK, "SUCCESS!",
                studentMapper.entityToDto(response));
    }

    @Override
    public CommonResponse getStudentRecord( Long studentId ) {
        log.debug("StudentServiceImp::getStudentRecord() method called ... ");

        StudentEntity studentEntity = studentRepo.findById(studentId)
                .orElseThrow(() -> new NotFoundException("Student with given id not found"));

        return HttpReqRespUtils.sendResponseToClient(OK, "SUCCESS!",
                studentMapper.entityToDto(studentEntity));
    }


}
