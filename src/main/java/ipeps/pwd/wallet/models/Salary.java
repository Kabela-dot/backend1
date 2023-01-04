package ipeps.pwd.wallet.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Table(name = "Salary")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString

public class Salary implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer salary_id;
    @Column(nullable = false)
    private Date create_date;
    private String title;
    private String comment;
    @Column(nullable = false)
    private BigDecimal amount;
    @OneToMany(mappedBy = "salary", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Employee>employees;
}
