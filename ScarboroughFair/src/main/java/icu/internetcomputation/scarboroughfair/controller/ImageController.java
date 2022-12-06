package icu.internetcomputation.scarboroughfair.controller;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import icu.internetcomputation.scarboroughfair.entity.Message;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;

@RestController
public class ImageController {
    @PostMapping("/upload")
    public Message insertDbMsPhoto(@RequestPart("photos") MultipartFile[] photos, HttpServletRequest request) {
        try {
            System.out.println(photos.length);
            if (photos.length > 0) {
                for (MultipartFile photo : photos) {
                    if (!photo.isEmpty()) {
                        String originalFilename = photo.getOriginalFilename();

                        String sufixPhoto = originalFilename.split("\\.")[1];
                        //拼接图片
                        String date = new SimpleDateFormat("yyyyMM").format(System.currentTimeMillis());
                        InputStream is = null;
                        OutputStream os = null;
                        //获得路径 本地路径
                        String filePath = request.getSession().getServletContext()
                                .getRealPath("/UploadFiles/db/photo/" + date + "/");
                        File file = new File(filePath);
                        if (!file.exists()) {
                            //先创建该文件的所有上级目录
                            if (file.getParentFile().mkdirs()) {
                                try {
                                    //如果不存在就创建
                                    file.mkdir();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        //获得图片名称
                        String photoName = date + System.currentTimeMillis() + "." + sufixPhoto;

                        try {
                            is = photo.getInputStream();
                            os = new FileOutputStream(new File(filePath + photoName));
                            FileCopyUtils.copy(is, os);
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                os.flush();
                                os.close();
                                is.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                //照片上传成功后返回照片信息到页面，用于更新页面显示的照片信息，便于删除是获取相关信息
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Message(false, "上传失败");
        }
        return new Message(true, "上传成功");
    }
}
