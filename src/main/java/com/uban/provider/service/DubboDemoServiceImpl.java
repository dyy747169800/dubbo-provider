package com.uban.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;
import com.uban.provider.dao.DubboDemoDao;
import com.uban.service.DubboDemoService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by DuanYangYu on 2016/11/2 0002.
 */
@Service
public class DubboDemoServiceImpl implements DubboDemoService {

    @Autowired
    private DubboDemoDao dubboDemoDao;

    public JSONObject demo(String val) {
        JSONObject jo = new JSONObject();
        jo.put("result","请求的参数为 : "+val);
        return jo;
    }

    public JSONObject getUsers() {
        JSONObject jo = new JSONObject();
        jo.put("result",dubboDemoDao.getUsers());
        return jo;
    }
}
