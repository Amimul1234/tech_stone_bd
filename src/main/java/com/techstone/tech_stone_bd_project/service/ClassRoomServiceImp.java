package com.techstone.tech_stone_bd_project.service;

import com.techstone.tech_stone_bd_project.common.CommonResponse;
import com.techstone.tech_stone_bd_project.dto.ClassRoomDto;
import com.techstone.tech_stone_bd_project.repositories.ClassRoomRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

    @Override
    public CommonResponse createNewClass( ClassRoomDto classRoomDto ) {
        return null;
    }
}
