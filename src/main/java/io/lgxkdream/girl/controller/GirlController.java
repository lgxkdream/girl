package io.lgxkdream.girl.controller;

import io.lgxkdream.girl.domain.Girl;
import io.lgxkdream.girl.domain.Result;
import io.lgxkdream.girl.repository.GirlRepository;
import io.lgxkdream.girl.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 查询所有
     *
     * @return
     */
    @GetMapping("/girls")
    public List<Girl> girlList() {
        return girlRepository.findAll();
    }

    /**
     * 添加
     *
     * @return
     */
    @PostMapping("/girls")
    public Result<Girl> addGirl(@Valid Girl girl, BindingResult bindingResult) {
        Result<Girl> result = new Result<>();
        if (bindingResult.hasErrors()) {
            result.setCode(500);
            result.setMsg(bindingResult.getFieldError().getDefaultMessage());
            result.setData(null);
            return result;
        }
        result.setCode(200);
        result.setMsg("响应成功");
        result.setData(girlRepository.save(girl));
        return result;
    }

    /**
     * 单个查询
     *
     * @param id
     * @return
     */
    @GetMapping("/girls/{id}")
    public Girl getGirl(@PathVariable("id") Integer id) {
        return girlRepository.findOne(id);
    }

    /**
     * 更新
     *
     * @param id
     * @param cupSize
     * @param age
     * @return
     */
    @PutMapping("/girls/{id}")
    public Girl updateGirl(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    /**
     * 删除
     *
     * @param id
     */
    @DeleteMapping("/girl/{id}")
    public void deleteGirl(@PathVariable("id") Integer id) {
        girlRepository.delete(id);
    }

    /**
     * 根据年龄查询
     *
     * @param age
     * @return
     */
    @GetMapping("/girl/age/{age}")
    public List<Girl> findByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    @PostMapping("/girls/two")
    public void insertTwo() {
        girlService.insertTwo();
    }

    @GetMapping("/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) {
        girlService.getAge(id);
    }

}
