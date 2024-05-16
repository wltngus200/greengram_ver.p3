package com.green.greengramverp3.user;

import com.green.greengramverp3.common.ResultDto;
import com.green.greengramverp3.user.model.SignInPostReq;
import com.green.greengramverp3.user.model.SignInRes;
import com.green.greengramverp3.user.model.SignUpPostReq;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RequestMapping("api/user")
@RestController
public class UserController {
    private final UserService service;

    @PostMapping("sign-up")
    public ResultDto<Integer> postUser(@RequestPart MultipartFile mf, @RequestPart SignUpPostReq p){
        int result=service.postUser(mf, p);
        return ResultDto.<Integer>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("( •̀ ω •́ )✧ 반가워 새 친구")
                .resultData(result)
                .build();
    }
    @PostMapping("sign-in")
    public ResultDto<SignInRes> tmtmtm(SignInPostReq p){
        SignInRes result;
        return ResultDto.<SignInRes>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("(｡･∀･)ﾉﾞ어서 와")
                //.resultData()
                .build();
    }


}
