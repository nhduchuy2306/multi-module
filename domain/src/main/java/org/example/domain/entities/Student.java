package org.example.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
@Where(clause = "is_deleted = false")
@AttributeOverride(name = "id", column = @Column(name = "student_id"))
@EqualsAndHashCode(callSuper = false)
public class Student extends BaseEntity implements Serializable {
    @Column(name = "student_name")
    private String name;

    @Column(name = "student_email")
    private String email;

    @Column(name = "student_password")
    private String password;

    @Column(name = "student_phone")
    private String phone;

    @Column(name = "student_address")
    private String address;
}
