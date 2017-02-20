package com.uban.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.alibaba.fastjson.JSONObject;
import com.uban.provider.dao.DubboDemoDao;
import com.uban.service.DubboDemoService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by DuanYangYu on 2016/11/2 0002.
 * @Path 类似springMVC中的RequestMapping
 */
@Path("demo")
@Service
@Produces({ ContentType.APPLICATION_JSON_UTF_8 })
public class DubboDemoServiceImpl implements DubboDemoService {

    @Autowired
    private DubboDemoDao dubboDemoDao;

    public JSONObject demo(String val) {
        JSONObject jo = new JSONObject();
        jo.put("result","请求的参数为 : "+val);
        return jo;
    }

    @GET
    @POST
    @Path("users")
    public JSONObject getUsers() {
        JSONObject jo = new JSONObject();
        jo.put("result",dubboDemoDao.getUsers());
        return jo;
    }
}
