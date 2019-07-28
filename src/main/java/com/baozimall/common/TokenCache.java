package com.baozimall.common;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class TokenCache {

    private static Logger logger = LoggerFactory.getLogger(TokenCache.class);

    public static final String TOKEN_PREFIX = "token_";

    //本地缓存
    private static LoadingCache<String,String> localCache = CacheBuilder
            .newBuilder()
            .initialCapacity(1000)//初始化容量
            .maximumSize(10000)//最大容量，超过容量的话使用LRU（最少使用）删除缓存
            .expireAfterAccess(12, TimeUnit.HOURS)//有效期（12 小时）
            .build(new CacheLoader<String, String>() {//匿名实现
                //默认的数据加载实现,当调用get取值的时候,如果key没有对应的值,就调用这个方法进行加载.
                //如get("key"),但是"key"没有value，则返回load()的返回值，在这里返回"null“字符串，避免比较时的空指针异常
                @Override
                public String load(String s) throws Exception {
                    return "null";
                }
            });

    public static void setKey(String key,String value){
        localCache.put(key,value);
    }

    public static String getKey(String key){
        String value = null;
        try {
            value = localCache.get(key);
            if("null".equals(value)){
                return null;
            }
            return value;
        }catch (Exception e){
            logger.error("localCache get error",e);
        }
        return null;
    }
}
