package com.techstone.tech_stone_bd_project.service;

import com.techstone.tech_stone_bd_project.common.CommonResponse;
import com.techstone.tech_stone_bd_project.dto.*;

/**
 * @Author Amimul Ehsan
 * @Created at 11/8/21
 * @Project tech_stone_bd_project
 */

public interface StudentService  {
    CommonResponse createNewStudentRecord( StudentDto studentDto );

    CommonResponse getAllGenders();

    CommonResponse getAllReligions();

    CommonResponse getAllGroups();

    CommonResponse getAllSections();

    CommonResponse getAllStudentRecord( int pageNumber, int pageSize );

    CommonResponse giveAttendanceToStudent( Long studentId, AttendanceDto attendanceDto );

    CommonResponse getStudentRecord( Long studentId );

    CommonResponse createFeesRecord( Long studentId, FeeDto feeDto );

    CommonResponse getAllFeesRecord( Long studentId );

    CommonResponse assignResultToStudents( Long studentId, ResultDto resultDto );
}
