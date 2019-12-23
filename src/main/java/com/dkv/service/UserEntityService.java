package com.dkv.service;

import com.dkv.configuration.log4j2.LoggerType;
import com.dkv.configuration.log4j2.PerformanceLogAudit;
import com.dkv.model.UserEntity;
import com.dkv.repository.UserEntityRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class UserEntityService {

    private Logger logger = LogManager.getLogger(LoggerType.INFO.getValue());
    private UserEntityRepository userEntityRepository;

    public UserEntityService(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @PerformanceLogAudit
    public UserEntity getUser() {
        UserEntity userEntity = new UserEntity("Syed Mainul Hasan");
        logger.info(userEntity.toString());
        userEntityRepository.save(userEntity);
        return userEntity;
    }
}
