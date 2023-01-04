package ipeps.pwd.wallet.service;

import ipeps.pwd.wallet.dao.EmployeeDao;
import ipeps.pwd.wallet.dto.EmployeeRequestDto;
import ipeps.pwd.wallet.dto.EmployeeResponseDto;
import ipeps.pwd.wallet.exception.EntityNotFoundException;
import ipeps.pwd.wallet.models.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final ModelMapper modelMapper;
    private final EmployeeDao employeeDao;

    public EmployeeServiceImpl( ModelMapper modelMapper,
                               EmployeeDao employeeDao) {

        this.modelMapper = modelMapper;
        this.employeeDao = employeeDao;
    }

    @Override
    public EmployeeResponseDto save(EmployeeRequestDto employeeRequestDto) {
        Employee employee = modelMapper.map(employeeRequestDto, Employee.class);
        Employee employed = employeeDao.save(employee);
        return modelMapper.map( employed, EmployeeResponseDto.class);

    }

    @Override
    public EmployeeResponseDto findById(Integer id) {
        Employee employee = employeeDao.findById(id).orElseThrow(()
                ->new EntityNotFoundException("l'employe n'est pas trouvé"));
        return modelMapper.map(employee, EmployeeResponseDto.class);
    }

    @Override
    public EmployeeResponseDto findByLastname(String lastname) {
        Employee employee = employeeDao.findByLastname(lastname);
        return modelMapper.map(employee, EmployeeResponseDto.class);
    }

    @Override
    public EmployeeResponseDto findByFirstname(String firstname) {

       Employee employee = employeeDao.findByFirstname(firstname);
        return modelMapper.map(employee, EmployeeResponseDto.class);
    }

    @Override
    public EmployeeResponseDto findByAddress(String address) {

        Employee employee = employeeDao.findByAddress(address);
        return modelMapper.map(employee, EmployeeResponseDto.class);
    }

    @Override
    public EmployeeResponseDto findByGender(String gender) {

        Employee employee = employeeDao.findByGender(gender);
        return modelMapper.map(employee, EmployeeResponseDto.class);
    }

    @Override
    public EmployeeResponseDto findByBirthday(String birthday) {

        Employee employee = employeeDao.findByBirthday(String.valueOf(birthday));
        return modelMapper.map(employee, EmployeeResponseDto.class);
    }

    @Override
    public EmployeeResponseDto findBySsin(String ssin) {

        Employee employee = employeeDao.findBySsin(ssin);
        return modelMapper.map(employee, EmployeeResponseDto.class);
    }

    @Override
    public EmployeeResponseDto findByStatus(String status) {

        Employee employee = employeeDao.findByStatus(status);
        return modelMapper.map(employee, EmployeeResponseDto.class);
    }

    @Override
    public void delete(Integer id) {
        employeeDao.deleteById(id);

    }

    @Override
    public EmployeeResponseDto update(EmployeeRequestDto employeeRequestDto, Integer id) {
        Optional<Employee> employee = employeeDao.findById(id);
        if(employee.isPresent()){
            Employee employee1 = modelMapper.map(employee, Employee.class);
            employee1.setEmployee_id(id);
            Employee updated = employeeDao.save(employee1);
            return modelMapper.map(updated, EmployeeResponseDto.class);
        }
        else {
            throw new EntityNotFoundException("l'employe n'est trouve.");
        }
    }

    @Override
    public List<EmployeeResponseDto> findAll() {
        return  employeeDao.findAll()
                .stream().map(element->modelMapper.map(element, EmployeeResponseDto.class))
                .collect(Collectors.toList());
    }
}
