//package com.frank.boot.controller.system;
//
//import java.awt.*;
//import java.io.*;
//import java.util.*;
//import java.util.List;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.frank.boot.domain.system.UploadFileList;
//import com.frank.boot.service.system.UploadFileListService;
//import com.frank.boot.utils.DateUtils;
//import com.frank.boot.utils.FileUtils;
//import org.apache.commons.lang.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.MultipartHttpServletRequest;
//import com.frank.boot.domain.system.ResultData;
//import com.frank.boot.controller.base.BaseController;
///**
// * 文件上传服务
// * @author Administrator
// *
// */
//@RequestMapping("/file")
//@RestController
//public class FileCRUDController extends BaseController {
//	@Value("${system.upload.template}")
//	String uploadPath;
//
//	@Autowired
//	UploadFileListService uploadFileListService;
//
//	@PostMapping("/upload")
//	public ResultData upload(MultipartHttpServletRequest multiReq) throws IOException {
//		Map<String,MultipartFile> fileMap = multiReq.getFileMap();
//		String groupid = getString("groupid");
//		String fileremark = getString("fileremark");
//
//		if(StringUtils.isEmpty(groupid)){
//			groupid = UUID.randomUUID().toString();
//		}
//
//		String filePath = uploadPath+DateUtils.getCurrentDate()+"/";
//		FileUtils.checkDirExists(new File(filePath));
//		ResultData resultData = new ResultData();
//        Map<String,String> result = new HashMap<>();
//		for(Map.Entry<String, MultipartFile> entry : fileMap.entrySet()){
//			MultipartFile multipartFile = fileMap.get(entry.getKey());
//			InputStream fileIn = multipartFile.getInputStream();
//			String fileName = UUID.randomUUID()+"-"+multipartFile.getOriginalFilename();
//			BufferedInputStream in=null;
//		    BufferedOutputStream out=null;
//		    in=new BufferedInputStream(fileIn);
//		    out=new BufferedOutputStream(new FileOutputStream(filePath+fileName));
//		    int len=-1;
//		    byte[] b=new byte[1024];
//		    while((len=in.read(b))!=-1){
//		        out.write(b,0,len);
//		    }
//		    in.close();
//		    out.close();
//		    UploadFileList upFile = new UploadFileList();
//		    upFile.setFileremark(fileremark);
//		    // uuid标识文件 避免获取的时候取到重复文件名的文件
//		    upFile.setFilename(fileName);
//		    upFile.setFilesize(String.valueOf(multipartFile.getSize()));
//		    upFile.setFileurl(DateUtils.getCurrentDate()+"/");
//		    upFile.setGroupid(groupid);
//		    upFile.setUploaduser(getCurrentUser().getUserName());
//			uploadFileListService.insert(upFile);
//			resultData.setData(upFile);
//		}
//		return resultData;
//	}
//	@GetMapping("/templates")
//	public ResultData getTemplates(){
//		File file = new File(uploadPath);
//		File[] listFile = file.listFiles();
//		List<Map<String,String>> fileNames = new ArrayList<Map<String,String>>();
//		for(File f : listFile){
//			Map<String,String> map = new HashMap<String,String>();
//			map.put("name", f.getName());
//			map.put("value", f.getName());
//			fileNames.add(map);
//		}
//		return new ResultData(fileNames);
//	}
//	@GetMapping("/getFileList")
//	public ResultData getFileListByGroupid(@RequestParam("groupid") String groupid){
//		String address = request.getRequestURL()
//						.substring(0,request.getRequestURL().indexOf(String.valueOf(request.getLocalPort())))+request.getLocalPort()+"/file/getFileById?id=";
//		List<UploadFileList> fileLists = uploadFileListService.selectList(new QueryWrapper<UploadFileList>().eq("groupid",groupid));
//		for(UploadFileList file : fileLists){
//			file.setFileurl(address+file.getId());
//		}
//		return new ResultData(fileLists);
//	}
//
//	@GetMapping("/deleteFileById")
//	public ResultData deleteFileById(@RequestParam("id") Integer id){
//
//		UploadFileList file = uploadFileListService.selectById(id);
//		File localFile = new File(uploadPath+file.getFileurl()+file.getFilename());
//		if(localFile.exists()){
//			localFile.delete();
//		}
//		uploadFileListService.removeById(id);
//		return new ResultData();
//	}
//	@GetMapping("/getFileById")
//	public void getFileById(@RequestParam("id") String fileId) throws IOException {
//		UploadFileList file = uploadFileListService.selectById(fileId);
//		String filepath = file.getFileurl();
//		File localFile = new File(uploadPath+filepath+	file.getFilename());
//		response.setContentType("application/x-msdownload");
//		String filename = new String(file.getFilename() .getBytes(), "ISO-8859-1");
//		response.setHeader("Content-Disposition", "attachment;filename=" + filename);
//		if(localFile.exists()){
//			InputStream in = new FileInputStream(localFile);   //用该文件创建一个输入流
//			OutputStream os = response.getOutputStream();  //创建输出流
//			byte[] b = new byte[1024];
//			while( in.read(b)!= -1){
//				os.write(b);
//			}
//			in.close();
//			os.flush();
//			os.close();
//		}
//	}
//	public static void main(String[] args){
//		File localFile = new File("D://upload/template/2018-09-13/新建文本文档.txt");
//		System.out.println(localFile.exists());
//
//		String ad = "http://localhost:9999/dwdw";
//		System.out.println(ad.substring(0,ad.indexOf("9999")));
//	}
//}
