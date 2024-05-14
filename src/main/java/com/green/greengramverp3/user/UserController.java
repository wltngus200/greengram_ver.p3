package com.green.greengramverp3.user;

import com.green.greengramverp3.common.ResultDto;
import com.green.greengramverp3.user.model.SignInPostReq;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("api/user")
@RestController
public class UserController {
    private final UserService service;

    public ResultDto<Integer> postUser(SignInPostReq p){
        return ResultDto.<Integer>builder()
                .build();
    }


}
