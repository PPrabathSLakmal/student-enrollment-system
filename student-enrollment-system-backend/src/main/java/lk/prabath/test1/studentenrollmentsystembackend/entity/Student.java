package lk.prabath.test1.studentenrollmentsystembackend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "student")
public class Student implements SupperEntity{
    @Id
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String nic;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String contact;
    @ManyToOne
    @JoinColumn(name = "course_id",referencedColumnName = "id")
    private Course course;

    public Student(int id, String name, String nic, String address, String contact) {
        this.id = id;
        this.name = name;
        this.nic = nic;
        this.address = address;
        this.contact = contact;
    }
}
