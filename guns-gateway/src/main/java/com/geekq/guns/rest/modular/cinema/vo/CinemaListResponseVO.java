package com.geekq.guns.rest.modular.cinema.vo;

import com.geekq.guns.api.cinema.vo.CinemaVO;
import lombok.Data;

import java.util.List;

@Data
public class CinemaListResponseVO {

    private List<CinemaVO> cinemas;

}
