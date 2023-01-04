package ipeps.pwd.wallet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequestDto{

    private Integer id;
    @NotNull(message = "le nom est obligatoire")
    @Size(min=5, max = 50, message = "le nom doit être compris entre 5 et 50 caractères")
    @NotBlank
    private String lastname;
    @NotNull(message = "le nom est obligatoire")
    @Size(min=5, max = 50, message = "le nom doit être compris entre 5 et 50 caractères" )
    @NotBlank
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
