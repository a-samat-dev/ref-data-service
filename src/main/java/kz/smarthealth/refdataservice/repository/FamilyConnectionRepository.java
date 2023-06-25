package kz.smarthealth.refdataservice.repository;

import kz.smarthealth.refdataservice.model.FamilyConnectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyConnectionRepository extends JpaRepository<FamilyConnectionEntity, Integer> {
}
