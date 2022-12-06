package icu.internetcomputation.scarboroughfair.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import icu.internetcomputation.scarboroughfair.FileUtil;
import icu.internetcomputation.scarboroughfair.entity.Message;
import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

@Controller
@CrossOrigin
public class ImageController {

    // private String[] uploadImageTypes = { "png", "jpg", "jpeg", "gif"};

    @RequestMapping(path="/tmpupload",method = RequestMethod.GET)
    public String tmpupload(Model model){
        return "tmpupload";
    }

    @PostMapping(path="/upload")
    @ResponseBody
    public Message upload(@RequestParam(value = "file") MultipartFile fileUpload, Model model){
        //绝对路径
        // String baseDir = "C:/D/Program/web/NJU-SE-Internet-Computation-Project/ScarboroughFair/testImageBalabala/hha";
        // String baseDir = "C://Users//Corax//Desktop//upload//image";
        // System.out.println(fileUpload.toString());
        
        // 随便加个检查格式
        // String fileType = fileUpload.getContentType();
        // boolean Typeflag = false;
        // for(String type: uploadImageTypes){
        //     if(fileType.equals(type)){
        //         Typeflag = true;
        //         break;
        //     }
        // }
        // if(!Typeflag){
        //     return new Message(false, "请选择格式正确的图片", null);
        // }

        String UploadPath = "F:\\Img\\"; // 本地路径
        String fileName = fileUpload.getOriginalFilename();
        // String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String destFileName = UploadPath + fileName;
        // fileName = UUID.randomUUID()+suffixName;
        try {
            // File f=new File(UploadPath);
            FileUtil.uploadFile(fileUpload.getBytes(), UploadPath, fileName);
            
            // File targetfile = new File(destFileName);
            // if (!targetfile.getParentFile().exists()) {   //create parent file
            //     targetfile.getParentFile().mkdirs();
            // }

            // fileUpload.transferTo(targetfile);
            // fileUpload.transferTo(f.getAbsoluteFile());

            return new Message(true,"上传成功", destFileName);
        } catch (Exception e) {
            e.printStackTrace();
            return new Message(false,"上传失败",null);
        }
    }
}