package com.geekq.guns.rest.common.persistence.dao;

import com.geekq.guns.rest.common.persistence.model.MoocFilmT;
import com.geekq.guns.api.film.vo.FilmDetailVO;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 影片主表 Mapper 接口
 * </p>
 *
 * @author jiangzh
 * @since 2018-08-26
 */
public interface MoocFilmTMapper extends BaseMapper<MoocFilmT> {

    FilmDetailVO getFilmDetailByName(@Param("filmName") String filmName);

    FilmDetailVO getFilmDetailById(@Param("uuid") String uuid);

}
