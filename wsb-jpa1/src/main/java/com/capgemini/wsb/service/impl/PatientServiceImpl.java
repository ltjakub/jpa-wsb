package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    private final PatientDao patientDao;

    @Autowired
    public PatientServiceImpl(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    @Override
    public Long createPatient(PatientTO patientTO) {
        PatientEntity patientEntity = PatientMapper.mapToEntity(patientTO.setCreatedAt(LocalDateTime.now()));
        PatientEntity savedEntity = patientDao.save(patientEntity);
        return savedEntity.getId();
    }

    @Override
    public PatientTO getPatientById(Long id) {
        return PatientMapper.mapToTO(patientDao.findOne(id));
    }

    @Override
    public void deletePatientById(Long id) {
        patientDao.delete(id);
    }
}
