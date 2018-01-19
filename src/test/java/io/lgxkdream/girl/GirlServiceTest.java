package io.lgxkdream.girl;

import io.lgxkdream.girl.domain.Girl;
import io.lgxkdream.girl.service.GirlService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void testGetAge() {
        girlService.getAge(1);
    }

}
