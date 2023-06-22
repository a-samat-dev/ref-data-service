package kz.smarthealth.refdataservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Abstract class for all reference data entites
 *
 * Created by Samat Abibulla on 2023-06-20
 */
@Data
@RequiredArgsConstructor
@MappedSuperclass
public class AbstractEntity {

    @Id
    protected Integer id;

    @Column(name = "name_kz")
    private String nameKz;

    @Column(name = "name_en")
    private String nameEn;

    @Column(name = "name_ru")
    private String nameRu;

    @Column(name = "parent_id")
    private Integer parentId;
}
