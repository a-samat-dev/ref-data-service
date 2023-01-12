package kz.samat.refdataservice.repository.redis;

import kz.samat.refdataservice.model.RefDataType;
import kz.samat.refdataservice.model.redis.RefDataCache;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefDataCacheRepository extends CrudRepository<RefDataCache, RefDataType> {
}
