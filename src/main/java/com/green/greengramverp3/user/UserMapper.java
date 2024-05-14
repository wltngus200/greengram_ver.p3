package com.green.greengramverp3.user;

import com.green.greengramverp3.user.model.SignInPostReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int postUser(SignInPostReq p);
}
