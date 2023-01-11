package kz.samat.refdataservice.repository;

import kz.samat.refdataservice.model.RefDataEntity;
import kz.samat.refdataservice.model.RefDataType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for {@link RefDataEntity}
 *
 * Created by Samat Abibulla on 2023-01-11
 */
@Repository
public interface RefDataRepository extends JpaRepository<RefDataEntity, Integer> {

    List<RefDataEntity> findAllByDataType(RefDataType dataType);
}
