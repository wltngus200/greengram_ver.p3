package com.green.greengramverp3.user;

import com.green.greengramverp3.common.CustomFileUtils;
import com.green.greengramverp3.user.model.SignInPostReq;
import com.green.greengramverp3.user.model.SignUpPostReq;
import com.green.greengramverp3.user.model.User;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;
    private final CustomFileUtils customFileUtils;

    int postUser(MultipartFile mf, SignUpPostReq p){
        //암호화
        String hashPass= BCrypt.hashpw(p.getUpw(),BCrypt.gensalt());
        p.setUpw(hashPass);
        String randName=customFileUtils.makeRandomName(mf);
        p.setPic(randName);
        int result=mapper.postUser(p);

        //사진 처리
        String path=String.format("user/%d", p.getUserId());
        customFileUtils.makeFolders(path);
        String target=String.format("%s%s", path,randName);

        try{//여기가 맞나..?
            if(mf!=null){
                customFileUtils.transferTo(mf, target);
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
        return result;
    }

    User getUserId(SignInPostReq p){
        User user= mapper.getUserId(p.getUid());
        if(user==null){
            throw new RuntimeException("(⊙x⊙;) 일치하는 회원을 찾을 수 없습니다.");
        }else if(!BCrypt.checkpw(p.getUid(),user.getUpw())){
            throw new RuntimeException("Σ(っ °Д °;)っ 비밀번호가 틀렸습니다.");
        }
        return user;
    }
}
