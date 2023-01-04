package ipeps.pwd.wallet.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "Employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Employee implements Serializable {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer employee_id;
    @Column(nullable = false)
    private String lastname;
    @Column(nullable = false)
    private String firstname;
    private String active;
    private String deleted_by;
    @Column(nullable = false)
    private String address;
    private String gender;
    private Date birthday;
    private String ssin;
    private String status;
    private String deleted;
    @ManyToOne()
    @JoinColumn(name = "salary_id")
    private Salary salary;
}



