package com.uban.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.uban.provider.dao.DubboDemoDao;
import com.uban.service.DubboDemoService;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;

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
    @Autowired
    private SolrTemplate officeInfoSolrTemplate;

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

    @GET
    @POST
    @Path("solrTest")
    public JSONArray solrTest() {
        JSONArray officeArray = new JSONArray();
        SolrQuery solrQuery = new SolrQuery();
        SolrServer solrServer = officeInfoSolrTemplate.getSolrServer();
        solrQuery.set("q","*:*");
        try {
            QueryResponse queryResponse = solrServer.query(solrQuery);
            officeArray = JSON.parseArray(JSON.toJSONString(queryResponse.getResults()));
        } catch (SolrServerException e) {
            e.printStackTrace();
        }
        return officeArray;
    }
}
