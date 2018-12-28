package com.geekq.guns.rest.modular.cinema.vo;

import com.geekq.guns.api.cinema.vo.CinemaInfoVO;
import com.geekq.guns.api.cinema.vo.FilmInfoVO;
import lombok.Data;

import java.util.List;

@Data
public class CinemaFieldsResponseVO {

    private CinemaInfoVO cinemaInfo;
    private List<FilmInfoVO> filmList;

}
