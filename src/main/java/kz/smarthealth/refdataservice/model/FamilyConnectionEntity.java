package kz.smarthealth.refdataservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.RequiredArgsConstructor;

/**
 * Entity class that represents all family connections in the system
 *
 * Created by Samat Abibulla on 2023-06-25
 */
@Entity
@Table(name = "family_connections")
@RequiredArgsConstructor
public class FamilyConnectionEntity extends AbstractEntity {
}
