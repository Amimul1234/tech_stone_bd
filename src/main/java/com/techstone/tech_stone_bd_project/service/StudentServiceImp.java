package com.techstone.tech_stone_bd_project.service;

import com.techstone.tech_stone_bd_project.common.CommonResponse;
import com.techstone.tech_stone_bd_project.constants.Gender;
import com.techstone.tech_stone_bd_project.constants.Group;
import com.techstone.tech_stone_bd_project.constants.Religion;
import com.techstone.tech_stone_bd_project.constants.Section;
import com.techstone.tech_stone_bd_project.dto.*;
import com.techstone.tech_stone_bd_project.exception.NotFoundException;
import com.techstone.tech_stone_bd_project.mapper.AttendanceMapper;
import com.techstone.tech_stone_bd_project.mapper.StudentFeesMapper;
import com.techstone.tech_stone_bd_project.mapper.StudentMapper;
import com.techstone.tech_stone_bd_project.model.*;
import com.techstone.tech_stone_bd_project.repositories.ClassRoomRepo;
import com.techstone.tech_stone_bd_project.repositories.FeeRepo;
import com.techstone.tech_stone_bd_project.repositories.StudentFeesRepo;
import com.techstone.tech_stone_bd_project.repositories.StudentRepo;
import com.techstone.tech_stone_bd_project.utils.AuditingManager;
import com.techstone.tech_stone_bd_project.utils.HttpReqRespUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

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
    private final StudentFeesRepo studentFeesRepo;
    private final FeeRepo feeRepo;

    private final StudentMapper studentMapper;
    private final AttendanceMapper attendanceMapper;
    private final StudentFeesMapper studentFeesMapper;

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

    @Override
    public CommonResponse createFeesRecord( Long studentId, FeeDto feeDto ) {

        studentRepo.findById(studentId).orElseThrow(() ->
                new NotFoundException("Student with given id not found"));

        FeeEntity feeEntity = feeRepo.findById(feeDto.getFeeId())
                .orElseThrow(() -> new NotFoundException("Fee with given id not found"));

        StudentFeesEntity studentFeesEntity = new StudentFeesEntity();

        studentFeesEntity.setFeeEntity(feeEntity);
        studentFeesEntity.setStudentId(studentId);

        AuditingManager.setCreationAuditingFields(studentFeesEntity);

        studentFeesRepo.save(studentFeesEntity);

        return HttpReqRespUtils.sendResponseToClient(OK, "SUCCESS!",
                feeDto);
    }

    @Override
    public CommonResponse getAllFeesRecord( Long studentId ) {

        studentRepo.findById(studentId)
                .orElseThrow(() -> new NotFoundException("Student with given id not found"));

        List<StudentFeesDto> result = studentFeesRepo.findAll()
                .stream()
                .map(studentFeesMapper::entityToDto)
                .collect(Collectors.toList());


        return HttpReqRespUtils.sendResponseToClient(OK, "SUCCESS!", result);
    }

    @Override
    public CommonResponse assignResultToStudents( Long studentId, ResultDto resultDto ) {
        return null;
    }
}
