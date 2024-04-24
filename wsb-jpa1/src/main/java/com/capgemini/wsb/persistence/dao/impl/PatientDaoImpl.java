package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<PatientEntity> findByLastName(String lastName) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<PatientEntity> cq = cb.createQuery(PatientEntity.class);
        Root<PatientEntity> root = cq.from(PatientEntity.class);

        cq.where(cb.equal(root.get("lastName"), lastName)); // Use "lastName" instead of "lastname"

        TypedQuery<PatientEntity> query = entityManager.createQuery(cq);
        return query.getResultList();
    }


    @Override
    public List<PatientEntity> findPatientsWithMoreThanXVisits(int x) {
        String jpqlQuery = "SELECT p FROM PatientEntity p WHERE size(p.visits) > :x";
        TypedQuery<PatientEntity> query = entityManager.createQuery(jpqlQuery, PatientEntity.class);
        query.setParameter("x", x);
        return query.getResultList();
    }

    @Override
    public List<PatientEntity> findPatientsCreatedWithinAMonth() {
        LocalDateTime startDate = LocalDateTime.now().minusMonths(1);
        LocalDateTime endDate = LocalDateTime.now();

        String jpqlQuery = "SELECT p FROM PatientEntity p WHERE p.createdAt BETWEEN :startDate AND :endDate";
        TypedQuery<PatientEntity> query = entityManager.createQuery(jpqlQuery, PatientEntity.class);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        return query.getResultList();
    }
}