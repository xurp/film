package com.geekq.guns.rest.modular.film.vo;

import com.geekq.guns.api.film.vo.CatVO;
import com.geekq.guns.api.film.vo.SourceVO;
import com.geekq.guns.api.film.vo.YearVO;
import lombok.Data;

import java.util.List;

@Data
public class FilmConditionVO {

    private List<CatVO> catInfo;
    private List<SourceVO> sourceInfo;
    private List<YearVO> yearInfo;

}
