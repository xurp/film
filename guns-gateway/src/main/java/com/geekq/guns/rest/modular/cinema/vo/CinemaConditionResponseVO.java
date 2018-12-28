package com.geekq.guns.rest.modular.cinema.vo;

import com.geekq.guns.api.cinema.vo.AreaVO;
import com.geekq.guns.api.cinema.vo.BrandVO;
import com.geekq.guns.api.cinema.vo.HallTypeVO;
import lombok.Data;

import java.util.List;

@Data
public class CinemaConditionResponseVO {

    private List<BrandVO> brandList;
    private List<AreaVO> areaList;
    private List<HallTypeVO> halltypeList;

}
