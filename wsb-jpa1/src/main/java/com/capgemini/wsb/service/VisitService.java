package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.VisitTO;

import java.util.List;

public interface VisitService {

    List<VisitTO> findAllByPatientId(Long patientId);

}
