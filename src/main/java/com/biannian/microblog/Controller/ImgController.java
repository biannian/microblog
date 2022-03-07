package com.biannian.microblog.Controller;

import com.biannian.microblog.Model.CurrentIp;
import com.biannian.microblog.Model.Result;
import com.biannian.microblog.Utils.UUIDUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

@RestController
@RequestMapping({"/Img"})
public class ImgController {

    @RequestMapping("/pictureDelete.do")
    public Result<?> pictureDelete(String path) {
        path = path.replace("/picture/", "");
        path = "D:/IdeaProject/Delivery/src/main/resources/static/picture/" + path;
        File file = new File(path);
        if (file.exists()) {//文件是否存在
            if (file.delete()) {//存在就删了
                return Result.success();
            } else {
                return Result.fail();
            }
        } else {
            System.out.println("文件不存在");
            return Result.fail();
        }
    }

    @RequestMapping("/pictureAdd.do")
    public Result<?> pictureAdd(@RequestParam("picture") MultipartFile picture) {
        String path = "D:/code/microblog/src/main/resources/static/picture";
        File filePath = new File(path);
        //如果目录不存在，创建目录
        if (!filePath.exists() && !filePath.isDirectory()) {
            filePath.mkdir();
        }
        //获取原始文件名称(包含格式)
        String originalFileName = picture.getOriginalFilename();
        //获取文件类型，以最后一个`.`为标识
        String type = Objects.requireNonNull(originalFileName).substring(originalFileName.lastIndexOf(".") + 1);
        //获取文件名称（不包含格式）
        String name = originalFileName.substring(0, originalFileName.lastIndexOf("."));
        //新名字
        String fileName = UUIDUtils.getUUID() + "." + type;
        //在指定路径下创建一个文件
        File targetFile = new File(path, fileName);
        //将文件保存到服务器指定位置
        try {
            picture.transferTo(targetFile);
            //将文件在服务器的存储路径返回
            return Result.success("/picture/" + fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return Result.fail();
        }
    }
}
