package com.geekq.guns.api.user;

import com.geekq.guns.api.user.vo.UserInfoModel;
import com.geekq.guns.api.user.vo.UserModel;

public interface UserAPI {

    int login(String username, String password);

    boolean register(UserModel userModel);

    boolean checkUsername(String username);

    UserInfoModel getUserInfo(int uuid);

    UserInfoModel updateUserInfo(UserInfoModel userInfoModel);

}
