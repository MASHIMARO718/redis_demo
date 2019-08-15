package com.example.redis_demo.controller;

import com.example.redis_demo.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author by jiangmenghui
 * @version [版本号, 2019/8/15]
 * @Classname RedisController
 * @Description TODO
 * @Date 2019/8/15
 */
@RestController
@RequestMapping(value = "/hello")
public class RedisController {
    @Autowired
    public RedisUtil redisUtil;
    @GetMapping("/redis-set")
    public void test(String key,String value){
        redisUtil.set(key,value);
    }

    @PostMapping("/redis-set-map")
    public void test(@RequestBody Map<String,Object> map){
        redisUtil.hmset(map.get("applyId").toString(),map);
    }

    @GetMapping("/redis-get-map/{applyid}")
    public Map<Object,Object> test(@PathVariable String applyid){
        return redisUtil.hmget(applyid);
    }
}
