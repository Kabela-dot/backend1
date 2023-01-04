package ipeps.pwd.wallet.controller;

import ipeps.pwd.wallet.dto.EmployeeRequestDto;
import ipeps.pwd.wallet.dto.EmployeeResponseDto;
import ipeps.pwd.wallet.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    //@RequestMapping("")
    //public List<EmployeeResponseDto> getEmployees(){
    //    return employeeService.findAll();

    //}
    @RequestMapping("")
    public ResponseEntity<List<EmployeeResponseDto>>getEmployees(){
       return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
     }
    @PostMapping("")
    public ResponseEntity<EmployeeResponseDto> save(@Valid  @RequestBody() EmployeeRequestDto employeeRequestDto){
        EmployeeResponseDto employeeResponseDto = employeeService.save(employeeRequestDto);
        return new ResponseEntity<>(employeeResponseDto, HttpStatus.CREATED);
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<EmployeeResponseDto> findById( @PathVariable("id") Integer id) {
        EmployeeResponseDto employeeResponseDto = employeeService.findById(id);
        return  ResponseEntity.ok(employeeResponseDto);
    }
    @GetMapping("/lastname/{lastname}")
    public ResponseEntity<EmployeeResponseDto> findByLastname( @PathVariable() String lastname) {
        EmployeeResponseDto employeeResponseDto = employeeService.findByLastname(lastname);
        return ResponseEntity.ok(employeeResponseDto);
    }
    @GetMapping("/firstname/{firstname}")
    public  ResponseEntity<EmployeeResponseDto> findByFirstname( @PathVariable() String firstname) {
        EmployeeResponseDto employeeResponseDto = employeeService.findByFirstname(firstname);
        return ResponseEntity.ok(employeeResponseDto);
    }
    @GetMapping("/address/{address}")
    public ResponseEntity<EmployeeResponseDto> findByAddress( @PathVariable() String address) {
        EmployeeResponseDto employeeResponseDto = employeeService.findByAddress(address);
        return ResponseEntity.ok(employeeResponseDto);
    }
    @GetMapping("/gender/{gender}")
    public ResponseEntity<EmployeeResponseDto> findByGender( @PathVariable() String gender) {
        EmployeeResponseDto employeeResponseDto = employeeService.findByGender(gender);
        return ResponseEntity.ok(employeeResponseDto);
    }
    @GetMapping("/birthday/{birthday}")
    public ResponseEntity<EmployeeResponseDto> findByBirthday(@PathVariable() Date birthday) {
        EmployeeResponseDto employeeResponseDto = employeeService.findByBirthday(String.valueOf(birthday));
        return ResponseEntity.ok(employeeResponseDto);

    }
    @GetMapping("/ssin/{ssin}")
    public ResponseEntity<EmployeeResponseDto> findBySsin( @PathVariable() String ssin) {
        EmployeeResponseDto employeeResponseDto = employeeService.findBySsin(ssin);
        return ResponseEntity.ok(employeeResponseDto);

    }
    @GetMapping("/status/{status}")
    public ResponseEntity<EmployeeResponseDto> findByStatus( @PathVariable() String status) {
        EmployeeResponseDto employeeResponseDto = employeeService.findByStatus(status);
        return ResponseEntity.ok(employeeResponseDto);
    }
    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> delete(@PathVariable() Integer id) {
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/id/{id}")
    public ResponseEntity<EmployeeResponseDto> update(@Valid
            @RequestBody() EmployeeRequestDto employeeRequestDto,@PathVariable() Integer id) {
        EmployeeResponseDto employeeResponseDto = employeeService.update(employeeRequestDto, id);
        return ResponseEntity.accepted().body(employeeResponseDto);
    }


}
