package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.AddressTO;
import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.service.PatientService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PatientServiceImplTest {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private VisitDao visitDao;

    @Test
    @Transactional
    @Order(1)
    public void testPatientToMapping() {
        // given
        PatientTO patientTO = new PatientTO();
        patientTO.setFirstName("John");
        patientTO.setLastName("Doe");
        patientTO.setTelephoneNumber("123456789");
        patientTO.setEmail("john.doe@example.com");
        patientTO.setPatientNumber("P123456");
        patientTO.setAddresses(List.of(new AddressTO()));
        patientTO.setCreatedAt(LocalDateTime.now());
        patientTO.setDateOfBirth(LocalDate.of(1990, 1, 1));

        patientService.createPatient(patientTO);
        // when
        PatientTO patientById = patientService.getPatientById(3L);


        //then
        assertEquals("John", patientTO.getFirstName());
        assertEquals("Doe", patientTO.getLastName());
        assertEquals("123456789", patientTO.getTelephoneNumber());
        assertEquals("john.doe@example.com", patientTO.getEmail());
        assertEquals("P123456", patientTO.getPatientNumber());
        assertEquals(1, patientTO.getAddresses().size());
        assertEquals(LocalDateTime.now().getDayOfYear(), patientTO.getCreatedAt().getDayOfYear());
        assertEquals(LocalDate.of(1990, 1, 1), patientTO.getDateOfBirth());
    }

    @Test
    @Transactional
    @Order(2)
    public void testDeletePatientCascade() {
        // given

        // when
        patientService.deletePatientById(1L);
        patientService.deletePatientById(2L);

        //then
        assertTrue(patientDao.findAll().isEmpty());
        assertTrue(visitDao.findAll().isEmpty());
    }
}
