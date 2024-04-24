package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PatientDaoImplTest {

    @Autowired
    private PatientDaoImpl patientDao;

    @Test
    public void testFindByLastName() {
        // given
        String lastName = "Smith";

        // when
        List<PatientEntity> result = patientDao.findByLastName(lastName);

        // then
        assertEquals(1, result.size());
    }

    @Test
    public void testFindPatientsWithMoreThanXVisits() {
        // given
        int minVisits = 20;

        // when
        List<PatientEntity> result = patientDao.findPatientsWithMoreThanXVisits(minVisits);

        // then
        assertEquals(0, result.size());
    }

    @Test
    public void testFindPatientsCreatedWithinAMonth() {
        // when
        List<PatientEntity> result = patientDao.findPatientsCreatedWithinAMonth();

        // then
        assertEquals(2, result.size());
    }
}
