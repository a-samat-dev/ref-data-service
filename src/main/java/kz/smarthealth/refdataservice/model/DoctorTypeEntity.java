package kz.smarthealth.refdataservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.RequiredArgsConstructor;

/**
 * Entity class that represents all doctor types in the system
 *
 * Created by Samat Abibulla on 2023-06-20
 */
@Entity
@Table(name = "doctor_types")
@RequiredArgsConstructor
public class DoctorTypeEntity extends AbstractEntity {
}
