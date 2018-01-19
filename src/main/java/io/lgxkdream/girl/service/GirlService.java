package io.lgxkdream.girl.service;

import io.lgxkdream.girl.domain.Girl;
import io.lgxkdream.girl.enums.ResultEnum;
import io.lgxkdream.girl.exception.GirlException;
import io.lgxkdream.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo() {
        Girl girl1 = new Girl();
        girl1.setAge(18);
        girl1.setCupSize("A");
        girlRepository.save(girl1);
        Girl girl2 = new Girl();
        girl2.setAge(19);
        girl2.setCupSize("B");
        girlRepository.save(girl2);
    }

    public void getAge(Integer id) {
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if (age < 10) {
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        } else if (age >= 10 && age < 16) {
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

}
