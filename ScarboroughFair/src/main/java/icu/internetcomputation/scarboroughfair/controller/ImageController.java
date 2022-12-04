package icu.internetcomputation.scarboroughfair.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import icu.internetcomputation.scarboroughfair.entity.Message;
import java.io.File;
import java.util.UUID;

@RestController
public class ImageController {

    @PostMapping("/uploadres")
    public Object upload(MultipartFile fileUpload){

        
        //绝对路径
        // String baseDir = "C:/D/Program/web/NJU-SE-Internet-Computation-Project/ScarboroughFair/testImageBalabala/hha";
        String baseDir = "/testImageBalabala/haha";


        String fileName = fileUpload.getOriginalFilename();

        String suffixName = fileName.substring(fileName.lastIndexOf("."));

        fileName = UUID.randomUUID()+suffixName;
        try {
            File f=new File(baseDir, fileName);

            if (!f.getParentFile().exists()) {   //create parent file
                f.getParentFile().mkdirs();
            }

            fileUpload.transferTo(f.getAbsoluteFile());

            return new Message(true,"上传成功",f.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
            return new Message(false,"上传失败",null);
        }
    }
}
