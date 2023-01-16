package ipeps.pwd.wallet.dao;

import ipeps.pwd.wallet.models.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;

@Repository
public interface SalaryDao extends JpaRepository<Salary, Integer> {
    Salary findByTitle(String title);
    Salary findByAmount(Double amount);
    Salary findByComment(String comment);
    Salary findByCreate_date(Date create_date);

}
