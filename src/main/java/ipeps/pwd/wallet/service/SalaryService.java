package ipeps.pwd.wallet.service;

import ipeps.pwd.wallet.dto.SalaryRequestDto;
import ipeps.pwd.wallet.dto.SalaryResponseDto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface SalaryService {
    SalaryResponseDto save(SalaryRequestDto salaryRequestDto);
    SalaryResponseDto findById(Integer id);
    SalaryResponseDto findByCreate_date(Date date);
    SalaryResponseDto findByTitle(String title);
    SalaryResponseDto findByAmount(BigDecimal amount);
    SalaryResponseDto findByComment(String comment);
    void delete(Integer id);
    SalaryResponseDto update(SalaryRequestDto salaryRequestDto, Integer id);
    List<SalaryResponseDto>findAll();
}
