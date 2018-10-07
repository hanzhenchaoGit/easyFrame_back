package com.frank.boot.controller.system;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.frank.boot.controller.base.BaseController;
import com.frank.boot.domain.system.ResultData;
import com.frank.boot.domain.system.UploadFileList;
import com.frank.boot.domain.user.SysUser;
import com.frank.boot.service.system.UploadFileListService;
import com.frank.boot.service.user.SysUserService;
import com.frank.boot.utils.DateUtils;
import com.frank.boot.utils.MongoUtils;
import org.apache.commons.lang.StringUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/file")
public class FileController extends BaseController {

    @Autowired
    UploadFileListService fileListService;
    @Autowired
    MongoUtils mongoUtils;
    @Autowired
    SysUserService sysUserService;
    @PostMapping("/upload")
    public ResultData upload(MultipartHttpServletRequest multiReq,String groupId) throws IOException {
        Map<String,MultipartFile> fileMap = multiReq.getFileMap();
        String groupid = getString("groupid");
        String fileremark = getString("fileremark");
        if(StringUtils.isEmpty(groupid)){
            groupid = UUID.randomUUID().toString();
        }
        ResultData resultData = new ResultData();
        for(Map.Entry<String, MultipartFile> entry : fileMap.entrySet()){
            MultipartFile multipartFile = fileMap.get(entry.getKey());
            String originalFilename = multipartFile.getOriginalFilename();
            String mongoFileNameId = UUID.randomUUID()+"-"+originalFilename;

            ObjectId id = mongoUtils.store(multipartFile.getInputStream(),mongoFileNameId,multipartFile.getContentType());
            if(id != null){
                resultData.setMsg("上传成功");
                resultData.setData(originalFilename);
                UploadFileList upFile = new UploadFileList();
                upFile.setFileremark(fileremark);
                // uuid标识文件 避免获取的时候取到重复文件名的文件
                upFile.setFilename(originalFilename);
                upFile.setFilesize(String.valueOf(multipartFile.getSize()));
                upFile.setFileurl(mongoFileNameId);
                upFile.setGroupid(groupid);
                upFile.setUploaduser(getCurrentUser().getUserName());
                fileListService.insert(upFile);
                resultData.setData(upFile);
            }else{
                resultData.setMsg("上传失败");
            }
        }
        return resultData;
    }
    @GetMapping("/getFileList")
    public ResultData getFileListByGroupid(@RequestParam("groupid") String groupid){
        String address = request.getRequestURL()
                .substring(0,request.getRequestURL().indexOf(String.valueOf(request.getLocalPort())))+request.getLocalPort()+"/file/getFile?fn=";
        List<UploadFileList> fileLists = fileListService.selectList(new EntityWrapper<UploadFileList>().eq("groupid",groupid));
        for(UploadFileList file : fileLists){
            file.setFileurl(address+file.getFileurl());
        }
        return new ResultData(fileLists);
    }

    @GetMapping("/deleteFileById")
    public ResultData deleteFileById(@RequestParam("id") Integer id){

//        UploadFileList file = fileListService.selectById(id);
//        File localFile = new File(uploadPath+file.getFileurl()+file.getFilename());
//        if(localFile.exists()){
//            localFile.delete();
//        }
//        fileListService.deleteById(id);
        return new ResultData();
    }
    @GetMapping("/getFile")
    public void getFileById(@RequestParam("fn") String fn) throws IOException {
        response.setContentType("application/x-msdownload");
        GridFsResource gridFsResource = mongoUtils.getFile(fn);
        String filename = new String(gridFsResource.getFilename() .getBytes(), "ISO-8859-1");
        response.setHeader("Content-Disposition", "attachment;filename=" + filename);
        InputStream in = gridFsResource.getInputStream();   //用该文件创建一个输入流
        OutputStream os = response.getOutputStream();  //创建输出流
        byte[] b = new byte[1024];
        while( in.read(b)!= -1){
            os.write(b);
        }
        in.close();
        os.close();
    }
}
