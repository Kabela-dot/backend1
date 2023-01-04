package ipeps.pwd.wallet.dao;

import ipeps.pwd.wallet.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<Employee,Integer> {
    Employee findByLastname(String Lastname);
    Employee findByFirstname(String firstaname);
    Employee findByAddress(String address);
    Employee findByGender(String gender);
    Employee findByBirthday(String birthday);
    Employee findBySsin(String ssin);
    Employee findByStatus(String status);




}
