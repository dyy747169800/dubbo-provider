package com.uban.provider.dao;

import com.alibaba.fastjson.JSONObject;
import com.uban.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by DuanYangYu on 2016/11/2 0002.
 */
@Repository
public interface DubboDemoDao {

    public List<User> getUsers();
}
