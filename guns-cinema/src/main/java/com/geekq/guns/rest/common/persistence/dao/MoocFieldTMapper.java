package com.geekq.guns.rest.common.persistence.dao;

import com.geekq.guns.rest.common.persistence.model.MoocFieldT;
import com.geekq.guns.api.cinema.vo.FilmFieldVO;
import com.geekq.guns.api.cinema.vo.FilmInfoVO;
import com.geekq.guns.api.cinema.vo.HallInfoVO;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 放映场次表 Mapper 接口
 * </p>
 *
 * @author jiangzh
 * @since 2018-09-15
 */
public interface MoocFieldTMapper extends BaseMapper<MoocFieldT> {

    List<FilmInfoVO> getFilmInfos(@Param("cinemaId") int cinemaId);

    HallInfoVO getHallInfo(@Param("fieldId") int fieldId);

    FilmInfoVO getFilmInfoById(@Param("fieldId") int fieldId);

}
