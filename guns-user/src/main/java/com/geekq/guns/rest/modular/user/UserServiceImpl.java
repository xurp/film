package com.geekq.guns.rest.modular.user;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.geekq.guns.rest.common.persistence.dao.CmUserTMapper;
import com.geekq.guns.api.user.UserAPI;
import com.geekq.guns.api.user.vo.UserInfoModel;
import com.geekq.guns.api.user.vo.UserModel;
import com.geekq.guns.core.util.MD5Util;
import com.geekq.guns.rest.common.persistence.model.CmUserT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Service(interfaceClass = UserAPI.class,loadbalance = "roundrobin" )
public class UserServiceImpl implements UserAPI{

    @Autowired
    private CmUserTMapper CmUserTMapper;

    @Override
    public boolean register(UserModel userModel) {
        // 将注册信息实体转换为数据实体[Cm_user_t]
        CmUserT CmUserT = new CmUserT();
        CmUserT.setUserName(userModel.getUsername());
        CmUserT.setEmail(userModel.getEmail());
        CmUserT.setAddress(userModel.getAddress());
        CmUserT.setUserPhone(userModel.getPhone());
        // 创建时间和修改时间 -> current_timestamp

        // 数据加密 【MD5混淆加密 + 盐值 -> Shiro加密】
        String md5Password = MD5Util.encrypt(userModel.getPassword());
        CmUserT.setUserPwd(md5Password); // 注意

        // 将数据实体存入数据库
        Integer insert = CmUserTMapper.insert(CmUserT);
        if(insert>0){
            return true;
        }else{
            return false;
        }
    }


    @Override
    public int login(String username, String password) {
        // 根据登陆账号获取数据库信息
        CmUserT CmUserT = new CmUserT();
        CmUserT.setUserName(username);

        CmUserT result = CmUserTMapper.selectOne(CmUserT);

        // 获取到的结果，然后与加密以后的密码做匹配
        if(result!=null && result.getUuid()>0){
            String md5Password = MD5Util.encrypt(password);
            if(result.getUserPwd().equals(md5Password)){
                return result.getUuid();
            }
        }
        return 0;
    }

    @Override
    public boolean checkUsername(String username) {
        EntityWrapper<CmUserT> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("user_name",username);
        Integer result = CmUserTMapper.selectCount(entityWrapper);
        if(result!=null && result>0){
            return false;
        }else{
            return true;
        }
    }

    private UserInfoModel do2UserInfo(CmUserT CmUserT){
        UserInfoModel userInfoModel = new UserInfoModel();

        userInfoModel.setUuid(CmUserT.getUuid());
        userInfoModel.setHeadAddress(CmUserT.getHeadUrl());
        userInfoModel.setPhone(CmUserT.getUserPhone());
        userInfoModel.setUpdateTime(CmUserT.getUpdateTime().getTime());
        userInfoModel.setEmail(CmUserT.getEmail());
        userInfoModel.setUsername(CmUserT.getUserName());
        userInfoModel.setNickname(CmUserT.getNickName());
        userInfoModel.setLifeState(""+CmUserT.getLifeState());
        userInfoModel.setBirthday(CmUserT.getBirthday());
        userInfoModel.setAddress(CmUserT.getAddress());
        userInfoModel.setSex(CmUserT.getUserSex());
        userInfoModel.setBeginTime(CmUserT.getBeginTime().getTime());
        userInfoModel.setBiography(CmUserT.getBiography());

        return userInfoModel;
    }

    @Override
    public UserInfoModel getUserInfo(int uuid) {
        // 根据主键查询用户信息 [CmUserT]
        CmUserT CmUserT = CmUserTMapper.selectById(uuid);
        // 将CmUserT转换UserInfoModel
        UserInfoModel userInfoModel = do2UserInfo(CmUserT);
        // 返回UserInfoModel
        return userInfoModel;
    }

    @Override
    public UserInfoModel updateUserInfo(UserInfoModel userInfoModel) {
        // 将传入的参数转换为DO 【CmUserT】
        CmUserT CmUserT = new CmUserT();
        CmUserT.setUuid(userInfoModel.getUuid());
        CmUserT.setNickName(userInfoModel.getNickname());
        CmUserT.setLifeState(Integer.parseInt(userInfoModel.getLifeState()));
        CmUserT.setBirthday(userInfoModel.getBirthday());
        CmUserT.setBiography(userInfoModel.getBiography());
        CmUserT.setBeginTime(null);
        CmUserT.setHeadUrl(userInfoModel.getHeadAddress());
        CmUserT.setEmail(userInfoModel.getEmail());
        CmUserT.setAddress(userInfoModel.getAddress());
        CmUserT.setUserPhone(userInfoModel.getPhone());
        CmUserT.setUserSex(userInfoModel.getSex());
        CmUserT.setUpdateTime(null);

        // DO存入数据库
        Integer integer = CmUserTMapper.updateById(CmUserT);
        if(integer>0){
            // 将数据从数据库中读取出来
            UserInfoModel userInfo = getUserInfo(CmUserT.getUuid());
            // 将结果返回给前端
            return userInfo;
        }else{
            return null;
        }
    }


}
