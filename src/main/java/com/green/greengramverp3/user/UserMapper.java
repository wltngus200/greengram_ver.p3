package com.green.greengramverp3.user;

import com.green.greengramverp3.user.model.SignUpPostReq;
import com.green.greengramverp3.user.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int postUser(SignUpPostReq p);
    User getUserId(String uid);
}
