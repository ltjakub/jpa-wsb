package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.VisitEntity;

import java.util.List;

public interface VisitDao extends Dao<VisitEntity, Long> {

    public List<VisitEntity> findAllByPatientId(Long patientId);

}