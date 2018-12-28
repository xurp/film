package com.geekq.guns.fastjson;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.geekq.guns.rest.FilmApplication;
import com.geekq.guns.rest.modular.film.serivce.DefaultFilmServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FilmApplication.class)
public class UnitTest {

    @Autowired
    private DefaultFilmServiceImpl moocFilmTMapper;

    @Test
    public void test(){

        moocFilmTMapper.getHotFilms(false,10,1,1,99,99,99);

    }


}
