package kz.smarthealth.refdataservice.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import kz.smarthealth.refdataservice.model.AbstractEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Integration tests for {@link RefDataController}
 *
 * Created by Samat Abibulla on 2023-06-20
 */
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.yml")
class RefDataControllerTest {

    private static final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getRefDataByRefDataType_returnsBadRequest_whenInvalidDataType() throws Exception {
        // when
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/ref-data/by-data-type?dataType=INVALID_DATA_TYPE")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8"))
                .andExpect(status().isBadRequest()).andReturn();
    }

    @Test
    void getRefDataByRefDataType_returnsCities() throws Exception {
        // when
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/ref-data/by-data-type?dataType=CITY")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8"))
                .andExpect(status().isOk()).andReturn();
        // then
        List<AbstractEntity> cities = objectMapper.readValue(mvcResult.getResponse().getContentAsString(),
                new TypeReference<>() {
                });

        assertFalse(cities.isEmpty());
        assertEquals(2, cities.size());
        assertNotNull(cities.get(0).getId());
        assertNotNull(cities.get(0).getNameKz());
        assertNotNull(cities.get(0).getNameEn());
        assertNotNull(cities.get(0).getNameRu());
        assertNull(cities.get(0).getParentId());
    }

    @Test
    void getRefDataByRefDataType_returnsDoctorTypes() throws Exception {
        // when
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/ref-data/by-data-type?dataType=DOCTOR_TYPE")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8"))
                .andExpect(status().isOk()).andReturn();
        // then
        List<AbstractEntity> doctorTypes = objectMapper.readValue(mvcResult.getResponse().getContentAsString(),
                new TypeReference<>() {
                });

        assertFalse(doctorTypes.isEmpty());
        assertEquals(2, doctorTypes.size());
        assertNotNull(doctorTypes.get(0).getId());
        assertNotNull(doctorTypes.get(0).getNameKz());
        assertNotNull(doctorTypes.get(0).getNameEn());
        assertNotNull(doctorTypes.get(0).getNameRu());
        assertNull(doctorTypes.get(0).getParentId());
    }

    @Test
    void getRefDataByRefDataType_returnsFamilyConnections() throws Exception {
        // when
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/ref-data/by-data-type?dataType=FAMILY_CONNECTION")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8"))
                .andExpect(status().isOk()).andReturn();
        // then
        List<AbstractEntity> familyConnections = objectMapper.readValue(mvcResult.getResponse().getContentAsString(),
                new TypeReference<>() {
                });

        assertFalse(familyConnections.isEmpty());
        assertEquals(2, familyConnections.size());
        assertNotNull(familyConnections.get(0).getId());
        assertNotNull(familyConnections.get(0).getNameKz());
        assertNotNull(familyConnections.get(0).getNameEn());
        assertNotNull(familyConnections.get(0).getNameRu());
        assertNull(familyConnections.get(0).getParentId());
    }
}