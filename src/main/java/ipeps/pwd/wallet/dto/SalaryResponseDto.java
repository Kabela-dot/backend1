package ipeps.pwd.wallet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SalaryResponseDto {
    private Integer salary_id;
    private Date create_date;
    private String title;
    private String comment;
    private BigDecimal amount;

}
