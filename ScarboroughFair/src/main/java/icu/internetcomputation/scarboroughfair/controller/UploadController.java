package icu.internetcomputation.scarboroughfair.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.text.SimpleDateFormat;
import icu.internetcomputation.scarboroughfair.entity.Message;
import icu.internetcomputation.scarboroughfair.service.ForumService;
import icu.internetcomputation.scarboroughfair.service.GoodService;
import icu.internetcomputation.scarboroughfair.service.UserService;

import java.io.File;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import java.util.Date;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Controller
@CrossOrigin
public class UploadController {

    /*
     * TODO: 有个问题，目前商品和用户信息的上传都在这个controller，
     *       但按正常思路应该分别放在GoodController和UserController，
     *       待定
     */

    @Resource
    private GoodService goodService;

    @Resource
    private UserService userService;

    @Resource
    private ForumService forumService;


    @Value("${file.uploadFolder}")
    private String realBasePath;
    @Value("${file.accessPath}")
    private String accessPath;


    // 测试接口
    @RequestMapping(path="/tmpupload",method = RequestMethod.GET)
    public String tmpupload(Model model){
        return "tmpupload";
    }
    
    // original 初始的upload上传接口
    @PostMapping(path="/upload")
    @ResponseBody
    public Message upload(@RequestParam(value = "file") MultipartFile fileUpload, Model model){
        return OriginalImgupload(fileUpload);
    }


    /*
     * 商品信息 <<<上传>>> 的接口，包括商品图片，商品名称，商品价格，商品描述
     */
    @PostMapping(path="/goodupload")
    @ResponseBody
    public Message GoodUpload( 
        @RequestParam(value = "name") String name, 
        @RequestParam(value = "price") String price,
        @RequestParam(value = "cover") MultipartFile coverUpload,
        @RequestParam(value = "pic") MultipartFile[] picUpload,
        @RequestParam(value = "description") String description,
        @RequestParam(value = "tag") String tag,Model model)
    {

        String coverUrl = Imgupload(coverUpload);
        String[] picUrl = new String[ picUpload.length ];
        for(int i = 0; i < picUpload.length; i++){
            picUrl[i] = Imgupload(picUpload[i]);
        }

        if(coverUrl == null||picUrl == null){
            return new Message(false, "图片好像上传失败了姆Q~w(ﾟДﾟ)w");
        }

        return goodService.addGood(name, Float.valueOf(price), coverUrl, picUrl, description, tag);
    }


    /*
     * 用户个人信息 <<<修改>>> 的接口，包括头像，昵称，个性签名（不包括密码！！！）
     */
    @PostMapping(path="/userupload")
    @ResponseBody
    @CrossOrigin
    public Message UserUpload(
        @RequestParam(value = "avator", required = false) MultipartFile avator,
        @RequestParam(required = false) String nickname, 
        @RequestParam(required = false) String saying,
        @RequestParam(required = false) String userID, Model model)
    {
        
        String avatorUrl = null;
        if(avator != null)
        {
            avatorUrl = Imgupload(avator);
        }
        // if(avatorUrl == null){
        //     return new Message(false, "图片好像上传失败了w(ﾟДﾟ)w");
        // }
        Integer id = Integer.valueOf(userID);
        return userService.editUser(id, avatorUrl, nickname, saying);
    }

    /*
     * 论坛发帖的接口
     */
    @PostMapping(path = "/postupload")
    @ResponseBody
    @CrossOrigin
    public Message PostUpload(
        @RequestParam(value = "pic", required = false) MultipartFile[] picUpload,
        @RequestParam(required = false) String content, 
        @RequestParam(required = false) String userID, Model model)
    {
        String[] imgUrl = new String[ picUpload.length ];
        for(int i = 0; i < picUpload.length; i++){
            imgUrl[i] = Imgupload(picUpload[i]);
        }
        Integer id = Integer.valueOf(userID);
        return forumService.addPost(id, content, imgUrl);
    }


    /*
     * 负责将图片上传至数据库指定路径，并返回一个虚拟路径的Url
     */
    public String Imgupload(MultipartFile fileUpload){
        String fileName = fileUpload.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID() + suffixName;
        //获取日期
        Date todayDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = dateFormat.format(todayDate);

        //域名访问的相对路径目录，通过浏览器访问的链接（虚拟路径）
        String saveToPath = accessPath + today + "/";

        // 真实的路径，实际储存的目录
        String realPath = realBasePath + today + "/";

        //储存文件的物理路径，建立在本地
        String filepath = realPath + fileName;
        try {
            File f = new File(filepath);
            
            if (!f.getParentFile().exists()) {   //create parent file
                f.getParentFile().mkdirs();
            }

            fileUpload.transferTo(f.getAbsoluteFile());

            return saveToPath + fileName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /*
     * 初始的Imgupload上传接口，负责将图片保存到数据库指定路径，并返回一个Message
     */
    public Message OriginalImgupload(MultipartFile fileUpload){
        String fileName = fileUpload.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID() + suffixName;
        //获取日期
        Date todayDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = dateFormat.format(todayDate);
        //域名访问的相对路径目录，通过浏览器访问的链接（虚拟路径）
        String saveToPath = accessPath + today + "/";
        // 真实的路径，实际储存的目录
        String realPath = realBasePath + today + "/";
        //储存文件的物理路径，建立在本地
        String filepath = realPath + fileName;
        try {
            File f = new File(filepath);
            
            if (!f.getParentFile().exists()) {   //create parent file
                f.getParentFile().mkdirs();
            }

            fileUpload.transferTo(f.getAbsoluteFile());

            return new Message(true,"好耶，图片上传成功了ヽ(✿ﾟ▽ﾟ)/da☆ze", saveToPath+fileName);
        } catch (Exception e) {
            e.printStackTrace();
            return new Message(false,"图片好像上传失败了姆Q~w(ﾟДﾟ)w",null);
        }
    }


    // 地址映射配置
    @Configuration
    public class UploadConfig implements WebMvcConfigurer{
        @Value("${file.staticAccessPath}")
        private String staticAccessPath;

        @Value("${file.uploadFolder}")
        private String uploadFolder;

        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry)
        {
            registry.addResourceHandler(staticAccessPath).addResourceLocations("file:" + uploadFolder);
        }
    }


}