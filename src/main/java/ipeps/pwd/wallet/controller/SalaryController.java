package ipeps.pwd.wallet.controller;


import ipeps.pwd.wallet.dto.EmployeeRequestDto;
import ipeps.pwd.wallet.dto.EmployeeResponseDto;
import ipeps.pwd.wallet.dto.SalaryRequestDto;
import ipeps.pwd.wallet.dto.SalaryResponseDto;
import ipeps.pwd.wallet.service.SalaryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping
public class SalaryController {

    private final SalaryService salaryService;

    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }
    @RequestMapping("")
    public List<SalaryResponseDto> getSalaries(){
        return salaryService.findAll();

    }

    @PostMapping("")
    public ResponseEntity<SalaryResponseDto> save(@Valid @RequestBody() SalaryRequestDto salaryRequestDto){
        SalaryResponseDto salaryResponseDto = salaryService.save(salaryRequestDto);
        return new ResponseEntity<>(salaryResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<SalaryResponseDto> findById(@PathVariable("id") Integer id) {
        SalaryResponseDto salaryResponseDto = salaryService.findById(id);
        return ResponseEntity.ok(salaryResponseDto);
    }

    @GetMapping("/create_date/{create_date}")
    public ResponseEntity<SalaryResponseDto> findByCreate_date(@PathVariable() Date create_date) {
        SalaryResponseDto salaryResponseDto = salaryService.findByCreate_date(create_date);
        return ResponseEntity.ok(salaryResponseDto);
    }
    @GetMapping("/title/{title}")
    public ResponseEntity<SalaryResponseDto> findByTitle(@PathVariable() String title) {
        SalaryResponseDto salaryResponseDto = salaryService.findByTitle(title);
        return ResponseEntity.ok(salaryResponseDto);
    }
    @GetMapping("/amount/{amount}")
    public ResponseEntity<SalaryResponseDto> findByAmount(@PathVariable() BigDecimal amount) {
        SalaryResponseDto salaryResponseDto = salaryService.findByAmount(amount);
        return ResponseEntity.ok(salaryResponseDto);
    }
    @GetMapping("/comment/{comment}")
    public ResponseEntity<SalaryResponseDto> findByComment(@PathVariable() String comment) {
        SalaryResponseDto salaryResponseDto = salaryService.findByComment(comment);
        return ResponseEntity.ok(salaryResponseDto);
    }
    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> delete(@PathVariable() Integer id) {

        salaryService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/id/{id}")
    public ResponseEntity<SalaryResponseDto>
    update(@Valid @RequestBody() SalaryRequestDto salaryRequestDto, @PathVariable()   Integer id) {
        SalaryResponseDto salaryResponseDto = salaryService.update(salaryRequestDto, id);
                return ResponseEntity.accepted().body(salaryResponseDto);
    }


}
