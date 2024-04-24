package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;

public interface PatientService {

    Long createPatient(PatientTO patientTO);

    PatientTO getPatientById(Long id);

    void deletePatientById(Long id);

}
