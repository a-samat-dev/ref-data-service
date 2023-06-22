package kz.smarthealth.refdataservice.service;

import kz.smarthealth.refdataservice.model.AbstractEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link RefDataService}
 *
 * Created by Samat Abibulla on 2023-06-21
 */
@ExtendWith(MockitoExtension.class)
class RefDataServiceTest {

    @InjectMocks
    private RefDataService underTest;

    @Test
    void getRefDataByRefDataType_returnsEmptyList_whenInvalidDataType() {
        // when
        List<? extends AbstractEntity> refDataList = underTest.getRefDataByRefDataType(null);
        // then
        assertTrue(refDataList.isEmpty());
    }
}