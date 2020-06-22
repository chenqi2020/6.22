package com.chenqi.controller;

import com.chenqi.entity.House;
import com.chenqi.service.DistrictService;
import com.chenqi.service.HouseService;
import com.chenqi.vo.ResultEntity;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("house")

public class HouseController {

    @Resource
    private HouseService houseService;
    @Resource
    private DistrictService districtService;

    @RequestMapping("list")
    public ResultEntity list(@RequestParam(defaultValue = "1")Integer pageNum, @RequestParam(defaultValue = "3")Integer pageSize, House house, Integer rentSearch){
        Page page = houseService.list(pageNum, pageSize, house, rentSearch);
        return ResultEntity.ok(page);
    }

    @RequestMapping("saveOrUpdate")
    public ResultEntity saveOrUpdate(@RequestBody House house){
        boolean b = houseService.saveOrUpdate(house);
        return ResultEntity.ok(b);
    }

    @RequestMapping("upload")
    public ResultEntity upload(MultipartFile file){
        //文件上传
        if (file!=null&&!file.isEmpty()){
            //h获取文件的原始名称
            String fileOriginalFilename=file.getOriginalFilename();
            //拼接一个新名称
            String fileName= UUID.randomUUID()+"_"+fileOriginalFilename;
            //保存的文件地址
            File destFile=new File("D:\\pic",fileName);

            try {
                //执行保存
                file.transferTo(destFile);
                //头像保存的地址
                String pic="http://localhost:92/img/"+fileName;
                return ResultEntity.ok(pic);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ResultEntity.error();
    }

    @RequestMapping("delete")
    public ResultEntity delete(Integer[] ids){
        boolean b = houseService.delete(ids);
        return ResultEntity.ok(b);
    }

    @RequestMapping("/getList")
    public ResultEntity getList(){
        return ResultEntity.ok(districtService.getList());
    }

    @RequestMapping("/getListByPid")
    public ResultEntity getListByPid(){
        return ResultEntity.ok(districtService.getListByPid());
    }
}
