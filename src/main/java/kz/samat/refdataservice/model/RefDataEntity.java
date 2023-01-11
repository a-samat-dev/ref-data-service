package kz.samat.refdataservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Reference data
 * <p>
 * Created by Samat Abibulla on 2023-01-11
 */
@EqualsAndHashCode
@Data
@NoArgsConstructor
@Entity
@Table(name = "ref_data")
@AllArgsConstructor
public class RefDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_kz", nullable = false)
    private String nameKz;

    @Column(name = "name_en", nullable = false)
    private String nameEn;

    @Column(name = "name_ru", nullable = false)
    private String nameRu;

    @Column(name = "data_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private RefDataType dataType;
}
