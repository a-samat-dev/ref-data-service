package kz.smarthealth.refdataservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.RequiredArgsConstructor;

/**
 * Entity class that represents all cities in the system
 *
 * Created by Samat Abibulla on 2023-06-20
 */
@Entity
@Table(name = "cities")
@RequiredArgsConstructor
public class CityEntity extends AbstractEntity {
}
