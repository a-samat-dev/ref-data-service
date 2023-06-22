package kz.smarthealth.refdataservice.controller;

import kz.smarthealth.refdataservice.model.AbstractEntity;
import kz.smarthealth.refdataservice.model.DataType;
import kz.smarthealth.refdataservice.service.RefDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ref-data")
@RequiredArgsConstructor
public class RefDataController {

    private final RefDataService refDataService;

    @GetMapping("/by-data-type")
    public List<? extends AbstractEntity> getRefDataByRefDataType(@RequestParam DataType dataType) {
        return refDataService.getRefDataByRefDataType(dataType);
    }
}
