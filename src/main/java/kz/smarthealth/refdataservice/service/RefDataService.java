package kz.smarthealth.refdataservice.service;

import kz.smarthealth.refdataservice.model.AbstractEntity;
import kz.smarthealth.refdataservice.model.DataType;
import kz.smarthealth.refdataservice.repository.CityRepository;
import kz.smarthealth.refdataservice.repository.DoctorTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RefDataService {

    private final CityRepository cityRepository;
    private final DoctorTypeRepository doctorTypeRepository;

    public List<? extends AbstractEntity> getRefDataByRefDataType(DataType dataType) {
        if (dataType == DataType.CITY) {
            return cityRepository.findAll();
        } else if (dataType == DataType.DOCTOR_TYPE) {
            return doctorTypeRepository.findAll();
        }

        return Collections.emptyList();
    }
}
