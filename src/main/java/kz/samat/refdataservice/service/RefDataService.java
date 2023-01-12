package kz.samat.refdataservice.service;

import kz.samat.refdataservice.exception.CustomException;
import kz.samat.refdataservice.model.RefDataEntity;
import kz.samat.refdataservice.model.RefDataType;
import kz.samat.refdataservice.model.redis.RefDataCache;
import kz.samat.refdataservice.repository.RefDataRepository;
import kz.samat.refdataservice.repository.redis.RefDataCacheRepository;
import kz.samat.refdataservice.util.MessageSource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * Service class for working with reference data
 * <p>
 * Created by Samat Abibulla 2022-11-15
 */
@Service
@RequiredArgsConstructor
public class RefDataService {

    private final RefDataRepository refDataRepository;
    private final RefDataCacheRepository refDataCacheRepository;

    /**
     * Gets reference data by data type
     *
     * @param dataType reference data type
     * @return list of reference data
     */
    public List<RefDataEntity> getRefDataByDataType(RefDataType dataType) {
        if (dataType != null) {
            Optional<RefDataCache> optionalRefData = refDataCacheRepository.findById(dataType);

            if (optionalRefData.isPresent()) {
                return optionalRefData.get().getRefDataList();
            }

            List<RefDataEntity> refDataEntityList = refDataRepository.findAllByDataType(dataType);

            refDataCacheRepository.save(RefDataCache.builder()
                    .dataType(dataType)
                    .refDataList(refDataEntityList)
                    .build());

            return refDataEntityList;
        }

        throw CustomException.builder()
                .status(HttpStatus.BAD_REQUEST)
                .error(HttpStatus.BAD_REQUEST.name())
                .message(MessageSource.INVALID_REF_DATA_TYPE_PROVIDED.getText())
                .build();
    }
}
