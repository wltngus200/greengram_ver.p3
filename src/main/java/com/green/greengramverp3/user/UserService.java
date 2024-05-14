package com.green.greengramverp3.user;

import com.green.greengramverp3.user.model.SignInPostReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;

    int postUser(SignInPostReq p){
        //암호화

        //사진 처리


        return mapper.postUser(p);
    }
}
