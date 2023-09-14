package com.trading.TradingUpFundationBackend.Service.LevelTradingService.LevelTradingServiceIMPL;

import com.trading.TradingUpFundationBackend.Commons.Constant.Response.ContentTradingResponse.IContentTradingResponse;
import com.trading.TradingUpFundationBackend.Commons.Constant.Response.ExcerciseTradingResponse.IExcerciseTradingResponse;
import com.trading.TradingUpFundationBackend.Commons.Constant.Response.GeneralResponse;
import com.trading.TradingUpFundationBackend.Commons.Constant.Response.LevelTradingResponse.ILevelTradingResponse;
import com.trading.TradingUpFundationBackend.Commons.Converter.LevelTradingConverter.LevelTradingConverter;
import com.trading.TradingUpFundationBackend.Commons.Domains.DTO.ExcerciseTradingDTO.ExcerciseTradingDTO;
import com.trading.TradingUpFundationBackend.Commons.Domains.DTO.LevelTradingDTO.LevelTradingDTO;
import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.ExcerciseTradingEntity.ExcerciseTradingEntity;
import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.LevelTradingEntity.LevelTradingEntity;
import com.trading.TradingUpFundationBackend.Commons.Domains.ResponseDTO.GenericResponseDTO;
import com.trading.TradingUpFundationBackend.Repository.LevelTradingRepository.ILevelTradingRepository;
import com.trading.TradingUpFundationBackend.Service.LevelTradingService.ILevelTradingService;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class LevelTradingService implements ILevelTradingService {
    @Autowired
    private ILevelTradingRepository repository;
    @Autowired
    private LevelTradingConverter converter;

    @Override
    public ResponseEntity<GenericResponseDTO> createLevelTrading(LevelTradingDTO levelTradingDTO) {
        try {
            Optional<LevelTradingEntity> levelTradingExist = this.repository.findById(levelTradingDTO.getId());
            if (!levelTradingExist.isPresent()) {
                LevelTradingEntity entity = this.converter.converterLevelTradingDTOToLevelTradingEntity(levelTradingDTO);
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_SUCCESS)
                        .httpResponse(HttpStatus.OK.value())
                        .objectResponse(ILevelTradingResponse.LEVEL_REGISTRATION_SUCCESS)
                        .build());
            } else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_FAIL)
                        .objectResponse(ILevelTradingResponse.LEVEL_REGISTRATION_FAILED)
                        .httpResponse(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        } catch (Exception e) {
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body(GenericResponseDTO.builder()
                            .message(GeneralResponse.INTERNAL_SERVER_ERROR)
                            .objectResponse(null)
                            .httpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }

    @Override
    public ResponseEntity<GenericResponseDTO> readLevelTrading(LevelTradingDTO levelTradingDTO) {
        try {
            Optional<LevelTradingEntity> levelTradingExist = this.repository.findById(levelTradingDTO.getId());
            if (!levelTradingExist.isPresent()) {
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_SUCCESS)
                        .objectResponse(levelTradingExist)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_FAIL)
                        .objectResponse(ILevelTradingResponse.LEVEL_SEARCHED_FAILED)
                        .httpResponse(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        } catch (Exception e) {
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(GenericResponseDTO.builder()
                    .message(GeneralResponse.INTERNAL_SERVER_ERROR)
                    .objectResponse(null)
                    .httpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build());
        }
    }

    @Override
    public ResponseEntity<GenericResponseDTO> readLevelsTrading() {
        try {
            List<LevelTradingEntity> levelTradingEntityList = this.repository.findAll();
            if (!levelTradingEntityList.isEmpty()) {
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_SUCCESS)
                        .objectResponse(levelTradingEntityList)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_FAIL)
                        .objectResponse(ILevelTradingResponse.LEVEL_SEARCHED_FAILED)
                        .httpResponse(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        } catch (Exception e) {
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(GenericResponseDTO.builder()
                            .message(GeneralResponse.INTERNAL_SERVER_ERROR)
                            .objectResponse(null)
                            .httpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }

    @Override
    public ResponseEntity<GenericResponseDTO> updateLevelTrading(LevelTradingDTO levelTradingDTO) {
        try {
            Optional<LevelTradingEntity> levelTradingExist = this.repository.findById(levelTradingDTO.getId());
            if (!levelTradingExist.isPresent()) {
                LevelTradingEntity entity = this.converter.converterLevelTradingDTOToLevelTradingEntity(levelTradingDTO);
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_SUCCESS)
                        .objectResponse(ILevelTradingResponse.LEVEL_UPDATED_SUCCESS)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_FAIL)
                        .objectResponse(ILevelTradingResponse.LEVEL_UPDATED_FAILED)
                        .httpResponse(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        } catch (Exception e) {
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(GenericResponseDTO.builder()
                            .message(GeneralResponse.INTERNAL_SERVER_ERROR)
                            .objectResponse(null)
                            .httpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }

    @Override
    public ResponseEntity<GenericResponseDTO> deleteLevelTrading(Integer levelId) {
        try {
            Optional<LevelTradingEntity> levelTradingExist = this.repository.findById(levelId);
            if (levelTradingExist.isPresent()) {
                this.repository.deleteById(levelId);
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_SUCCESS)
                        .objectResponse(ILevelTradingResponse.LEVEL_DELETED_SUCCESS)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_FAIL)
                        .objectResponse(ILevelTradingResponse.LEVEL_DELETED_FAILED)
                        .httpResponse(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        } catch (Exception e) {
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(GenericResponseDTO.builder()
                            .message(GeneralResponse.INTERNAL_SERVER_ERROR)
                            .objectResponse(null)
                            .httpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }
}