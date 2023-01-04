package ipeps.pwd.wallet.service;

import ipeps.pwd.wallet.dto.EmployeeRequestDto;
import ipeps.pwd.wallet.dto.EmployeeResponseDto;

import java.util.List;

public interface EmployeeService {
    EmployeeResponseDto save(EmployeeRequestDto employeeRequestDto);
    EmployeeResponseDto findById(Integer id);
    EmployeeResponseDto findByLastname(String lastname);
    EmployeeResponseDto findByFirstname(String firstname);
    EmployeeResponseDto findByAddress(String address);
    EmployeeResponseDto findByGender(String gender);
    EmployeeResponseDto findByBirthday(String birthday);
    EmployeeResponseDto findBySsin(String ssin);
    EmployeeResponseDto findByStatus(String status);
    void  delete(Integer id);
    EmployeeResponseDto update(EmployeeRequestDto employeeRequestDto, Integer id);
    List<EmployeeResponseDto> findAll();
}
