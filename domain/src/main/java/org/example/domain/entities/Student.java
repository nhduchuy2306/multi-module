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
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
@Where(clause = "is_deleted = false")
@EqualsAndHashCode(callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "student_id"))
public class Student extends BaseEntity {
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

    public Student(UUID id, String name, String email, String password, String phone, String address) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }
}
