package com.opentpi.qa.feedback.service.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.opentpi.qa.feedback.dao.FeedBackTaskMapper;
import com.opentpi.qa.feedback.model.FeedBackTask;
import com.opentpi.qa.feedback.service.FeedBackTaskService;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.StrUtil;

@Service("feedBackTaskService")
public class FeedBackTaskServiceImpl implements FeedBackTaskService {

	private static final String feedBackTaskDir = "/home/dnzx/uploadfile"+File.separator
			+"feedBackTask"+File.separator;
	
	@Autowired
	private FeedBackTaskMapper feedBackTaskMapper;
	
	/**
	 * @description 新增
	 * @author Abruzzi
	 * @param FeedBackTask
	 * @return String
	 */
    @Override
    public String addFeedBackTask(FeedBackTask record) throws Exception {
    	try {
			Integer i = feedBackTaskMapper.addFeedBackTask(record);
			if (i > 0) {
				return "success";
			}else {
				return "新增失败！";
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
    }
    
    /**
	 * @description 修改
	 * @author Abruzzi
	 * @param FeedBackTask
	 * @return String
	 */
    @Override
    public String updateFeedBackTask(FeedBackTask record) throws Exception {
	    try {
	    	Integer i = feedBackTaskMapper.updateFeedBackTask(record);
	    	if (i > 0) {
				return "success";
			}else {
				return "修改失败！";
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
    }
    
    /**
	 * @description 根据主键查询
	 * @author Abruzzi
	 * @param id
	 * @return Task
	 */
    @Override
    public FeedBackTask getFeedBackTask(int id){
    	return feedBackTaskMapper.getFeedBackTask(id);
    }

    /**
	 * @description 根据条件查询（分页）
	 * @author Abruzzi
	 * @param Map<String, Object>
	 * @return PageInfo<Task>
	 */
    @Override
    public PageInfo<FeedBackTask> listByParam(Map<String, Object> params){
    	PageHelper.startPage(Integer.parseInt(params.get("page").toString()), Integer.parseInt(params.get("pageSize").toString()));
    	List<FeedBackTask> list = feedBackTaskMapper.listByParam(params);
    	return new PageInfo<>(list);
    }
    
    /**
	 * @description 根据条件查询
	 * @author Abruzzi
	 * @param Map<String, Object>
	 * @return List<Task>
	 */
    @Override
    public List<FeedBackTask> listByMap(Map<String, Object> params){
    	List<FeedBackTask> list = feedBackTaskMapper.listByParam(params);
    	return list;
    }
    
    /**fileUpload
	 * 上传脚本
	 * @param files data
	 * @return Map<String,Object>
	 * @throws IOException 
	 */
    @Override
	public String fileUpload(CommonsMultipartFile file, String fileType, FeedBackTask feedBackTask) {
		try {
			if (file != null && !file.isEmpty()) {
				//上传文件
				
				File uploadPath = new File(feedBackTaskDir);
				//创建文件路径
				if(!uploadPath.exists()){
					uploadPath.mkdirs();
				}
				//读取文件信息
				String[] fileName = file.getOriginalFilename().split("\\.");
				String filePath = feedBackTaskDir + fileName[0] + "_" + fileType + "." + fileName[1];//后缀：文件类型
				InputStream is = file.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is, "GBK"));
				//写入文件
				FileOutputStream os = new FileOutputStream(filePath);
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
				String line = null;
				while((line = br.readLine()) != null){
					bw.write(line+"\r\n");
				}
				bw.flush();
				IoUtil.close(bw);
				IoUtil.close(is);
				
				//构造文件信息
				JSONObject json = new JSONObject();
				json.put("fileType", fileType);
				json.put("fileName", filePath);
				//获取文件信息列表
				List<JSONObject> objList = JSONObject.parseArray(feedBackTask.getFileInfo(), JSONObject.class);
				if (objList == null) {
					objList = new ArrayList<>();
				}
				//判断是否存在该文件,存在则覆盖，不存在则新增文件信息
				if (!objList.contains(json)) {
					objList.add(json);
				}
				return JSONObject.toJSONString(objList);
			}
		} catch (Exception e) {
			
		}
		return StrUtil.EMPTY;
	}
}
