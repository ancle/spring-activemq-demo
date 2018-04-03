package com.demo.spring.cache;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;

public class RedisCache implements Cache {
	
	private RedisTemplate<String, Object> redisTemplate;
	private String name;
	
	public RedisTemplate<String, Object> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public Object getNativeCache() {
		return this.redisTemplate;
	}

	@Override
	public ValueWrapper get(Object key) {
		System.out.println("---- 读取缓存（" + key.toString() + "） ----");
		final String keyStr = key.toString();
		
		if (StringUtils.isEmpty(keyStr)) {
			return null;
		}
		
		Object result = redisTemplate.execute(new RedisCallback<Object>(){

			@Override
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				byte[] value = connection.get(keyStr.getBytes());
				
				if (null == value) {
					System.out.println("---- 缓存(" + key + ")不存在");
					return null;
				}
				
				return toObject(value);
			}
		});
		
		return (result == null? null : new SimpleValueWrapper(result));
	}
	
	private Object toObject(byte[] value) {
		Object result = null;
		
		ByteArrayInputStream bis = null;
		ObjectInputStream ois = null;
		try {
			bis = new ByteArrayInputStream(value);
			ois = new ObjectInputStream(bis);
			result = ois.readObject();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if (null != bis) {
				try {
					bis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (null != ois) {
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T get(Object key, Class<T> type) {
		
		System.out.println("---- 读取缓存（" + key.toString() + ") ----");
		
		if (StringUtils.isEmpty(key) || null == type) {
			return null;
		}
		
		final String keyStr;
		final Class<T> classType = type;
		
		if (key instanceof String) {
			keyStr = (String) key;
		} else {
			keyStr = key.toString();
		}
		
		final Object result = redisTemplate.execute(new RedisCallback<Object>() {

			@Override
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				byte[] keyBytes = keyStr.getBytes();
				byte[] valueBytes = connection.get(keyBytes);
				
				if (null == valueBytes) {
					return null;
				}
				
				return toObject(valueBytes);
			}
			
		});
		
		if (null != result && classType.isInstance(result)) {
			return (T)result;
		}
		
		return null;
	}

	@Override
	public void put(Object key, Object value) {
		System.out.println("---- 更新缓存（" + key.toString() + "）----");
		
		final String keyStr = key.toString();
		final Object valueRef = value;
		final long liveTime = 86400L;
		
		if (StringUtils.isEmpty(keyStr) || StringUtils.isEmpty(valueRef)) {
			return;
		}
		
		redisTemplate.execute(new RedisCallback<Object>() {

			@Override
			public Long doInRedis(RedisConnection connection) throws DataAccessException {
				byte[] keyBytes = keyStr.getBytes();
				byte[] valueBytes = toByteArray(valueRef);
				
				connection.set(keyBytes, valueBytes);
				
				if (liveTime > 0) {
					connection.expire(keyBytes, liveTime);
				}
				
				return 1L;
			}

			private byte[] toByteArray(Object value) {
				byte[] valBytes = null;
				ByteArrayOutputStream bos = null;
				ObjectOutputStream oos = null;
				try {
					bos = new ByteArrayOutputStream();
					oos = new ObjectOutputStream(bos);
					oos.writeObject(value);
					oos.flush();
					valBytes = bos.toByteArray();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if (null != bos) {
						try {
							bos.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					if (null != oos) {
						try {
							oos.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				return valBytes;
			}
			
		});
	}

	@Override
	public ValueWrapper putIfAbsent(Object key, Object value) {
		return null;
	}

	@Override
	public void evict(Object key) {
		System.out.println("----- 清除缓存(key=" + key.toString() + ") -----");
		
		final String keyStr = key.toString();
		
		if (StringUtils.isEmpty(keyStr)) {
			return;
		}
		
		redisTemplate.execute(new RedisCallback<String>() {

			@Override
			public String doInRedis(RedisConnection connection) throws DataAccessException {
				return connection.del(keyStr.getBytes()).toString();
			}
			
		});
	}

	@Override
	public void clear() {
		System.out.println("----- 清空缓存操作 -----");
		redisTemplate.execute(new RedisCallback<String>() {

			@Override
			public String doInRedis(RedisConnection connection) throws DataAccessException {
					connection.flushDb();
				return "OK";
			}
		});
	}

}
