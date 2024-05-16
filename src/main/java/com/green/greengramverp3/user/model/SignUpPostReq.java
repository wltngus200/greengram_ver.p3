package com.green.greengramverp3.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpPostReq {//가입
    @JsonIgnore
    private long userId;

    private String uid;
    private String upw;
    private String nm;
    private String pic;
}
