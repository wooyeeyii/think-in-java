package com.distributed.lock.redis;

import com.distributed.lock.SerializeUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RedisUtil {
    private final static Log LOGGER = LogFactory.getLog(RedisUtil.class);
    private static RedisUtil instance;
    private static Object LOCK = new Object();
    private JedisCluster cluster;


    private RedisUtil() {
        String server = "106.14.5.54:7000,106.14.5.54:7001,106.14.5.54:7002,106.14.5.54:7003,106.14.5.54:7004,106.14.5.54:7005";
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        // 最大连接数
        poolConfig.setMaxTotal(300);
        // 最大空闲数
        poolConfig.setMaxIdle(2);
        // 最大允许等待时间，如果超过这个时间还未获取到连接，则会报JedisException异常：
        // Could not get a resource from the pool
        poolConfig.setMaxWaitMillis(1000);

        if (cluster == null && StringUtils.isNotEmpty(server)) {
            Set<HostAndPort> clusterNodes = new HashSet<HostAndPort>();
            String[] hostPort = server.split(",");
            for (String ip : hostPort) {
                String[] split = ip.split(":");
                clusterNodes.add(new HostAndPort(split[0], Integer.parseInt(split[1])));
            }
            cluster = new JedisCluster(clusterNodes, poolConfig);
        }
    }

    public static RedisUtil getInstance() {
        if (instance == null) {
            synchronized (LOCK) {
                if (instance == null) {
                    instance = new RedisUtil();
                }
            }
        }
        return instance;
    }

    /**
     * <p>获取jedis客户端</p>
     * <p>调用redis方法，异常不被捕获</p>
     */
    public JedisCluster getCluster() {
        return cluster;
    }


    /**
     * <p>通过key获取储存在redis中的value</p>
     * <p>并释放连接</p>
     *
     * @param key
     * @return 成功返回value 失败返回null
     */
    public String get(String key) {
        String value = null;
        try {
            value = cluster.get(key);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return value;
    }

    public Object getO(String key) {
        Object value = null;
        try {
            String data = cluster.get(key);
            if (StringUtils.isEmpty(data)) return null;
            value = SerializeUtil.unserialize(data.getBytes("ISO-8859-1"));
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        }
        return value;
    }

    /**
     * <p>通过key获取储存在redis中的list的长度</p>
     * <p>并释放连接</p>
     *
     * @param key
     * @return list长度
     */
    public Long llen(String key) {
        Long len = null;
        try {
            len = cluster.llen(key);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return len;
    }


    public Long expire(String key, int seconds) {
        try {
            return cluster.expire(key, seconds);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return null;
        }
    }

    /**
     * <p>向redis存入key和value,并释放连接资源，如果存入的值是object类型,获取对象时请用getO方法获取对象</p>
     * <p>如果key已经存在 则覆盖</p>
     *
     * @param key
     * @param value
     * @return 成功 返回OK 失败返回 0
     */
    public String set(String key, String value) {
        try {
            return cluster.set(key, value);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return "0";
        }
    }

    public String setO(String key, Object value) {
        try {
            byte[] serialize = SerializeUtil.serialize(value);
            return cluster.set(key, new String(serialize, "ISO-8859-1"));
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return "0";
        }
    }

    /**
     * <p>删除指定的key</p>
     *
     * @param key 一个key  也可以使 string 数组
     * @return 返回删除成功数
     */
    public Long del(String key) {
        try {
            return cluster.del(key);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return 0L;
        }
    }

    /**
     * <p>通过key向指定的value值追加值</p>
     *
     * @param key
     * @param str
     * @return 成功返回 添加后value的长度 失败 返回 添加的 value 的长度  异常返回0L
     */
    public Long append(String key, String str) {
        Long res = null;
        try {
            res = cluster.append(key, str);
        } catch (Exception e) {

            LOGGER.error(e.getMessage());
            return 0L;
        }
        return res;
    }

    /**
     * <p>判断key是否存在</p>
     *
     * @param key
     * @return true OR false
     */
    public Boolean exists(String key) {
        try {
            return cluster.exists(key);
        } catch (Exception e) {

            LOGGER.error(e.getMessage());
            return false;
        }
    }

    /**
     * <p>设置key value,如果key已经存在则返回0,nx==> not exist</p>
     *
     * @param key
     * @param value
     * @return 成功返回1 如果存在 和 发生异常 返回 0
     */
    public Long setnx(String key, String value) {
        try {
            return cluster.setnx(key, value);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return 0L;
        }
    }

    public Long setnxO(String key, Object value) {
        try {
            byte[] serialize = SerializeUtil.serialize(value);
            return cluster.setnx(key, new String(serialize, "ISO-8859-1"));
        } catch (Exception e) {

            LOGGER.error(e.getMessage());
            return 0l;
        }
    }


    /**
     * <p>设置key value并制定这个键值的有效期</p>
     *
     * @param key
     * @param value
     * @param seconds 单位:秒
     * @return 成功返回OK 失败和异常返回null
     */
    public String setex(String key, String value, int seconds) {
        String res = null;
        try {
            res = cluster.setex(key, seconds, value);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return res;
    }

    public String setexO(String key, Object value, int seconds) {
        try {
            byte[] serialize = SerializeUtil.serialize(value);
            return cluster.setex(key, seconds, new String(serialize, "ISO-8859-1"));
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return null;
        }
    }


    /**
     * <p>通过key 和offset 从指定的位置开始将原先value替换</p>
     * <p>下标从0开始,offset表示从offset下标开始替换</p>
     * <p>如果替换的字符串长度过小则会这样</p>
     * <p>example:</p>
     * <p>value : bigsea@zto.cn</p>
     * <p>str : abc </p>
     * <P>从下标7开始替换  则结果为</p>
     * <p>RES : bigsea.abc.cn</p>
     *
     * @param key
     * @param str
     * @param offset 下标位置
     * @return 返回替换后  value 的长度
     */
    public Long setrange(String key, String str, int offset) {
        try {
            return cluster.setrange(key, offset, str);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return 0L;
        }
    }


    /**
     * <p>设置key的值,并返回一个旧值</p>
     *
     * @param key
     * @param value
     * @return 旧值 如果key不存在 则返回null
     */
    public String getset(String key, String value) {
        String res = null;
        try {
            res = cluster.getSet(key, value);
        } catch (Exception e) {

            LOGGER.error(e.getMessage());
        }
        return res;
    }

    /**
     * <p>通过下标 和key 获取指定下标位置的 value</p>
     *
     * @param key
     * @param startOffset 开始位置 从0 开始 负数表示从右边开始截取
     * @param endOffset
     * @return 如果没有返回null
     */
    public String getrange(String key, int startOffset, int endOffset) {
        String res = null;
        try {
            res = cluster.getrange(key, startOffset, endOffset);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return res;
    }

    /**
     * <p>通过key 对value进行加值+1操作,当value不是int类型时会返回错误,当key不存在是则value为1</p>
     *
     * @param key
     * @return 加值后的结果
     */
    public Long incr(String key) {
        Long res = null;
        try {
            res = cluster.incr(key);
        } catch (Exception e) {

            LOGGER.error(e.getMessage());
        }
        return res;
    }

    /**
     * <p>通过key给指定的value加值,如果key不存在,则这是value为该值</p>
     *
     * @param key
     * @param integer
     * @return
     */
    public Long incrBy(String key, Long integer) {
        Long res = null;
        try {
            res = cluster.incrBy(key, integer);
        } catch (Exception e) {

            LOGGER.error(e.getMessage());
        }
        return res;
    }

    /**
     * <p>对key的值做减减操作,如果key不存在,则设置key为-1</p>
     *
     * @param key
     * @return
     */
    public Long decr(String key) {
        Long res = null;
        try {
            res = cluster.decr(key);
        } catch (Exception e) {

            LOGGER.error(e.getMessage());
        }
        return res;
    }

    /**
     * <p>减去指定的值</p>
     *
     * @param key
     * @param integer
     * @return
     */
    public Long decrBy(String key, Long integer) {
        Long res = null;
        try {
            res = cluster.decrBy(key, integer);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return res;
    }

    /**
     * <p>通过key获取value值的长度</p>
     *
     * @param key
     * @return 失败返回null
     */
    public Long serlen(String key) {
        Long res = null;
        try {
            res = cluster.strlen(key);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return res;
    }

    /**
     * <p>通过key给field设置指定的值,如果key不存在,则先创建</p>
     *
     * @param key
     * @param field 字段
     * @param value
     * @return 如果存在返回0 异常返回null
     */
    public Long hset(String key, String field, String value) {
        Long res = null;
        try {
            res = cluster.hset(key, field, value);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return res;
    }

    /**
     * <p>通过key给field设置指定的值,如果key不存在则先创建,如果field已经存在,返回0</p>
     *
     * @param key
     * @param field
     * @param value
     * @return
     */
    public Long hsetnx(String key, String field, String value) {
        Long res = null;
        try {
            res = cluster.hsetnx(key, field, value);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return res;
    }

    /**
     * <p>通过key同时设置 hash的多个field</p>
     *
     * @param key
     * @param hash
     * @return 返回OK 异常返回null
     */
    public String hmset(String key, Map<String, String> hash) {
        String res = null;
        try {
            res = cluster.hmset(key, hash);
        } catch (Exception e) {

            LOGGER.error(e.getMessage());
        }
        return res;
    }

    /**
     * <p>通过key 和 field 获取指定的 value</p>
     *
     * @param key
     * @param field
     * @return 没有返回null
     */
    public String hget(String key, String field) {
        String res = null;
        try {
            res = cluster.hget(key, field);
        } catch (Exception e) {

            LOGGER.error(e.getMessage());
        }
        return res;
    }

    /**
     * <p>通过key 和 fields 获取指定的value 如果没有对应的value则返回null</p>
     *
     * @param key
     * @param fields 可以使 一个String 也可以是 String数组
     * @return
     */
    public List<String> hmget(String key, String... fields) {
        List<String> res = null;
        try {
            res = cluster.hmget(key, fields);
        } catch (Exception e) {

            LOGGER.error(e.getMessage());
        }
        return res;
    }

    /**
     * <p>通过key给指定的field的value加上给定的值</p>
     *
     * @param key
     * @param field
     * @param value
     * @return
     */
    public Long hincrby(String key, String field, Long value) {
        Long res = null;
        try {
            res = cluster.hincrBy(key, field, value);
        } catch (Exception e) {

            LOGGER.error(e.getMessage());
        }
        return res;
    }


    /**
     * <p>通过key 删除指定的 field </p>
     *
     * @param key
     * @param fields 可以是 一个 field 也可以是 一个数组
     * @return
     */
    public Long hdel(String key, String... fields) {
        Long res = null;
        try {
            res = cluster.hdel(key, fields);
        } catch (Exception e) {

            LOGGER.error(e.getMessage());
        }
        return res;
    }

    /**
     * <p>通过key返回所有的field</p>
     *
     * @param key
     * @return
     */
    public Set<String> hkeys(String key) {
        Set<String> res = null;
        try {
            res = cluster.hkeys(key);
        } catch (Exception e) {

            LOGGER.error(e.getMessage());
        }
        return res;
    }

    /**
     * <p>通过key返回所有和key有关的value</p>
     *
     * @param key
     * @return
     */
    public List<String> hvals(String key) {
        List<String> res = null;
        try {
            res = cluster.hvals(key);
        } catch (Exception e) {

            LOGGER.error(e.getMessage());
        }
        return res;
    }

    /**
     * <p>通过key获取所有的field和value</p>
     *
     * @param key
     * @return
     */
    public Map<String, String> hgetall(String key) {
        Map<String, String> res = null;
        try {
            res = cluster.hgetAll(key);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return res;
    }

    /**
     * <p>通过key向list头部添加字符串</p>
     *
     * @param key
     * @param strs 可以使一个string 也可以使string数组
     * @return 返回list的value个数
     */
    public Long lpush(String key, String... strs) {
        Long res = null;
        try {
            res = cluster.lpush(key, strs);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return res;
    }

    /**
     * <p>通过key向list尾部添加字符串</p>
     *
     * @param key
     * @param strs 可以使一个string 也可以使string数组
     * @return 返回list的value个数
     */
    public Long rpush(String key, String... strs) {
        Long res = null;
        try {
            res = cluster.rpush(key, strs);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return res;
    }

    /**
     * <p>通过key设置list指定下标位置的value</p>
     * <p>如果下标超过list里面value的个数则报错</p>
     *
     * @param key
     * @param index 从0开始
     * @param value
     * @return 成功返回OK
     */
    public String lset(String key, Long index, String value) {
        String res = null;
        try {
            res = cluster.lset(key, index, value);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }

        return res;
    }

    /**
     * <p>通过key从对应的list中删除指定的count个 和 value相同的元素</p>
     *
     * @param key
     * @param count 当count为0时删除全部
     * @param value
     * @return 返回被删除的个数
     */
    public Long lrem(String key, long count, String value) {
        Long res = null;
        try {
            res = cluster.lrem(key, count, value);
        } catch (Exception e) {

            LOGGER.error(e.getMessage());
        }
        return res;
    }

    /**
     * <p>通过key保留list中从strat下标开始到end下标结束的value值</p>
     *
     * @param key
     * @param start
     * @param end
     * @return 成功返回OK
     */
    public String ltrim(String key, long start, long end) {
        String res = null;
        try {
            res = cluster.ltrim(key, start, end);
        } catch (Exception e) {

            LOGGER.error(e.getMessage());
        }
        return res;
    }


    /**
     * <p>通过key从list尾部删除一个value,并返回该元素</p>
     *
     * @param key
     * @return
     */
    synchronized public String rpop(String key) {
        String res = null;
        try {
            res = cluster.rpop(key);
        } catch (Exception e) {

            LOGGER.error(e.getMessage());
        }
        return res;
    }


    /**
     * <p>通过key获取list中指定下标位置的value</p>
     *
     * @param key
     * @param index
     * @return 如果没有返回null
     */
    public String lindex(String key, long index) {
        String res = null;
        try {
            res = cluster.lindex(key, index);
        } catch (Exception e) {

            LOGGER.error(e.getMessage());
        }
        return res;
    }


    /**
     * <p>通过key向指定的set中添加value</p>
     *
     * @param key
     * @param members 可以是一个String 也可以是一个String数组
     * @return 添加成功的个数
     */
    public Long sadd(String key, String... members) {
        Long res = null;
        try {
            res = cluster.sadd(key, members);
        } catch (Exception e) {

            LOGGER.error(e.getMessage());
        }
        return res;
    }

    /**
     * <p>通过key删除set中对应的value值</p>
     *
     * @param key
     * @param members 可以是一个String 也可以是一个String数组
     * @return 删除的个数
     */
    public Long srem(String key, String... members) {
        Long res = null;
        try {
            res = cluster.srem(key, members);
        } catch (Exception e) {

            LOGGER.error(e.getMessage());
        }
        return res;
    }

    /**
     * <p>通过key随机删除一个set中的value并返回该值</p>
     *
     * @param key
     * @return
     */
    public String spop(String key) {
        String res = null;
        try {
            res = cluster.spop(key);
        } catch (Exception e) {

            LOGGER.error(e.getMessage());
        }
        return res;
    }


    /**
     * <p>通过key获取set中value的个数</p>
     *
     * @param key
     * @return
     */
    public Long scard(String key) {
        Long res = null;
        try {
            res = cluster.scard(key);
        } catch (Exception e) {

            LOGGER.error(e.getMessage());
        }
        return res;
    }

    /**
     * <p>通过key判断value是否是set中的元素</p>
     *
     * @param key
     * @param member
     * @return
     */
    public Boolean sismember(String key, String member) {
        Boolean res = null;
        try {
            res = cluster.sismember(key, member);
        } catch (Exception e) {

            LOGGER.error(e.getMessage());
        }
        return res;
    }

    /**
     * <p>通过key获取set中随机的value,不删除元素</p>
     *
     * @param key
     * @return
     */
    public String srandmember(String key) {
        String res = null;
        try {
            res = cluster.srandmember(key);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return res;
    }

    /**
     * <p>通过key获取set中所有的value</p>
     *
     * @param key
     * @return
     */
    public Set<String> smembers(String key) {
        Set<String> res = null;
        try {
            res = cluster.smembers(key);
        } catch (Exception e) {

            LOGGER.error(e.getMessage());
        }
        return res;
    }


    /**
     * <p>通过key向zset中添加value,score,其中score就是用来排序的</p>
     * <p>如果该value已经存在则根据score更新元素</p>
     *
     * @param key
     * @param score
     * @param member
     * @return
     */
    public Long zadd(String key, double score, String member) {
        Long res = null;
        try {
            res = cluster.zadd(key, score, member);
        } catch (Exception e) {

            LOGGER.error(e.getMessage());
        }
        return res;
    }

    /**
     * <p>通过key删除在zset中指定的value</p>
     *
     * @param key
     * @param members 可以使一个string 也可以是一个string数组
     * @return
     */
    public Long zrem(String key, String... members) {
        Long res = null;
        try {
            res = cluster.zrem(key, members);
        } catch (Exception e) {

            LOGGER.error(e.getMessage());
        }
        return res;
    }

    /**
     * <p>通过key增加该zset中value的score的值</p>
     *
     * @param key
     * @param score
     * @param member
     * @return
     */
    public Double zincrby(String key, double score, String member) {
        Double res = null;
        try {
            res = cluster.zincrby(key, score, member);
        } catch (Exception e) {

            LOGGER.error(e.getMessage());
        }
        return res;
    }

    /**
     * <p>通过key返回zset中value的排名</p>
     * <p>下标从小到大排序</p>
     *
     * @param key
     * @param member
     * @return
     */
    public Long zrank(String key, String member) {
        Long res = null;
        try {
            res = cluster.zrank(key, member);
        } catch (Exception e) {

            LOGGER.error(e.getMessage());
        }
        return res;
    }

    /**
     * <p>通过key返回zset中value的排名</p>
     * <p>下标从大到小排序</p>
     *
     * @param key
     * @param member
     * @return
     */
    public Long zrevrank(String key, String member) {
        Long res = null;
        try {
            res = cluster.zrevrank(key, member);
        } catch (Exception e) {

            LOGGER.error(e.getMessage());
        }
        return res;
    }

    /**
     * <p>通过key将获取score从start到end中zset的value</p>
     * <p>socre从大到小排序</p>
     * <p>当start为0 end为-1时返回全部</p>
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public Set<String> zrevrange(String key, long start, long end) {
        Set<String> res = null;
        try {
            res = cluster.zrevrange(key, start, end);
        } catch (Exception e) {

            LOGGER.error(e.getMessage());
        }
        return res;
    }

    /**
     * <p>通过key返回指定score内zset中的value</p>
     *
     * @param key
     * @param max
     * @param min
     * @return
     */
    public Set<String> zrangebyscore(String key, String max, String min) {
        Set<String> res = null;
        try {
            res = cluster.zrevrangeByScore(key, max, min);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return res;
    }

    /**
     * <p>通过key返回指定score内zset中的value</p>
     *
     * @param key
     * @param max
     * @param min
     * @return
     */
    public Set<String> zrangeByScore(String key, double max, double min) {
        Set<String> res = null;
        try {
            res = cluster.zrevrangeByScore(key, max, min);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return res;
    }

    /**
     * <p>返回指定区间内zset中value的数量</p>
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    public Long zcount(String key, String min, String max) {
        Long res = null;
        try {
            res = cluster.zcount(key, min, max);
        } catch (Exception e) {

            LOGGER.error(e.getMessage());
        }
        return res;
    }

    /**
     * <p>通过key返回zset中的value个数</p>
     *
     * @param key
     * @return
     */
    public Long zcard(String key) {
        Long res = null;
        try {
            res = cluster.zcard(key);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return res;
    }

    /**
     * <p>通过key获取zset中value的score值</p>
     *
     * @param key
     * @param member
     * @return
     */
    public Double zscore(String key, String member) {
        Double res = null;
        try {
            res = cluster.zscore(key, member);
        } catch (Exception e) {

            LOGGER.error(e.getMessage());
        }
        return res;
    }

    /**
     * <p>通过key删除给定区间内的元素</p>
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public Long zremrangeByRank(String key, long start, long end) {
        Long res = null;
        try {
            res = cluster.zremrangeByRank(key, start, end);
        } catch (Exception e) {

            LOGGER.error(e.getMessage());
        }
        return res;
    }

    /**
     * <p>通过key删除指定score内的元素</p>
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public Long zremrangeByScore(String key, double start, double end) {
        Long res = null;
        try {
            res = cluster.zremrangeByScore(key, start, end);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return res;
    }

    /**
     * <p>通过key判断值得类型</p>
     *
     * @param key
     * @return
     */
    public String type(String key) {
        String res = null;
        try {
            res = cluster.type(key);
        } catch (Exception e) {

            LOGGER.error(e.getMessage());
        }
        return res;
    }

}


