package ipeps.pwd.wallet.service;


import ipeps.pwd.wallet.dao.SalaryDao;
import ipeps.pwd.wallet.dto.SalaryRequestDto;
import ipeps.pwd.wallet.dto.SalaryResponseDto;
import ipeps.pwd.wallet.exception.EntityNotFoundException;
import ipeps.pwd.wallet.models.Salary;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SalaryServiceImpl implements SalaryService{
    private final ModelMapper modelMapper;
    private final SalaryDao salaryDao;

    public SalaryServiceImpl(ModelMapper modelMapper, SalaryDao salaryDao) {
        this.modelMapper = modelMapper;
        this.salaryDao = salaryDao;
    }

    @Override
    public SalaryResponseDto save(SalaryRequestDto salaryRequestDto) {
        Salary salary = modelMapper.map(salaryRequestDto,Salary.class);
        Salary saved = salaryDao.save(salary);
        return modelMapper.map(saved, SalaryResponseDto.class);


    }

    @Override
    public SalaryResponseDto findById(Integer id) {
        Salary salary=salaryDao.findById(id).orElseThrow(()
                ->new EntityNotFoundException("le salaire n'est pas trouvé"));
        return modelMapper.map(salary, SalaryResponseDto.class);


    }

    @Override
    public SalaryResponseDto findByCreate_date(Date create_date) {
        Salary salary = salaryDao.findByCreate_date(create_date);
        return modelMapper.map(salary, SalaryResponseDto.class);


    }

    @Override
    public SalaryResponseDto findByTitle(String title) {
        Salary salary = salaryDao.findByTitle(title);
        return modelMapper.map(salary, SalaryResponseDto.class);

    }

    @Override
    public SalaryResponseDto findByAmount(Double amount) {
        Salary salary = salaryDao.findByAmount(amount);
        return modelMapper.map(salary, SalaryResponseDto.class);
    }

    @Override
    public SalaryResponseDto findByComment(String comment) {
        Salary salary = salaryDao.findByComment(comment);
        return modelMapper.map(salary, SalaryResponseDto.class);
    }

    @Override
    public void delete(Integer id) {
        salaryDao.deleteById(id);


    }

    @Override
    public SalaryResponseDto update(SalaryRequestDto salaryRequestDto, Integer id) {
        Optional<Salary> salary = salaryDao.findById(id);
        if(salary.isPresent()){
            Salary salary1 = modelMapper.map(salary, Salary.class);
            salary1.setSalary_id(id);
            Salary updated = salaryDao.save(salary1);
            return modelMapper.map(updated, SalaryResponseDto.class);
        }
        else {
            throw new EntityNotFoundException("le salaire  n'est trouve.");
        }
    }

    @Override
    public List<SalaryResponseDto> findAll() {
        return  salaryDao.findAll()
                .stream().map(element->modelMapper.map(element, SalaryResponseDto.class))
                .collect(Collectors.toList());
    }
}
