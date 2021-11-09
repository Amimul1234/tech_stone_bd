package com.techstone.tech_stone_bd_project.service;

import com.techstone.tech_stone_bd_project.common.CommonResponse;
import com.techstone.tech_stone_bd_project.dto.FeeDto;
import com.techstone.tech_stone_bd_project.exception.NotFoundException;
import com.techstone.tech_stone_bd_project.mapper.FeeMapper;
import com.techstone.tech_stone_bd_project.model.FeeEntity;
import com.techstone.tech_stone_bd_project.repositories.FeeRepo;
import com.techstone.tech_stone_bd_project.utils.AuditingManager;
import com.techstone.tech_stone_bd_project.utils.HttpReqRespUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.OK;

/**
 * @Author Amimul Ehsan
 * @Created at 11/9/21
 * @Project tech_stone_bd_project
 */

@RequiredArgsConstructor
@Slf4j
@Service
public class FeeServiceImp implements FeeService {

    private final FeeRepo feeRepo;
    private final FeeMapper feeMapper;

    @Override
    public CommonResponse createFeeDto( FeeDto feeDto ) {
        log.debug("FeeServiceImp::createFeeDto() method called ... ");

        FeeEntity feeEntity = feeMapper.dtoToEntity(feeDto);
        AuditingManager.setCreationAuditingFields(feeEntity);

        FeeEntity response = feeRepo.save(feeEntity);

        return HttpReqRespUtils.sendResponseToClient(OK, "SUCCESS!",
                feeMapper.entityToDto(response));
    }

    @Override
    public CommonResponse getAllFeeRecords() {
        log.debug("FeeServiceImp::getAllFeeRecords() method called ... ");

        List<FeeEntity> feeEntities = feeRepo.findAll();

        return HttpReqRespUtils.sendResponseToClient(OK, "SUCCESS!", feeEntities.stream()
                .map(feeMapper::entityToDto).collect(Collectors.toList()));
    }

    @Override
    public CommonResponse updateFeeRecords( FeeDto feeDto ) {
        log.debug("FeeServiceImp::updateFeeRecords() method called ... ");

        FeeEntity previousFee = feeRepo.findById(feeDto.getFeeId()).orElseThrow(() ->
                new NotFoundException("Fee with given id does not exists"));
        FeeEntity updatedFee = feeMapper.dtoToEntity(feeDto);

        setUpdatedFields(previousFee, updatedFee);
        AuditingManager.setUpdateAuditingFields(previousFee);

        FeeEntity response = feeRepo.save(previousFee);

        return HttpReqRespUtils.sendResponseToClient(OK, "SUCCESS!",
                feeMapper.entityToDto(response));
    }

    private void setUpdatedFields( FeeEntity previousFee, FeeEntity updatedFee ) {
        previousFee.setFeeName(updatedFee.getFeeName());
        previousFee.setFeeAmount(updatedFee.getFeeAmount());
        previousFee.setIsEnabled(updatedFee.getIsEnabled());
    }
}
