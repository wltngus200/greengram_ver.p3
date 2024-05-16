package com.green.greengramverp3.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInPostReq {//로그인
    private String uid;
    private String upw;
}
