package ipeps.pwd.wallet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class SalaryRequestDto {
    private Integer salary_id;
    private Date create_date;
    @NotNull(message = "le titre est obligatoire")
    @Size(min=5, max = 50, message = "le titre doit être compris entre 5 et 50 caractères")
    @NotBlank
    private String title;
    private String comment;
    private Double amount;
}
