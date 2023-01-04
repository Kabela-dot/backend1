package ipeps.pwd.wallet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponseDto {
    private Integer id;
    private String lastname;
    private String firstname;
    private String active;
    private String deleted_by;
    private String address;
    private String gender;
    private Date birthday;
    private String ssin;
    private String status;
    private String deleted;
}
