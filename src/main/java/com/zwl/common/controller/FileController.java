package com.zwl.common.controller;

import com.alibaba.fastjson.JSON;
import com.zwl.common.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 二师兄超级帅
 * @Title: ImageController
 * @ProjectName parent
 * @Description: TODO
 * @date 2018/7/1919:12
 */
@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    private FileUploadService fileUploadService;

    @PostMapping("/upload")
    public String imageUpload(@RequestParam("file") MultipartFile file) {
//        {
//            "code": 0
//                ,"msg": ""
//                ,"data": {
//            "src": "http://cdn.layui.com/123.jpg"
//        }
//        }

        String url = fileUploadService.upload(file, 1);
        Map urlMap = new HashMap();
        urlMap.put("src", url);
        Map result = new HashMap();
        result.put("code", 0);
        result.put("msg", "");
        result.put("data", urlMap);
        return JSON.toJSONString(result);
    }
}
