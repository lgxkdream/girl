package io.lgxkdream.girl.repository;

import io.lgxkdream.girl.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl, Integer> {

    /**
     *
     * @param age
     * @return
     */
    public List<Girl> findByAge(Integer age);

}
