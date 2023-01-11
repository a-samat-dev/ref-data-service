package kz.samat.refdataservice.service;

import kz.samat.refdataservice.exception.CustomException;
import kz.samat.refdataservice.model.RefDataEntity;
import kz.samat.refdataservice.model.RefDataType;
import kz.samat.refdataservice.repository.RefDataRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * Unit tests for {@link RefDataService}
 * <p>
 * Created by Samat Abibulla 2022-11-15
 */
@ExtendWith(MockitoExtension.class)
class RefDataServiceTest {

    @Mock
    private RefDataRepository refDataRepository;

    @InjectMocks
    private RefDataService underTest;

    @BeforeEach
    void beforeEach() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        underTest = new RefDataService(refDataRepository);
    }

    @Test
    void getRefDataByType_throwsError_whenInvalidDataTypeProvided() {
        // given
        String error = "Invalid Data Type";
        String message = "Invalid ref data type provided";

        // when
        CustomException exception = assertThrows(CustomException.class, () -> {
            underTest.getRefDataByDataType(null);
        });

        // then
        assertNotNull(exception);
        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatus());
        assertEquals(HttpStatus.BAD_REQUEST.name(), exception.getError());
        assertEquals(message, exception.getMessage());
    }

    @Test
    void getRefDataByType_returnsCities() {
        // given
        when(refDataRepository.findAllByDataType(RefDataType.CITY)).thenReturn(List.of(
                new RefDataEntity(1, "nameKz", "nameEn", "nameRu", RefDataType.CITY),
                new RefDataEntity(2, "nameKz", "nameEn", "nameRu", RefDataType.CITY)));

        // when
        List<RefDataEntity> cities = underTest.getRefDataByDataType(RefDataType.CITY);

        // then
        assertNotNull(cities);
        assertEquals(2, cities.size());
        assertEquals((short) 1, cities.get(0).getId());
        assertEquals("nameKz", cities.get(0).getNameKz());
        assertEquals("nameEn", cities.get(0).getNameEn());
        assertEquals("nameRu", cities.get(0).getNameRu());
        assertEquals(RefDataType.CITY, cities.get(0).getDataType());
        assertEquals((short) 2, cities.get(1).getId());
        assertEquals("nameKz", cities.get(1).getNameKz());
        assertEquals("nameEn", cities.get(1).getNameEn());
        assertEquals("nameRu", cities.get(1).getNameRu());
        assertEquals(RefDataType.CITY, cities.get(1).getDataType());
    }
}