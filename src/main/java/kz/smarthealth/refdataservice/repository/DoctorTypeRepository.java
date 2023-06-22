package kz.smarthealth.refdataservice.repository;

import kz.smarthealth.refdataservice.model.DoctorTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorTypeRepository extends JpaRepository<DoctorTypeEntity, Integer> {
}
