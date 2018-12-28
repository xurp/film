package com.geekq.guns.rest.modular.cinema.vo;

import com.geekq.guns.api.cinema.vo.CinemaInfoVO;
import com.geekq.guns.api.cinema.vo.FilmInfoVO;
import com.geekq.guns.api.cinema.vo.HallInfoVO;
import lombok.Data;

@Data
public class CinemaFieldResponseVO {

    private CinemaInfoVO cinemaInfo;
    private FilmInfoVO filmInfo;
    private HallInfoVO hallInfo;

}
