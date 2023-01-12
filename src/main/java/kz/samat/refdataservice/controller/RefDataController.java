package kz.samat.refdataservice.controller;

import kz.samat.refdataservice.model.RefDataEntity;
import kz.samat.refdataservice.model.RefDataType;
import kz.samat.refdataservice.service.RefDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static kz.samat.refdataservice.util.AppConstants.JSON_UTF_8;

/**
 * API endpoints for working with reference data
 * <p>
 * Created by Samat Abibulla 2022-11-15
 */
@RestController
@RequestMapping(value = "/api/v1/ref-data", produces = JSON_UTF_8)
@RequiredArgsConstructor
@Slf4j
public class RefDataController {

    private final RefDataService refDataService;

    /**
     * Endpoint to get list of all possible data types
     *
     * @return list of data types
     */
    @GetMapping("/data-types")
    public List<RefDataType> getDataTypes() {
        log.info("Incoming request to get reference data types");
        return List.of(RefDataType.values());
    }

    /**
     * Endpoint to get all reference data by data type
     *
     * @param dataType reference data type
     * @return list of reference data
     */
    @GetMapping("/by-data-type")
    public List<RefDataEntity> getRefDataByDataType(@RequestParam RefDataType dataType) {
        log.info("Incoming request to get reference data by data type, data-type={}", dataType.name());
        return refDataService.getRefDataByDataType(dataType);
    }
}
