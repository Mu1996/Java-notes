package com.muyonghui.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;
import java.util.UUID;

public class RedisLock {


    public String getLock(String key, int timeout){

        try {
            Jedis jedis = RedisManager.getJedis();
            String value = UUID.randomUUID().toString();

            long end = System.currentTimeMillis()+timeout;
            //循环阻塞
            while (System.currentTimeMillis() < end){

                if(jedis.setnx(key,value) == 1){
                    jedis.expire(key,timeout);
                    //锁设置成功，redis操作成功
                    System.out.println("获得锁"+key);
                    return value;
                }
                if(jedis.ttl(key)==-1){ //检测过期时间
                    jedis.expire(key,timeout);
                }
                Thread.sleep(1000);

            }


        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }

    public boolean releaseLock(String key, String value){

        try {
            Jedis jedis=RedisManager.getJedis();
            while(true) {
                jedis.watch(key);  //watch
                if (value.equals(jedis.get(key))) { //判断获得锁的线程和当前redis中存的锁是同一个
                    Transaction transaction = jedis.multi();
                    transaction.del(key);
                    List<Object> list = transaction.exec();
                    if (list == null) {
                        continue;
                    }
                    System.out.println("解锁"+key);
                    return true;
                }
                jedis.unwatch();
                break;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


        return false;
    }

    public static void main(String[] args) {
        RedisLock redisLock=new RedisLock();

        String lockId=redisLock.getLock("lock:aaa",10000);
        if(null!=lockId){
            System.out.println("获得锁成功");
        }

        String l=redisLock.getLock("lock:aaa",10000);
        if(null==l){
            System.out.println("获得锁失败");
        }
        System.out.println(l);

        redisLock.releaseLock("lock:aaa",lockId);

        String ll=redisLock.getLock("lock:aaa",10000);
        if(null!=ll){
            System.out.println("获得锁成功");
        }
        redisLock.releaseLock("lock:aaa",ll);

    }

}
