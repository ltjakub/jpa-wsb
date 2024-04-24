package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VisitServiceImplTest {

    @Mock
    private VisitDao visitDao;

    @InjectMocks
    private VisitServiceImpl visitService;

    @Test
    public void testFindAllByPatientId() {
        // given
        when(visitDao.findAllByPatientId(anyLong())).thenReturn(getVisitEntities());

        // when
        List<VisitTO> result = visitService.findAllByPatientId(1L);

        // then
        assertEquals(2, result.size(), "Number of visits should match");
    }

    private List<VisitEntity> getVisitEntities() {
        VisitEntity visit1 = new VisitEntity();
        visit1.setId(1L);
        VisitEntity visit2 = new VisitEntity();
        visit2.setId(2L);
        return Arrays.asList(visit1, visit2);
    }
}
