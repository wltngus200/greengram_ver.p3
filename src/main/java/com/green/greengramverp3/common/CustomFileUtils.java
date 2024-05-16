package com.green.greengramverp3.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Component
public class CustomFileUtils {
    //할 일: 랜덤이름 생성(확장자 따서 붙이기), 폴더 생성, 저장 메소드
    private final String uploadPath;

    public CustomFileUtils(@Value("${file.directory}")String uploadPath){
        this.uploadPath=uploadPath;
    }

    public String makeRandomName(){return UUID.randomUUID().toString();}
    public String makeRandomName(String FileName){return makeRandomName()+getExt(FileName);}
    public String makeRandomName(MultipartFile mf){
        //null일 경우 빼먹음
        return mf==null||mf.isEmpty()?null:makeRandomName(mf.getOriginalFilename());}

    public String getExt(String fileName){//파라미터=이름으로 받는다
        int idx=fileName.lastIndexOf(".");
        String ext=fileName.substring(idx);
        return ext;
    }

    public String makeFolders(String path){
        //리턴타입 틀림 //순서 틀림
        File folder=new File(uploadPath, path);
        folder.mkdirs();
        return folder.getAbsolutePath();
    }
    public void transferTo(MultipartFile mf, String target) throws Exception {
        File saveFile=new File(uploadPath, target);
        //예외 던지기+제대로 못 함 //File 생성자는 무조건 기존주소 + 새주소
        mf.transferTo(saveFile);
    }


}
