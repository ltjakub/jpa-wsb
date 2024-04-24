package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class VisitDaoImpl extends AbstractDao<VisitEntity, Long> implements VisitDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<VisitEntity> findAllByPatientId(Long patientId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<VisitEntity> cq = cb.createQuery(VisitEntity.class);
        Root<VisitEntity> root = cq.from(VisitEntity.class);

        cq.where(cb.equal(root.get("patient").get("id"), patientId));

        TypedQuery<VisitEntity> query = entityManager.createQuery(cq);
        return query.getResultList();
    }
}