package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.entity.PatientEntity;

import java.util.List;
import java.util.stream.Collectors;

public final class PatientMapper {

    private PatientMapper() {
    }

    public static PatientTO mapToTO(final PatientEntity patientEntity) {
        if (patientEntity == null) {
            return null;
        }
        final PatientTO patientTO = new PatientTO();
        patientTO.setId(patientEntity.getId());
        patientTO.setFirstName(patientEntity.getFirstName());
        patientTO.setLastName(patientEntity.getLastName());
        patientTO.setTelephoneNumber(patientEntity.getTelephoneNumber());
        patientTO.setEmail(patientEntity.getEmail());
        patientTO.setPatientNumber(patientEntity.getPatientNumber());
        patientTO.setDateOfBirth(patientEntity.getDateOfBirth());
        patientTO.setAddresses(patientEntity.getAddresses().stream().map(AddressMapper::mapToTO).collect(Collectors.toList()));
        patientTO.setVisits(patientEntity.getVisits().stream().map(VisitMapper::mapToTO).collect(Collectors.toList()));
        patientTO.setCreatedAt(patientEntity.getCreatedAt());
        return patientTO;
    }

    public static PatientEntity mapToEntity(final PatientTO patientTO) {
        if (patientTO == null) {
            return null;
        }
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(patientTO.getId());
        patientEntity.setFirstName(patientTO.getFirstName());
        patientEntity.setLastName(patientTO.getLastName());
        patientEntity.setTelephoneNumber(patientTO.getTelephoneNumber());
        patientEntity.setEmail(patientTO.getEmail());
        patientEntity.setPatientNumber(patientTO.getPatientNumber());
        patientEntity.setDateOfBirth(patientTO.getDateOfBirth());
        patientEntity.setAddresses(patientTO.getAddresses().stream().map(AddressMapper::mapToEntity).collect(Collectors.toList()));
        patientEntity.setVisits(patientTO.getVisits() != null ? patientTO.getVisits().stream().map(VisitMapper::mapToEntity).collect(Collectors.toList()) : List.of());
        patientEntity.setCreatedAt(patientTO.getCreatedAt());
        return patientEntity;
    }
}
