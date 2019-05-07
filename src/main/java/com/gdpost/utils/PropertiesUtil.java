package com.gdpost.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 用完美的单例模式获取properties的数据，加载为map
 * @author forever
 *
 */
public class PropertiesUtil {
	//值可变，引用不可变
	private static final Properties PROPERTIES =new Properties();
	static{
		initProperties();
	}
	/**
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public static String get(String key,String defaultValue){
		if(PROPERTIES.isEmpty()) {
            throw new UnsupportedOperationException("配置未加载");
        }
        String value =PROPERTIES.getProperty(key, defaultValue);
        return  value;
	}
	/**
	 * 获取默认配置的值，这个值可以动态修改
	 * @param key
	 * @return
	 */
	public static String get(String key){
		return get(key, "");
	}
	private static void initProperties(){
		 InputStream is =null;
	     try {
	         //获取当前目录
			 String property = System.getProperty("user.dir");
			 //默认是linux os
			 String fileName = "/app.properties";
			 //判断是否是windows os
			 if(System.getProperty ("os.name").contains("Windows")) {
				 fileName = "\\app.properties";
			 }
			 // 读取当前目录下conf配置文件
			 File file = new File(property+fileName);
	         PROPERTIES.clear();
	         is = new FileInputStream(file);
	         PROPERTIES.load(is);
	     }catch (IOException e) {
	          e.printStackTrace();
	     }finally {
			if(is!=null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		 }
	}
}
