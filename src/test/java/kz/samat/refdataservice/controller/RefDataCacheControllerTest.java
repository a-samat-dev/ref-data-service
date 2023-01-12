package kz.samat.refdataservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import kz.samat.refdataservice.model.RefDataEntity;
import kz.samat.refdataservice.model.RefDataType;
import kz.samat.refdataservice.model.redis.RefDataCache;
import kz.samat.refdataservice.repository.RefDataRepository;
import kz.samat.refdataservice.repository.redis.RefDataCacheRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.redis.AutoConfigureDataRedis;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Integration tests for {@link RefDataController}
 * <p>
 * Created by Samat Abibulla 2022-11-15
 */
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureDataRedis
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.yml")
class RefDataCacheControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RefDataRepository refDataRepository;

    @Autowired
    private RefDataCacheRepository refDataCacheRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void getDataTypes_returnsDataTypes() throws Exception {
        // given
        List<RefDataType> refDataTypes = List.of(RefDataType.values());
        // when
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/ref-data/data-types"))
                .andExpect(status().isOk())
                .andReturn();
        // then
        List<String> result = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), List.class);

        assertNotNull(result);
        assertEquals(refDataTypes.size(), result.size());

        for (int i = 0; i < refDataTypes.size(); i++) {
            assertEquals(refDataTypes.get(i).name(), result.get(i));
        }
    }

    @Test
    void getRefDataByType_returnsErrorResponse() throws Exception {
        // when
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/ref-data/by-data-type?dataType=INVALID"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getRefDataByDataType_returnsCities_fromCache() throws Exception {
        // given
        List<RefDataEntity> expectedRefData = refDataRepository.findAllByDataType(RefDataType.CITY);
        refDataCacheRepository.save(RefDataCache.builder()
                .dataType(RefDataType.CITY)
                .refDataList(expectedRefData)
                .build());
        // when
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(
                        "/api/v1/ref-data/by-data-type?dataType=CITY"))
                .andExpect(status().isOk())
                .andReturn();
        // then
        List<RefDataEntity> actualRefData = List.of(objectMapper.readValue(
                mvcResult.getResponse().getContentAsString(UTF_8), RefDataEntity[].class));

        assertNotNull(actualRefData);
        assertEquals(expectedRefData.size(), actualRefData.size());

        for (int i = 0; i < expectedRefData.size(); i++) {
            assertEquals(expectedRefData.get(i).getId(), actualRefData.get(i).getId());
            assertEquals(expectedRefData.get(i).getNameKz(), actualRefData.get(i).getNameKz());
            assertEquals(expectedRefData.get(i).getNameEn(), actualRefData.get(i).getNameEn());
            assertEquals(expectedRefData.get(i).getNameRu(), actualRefData.get(i).getNameRu());
            assertEquals(RefDataType.CITY, actualRefData.get(0).getDataType());
        }

        refDataCacheRepository.deleteAll();
    }

    @Test
    void getRefDataByDataType_returnsCities() throws Exception {
        // given
        List<RefDataEntity> expectedRefData = refDataRepository.findAllByDataType(RefDataType.CITY);
        // when
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(
                        "/api/v1/ref-data/by-data-type?dataType=CITY"))
                .andExpect(status().isOk())
                .andReturn();
        // then
        List<RefDataEntity> actualRefData = List.of(objectMapper.readValue(
                mvcResult.getResponse().getContentAsString(UTF_8), RefDataEntity[].class));

        assertNotNull(actualRefData);
        assertEquals(expectedRefData.size(), actualRefData.size());

        for (int i = 0; i < expectedRefData.size(); i++) {
            assertEquals(expectedRefData.get(i).getId(), actualRefData.get(i).getId());
            assertEquals(expectedRefData.get(i).getNameKz(), actualRefData.get(i).getNameKz());
            assertEquals(expectedRefData.get(i).getNameEn(), actualRefData.get(i).getNameEn());
            assertEquals(expectedRefData.get(i).getNameRu(), actualRefData.get(i).getNameRu());
            assertEquals(RefDataType.CITY, actualRefData.get(0).getDataType());
        }

        refDataCacheRepository.deleteAll();
    }
}