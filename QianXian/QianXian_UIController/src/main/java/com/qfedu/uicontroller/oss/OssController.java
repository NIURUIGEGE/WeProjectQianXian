package com.qfedu.uicontroller.oss;

import com.qfedu.core.util.FileUtils;
import com.qfedu.core.util.OSSUtil;
import com.qfedu.core.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;

@RestController
public class OssController {
    @Autowired
    private OSSUtil ossUtil;
    //文件上传
    @PostMapping("/fileup")
    public R ileup(CommonsMultipartFile file){
        String fn=FileUtils.createFileName(file.getOriginalFilename());
        String url=ossUtil.fileUp(fn,file.getBytes());
        return new R(0,fn+"@"+url,null);
    }
}
