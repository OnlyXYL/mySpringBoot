package com.bmsmart.spring.boot.springboot.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertiesFactoryBean;

import javax.annotation.Resource;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Desc:properties文件获取工具类 Created by yangcao
 */
public class MessageUtil {
    private static final Logger logger = LoggerFactory.getLogger(MessageUtil.class);
    private static Properties props;
    private static Map<String, String> map;
    private String lineConfigTxt;
    public BufferedReader br = null;
    private Properties config = null;


    @Resource
    private static PropertiesFactoryBean configProperties;

    public static PropertiesFactoryBean getConfigProperties() {
        return configProperties;
    }

    public static void loadProps() {
        logger.info("开始加载properties文件内容.......");
        map = new HashMap<>();
        props = new Properties();
        InputStreamReader in = null;
        try {
            in = new InputStreamReader(MessageUtil.class.getClassLoader().getResourceAsStream("message.properties"), "UTF-8");
             /*	in = new InputStreamReader(PropertyUtil.class.getClassLoader().getResourceAsStream("system.properties"),
                         "UTF-8");*/
            // 第二种，通过类进行获取properties文件流
            // in = PropertyUtil.class.getResourceAsStream("/jdbc.properties");
            props.load(in);
            Enumeration en = props.propertyNames();
            while (en.hasMoreElements()) {
                String key = (String) en.nextElement();
                String property = props.getProperty(key);
                map.put(key, property);
            }

        } catch (FileNotFoundException e) {
            logger.error("message.properties文件未找到");
        } catch (IOException e) {
            logger.error("出现IOException");
        } finally {
            try {
                if (null != in) {
                    in.close();
                }
            } catch (IOException e) {
                logger.error("message.properties文件流关闭出现异常");
            }
        }
        logger.info("加载properties文件内容完成...........");
        logger.info("properties文件内容：" + props);
    }

    public static String getProperty(String key) {
        if (null == props && null == map) {
            loadProps();
        }
        return map.get(key);
    }

    public static String getProperty(String key, String defaultValue) {
        if (null == props && null == map) {
            loadProps();
        }
        return props.getProperty(key, defaultValue);
    }

    /****
     * 用值填充属性文件中的占位符{0},{1}...,值的顺序必须和参数的顺序是一致的
     *
     * @param key
     *            属性文件中的键值
     * @param values
     *            对应属性文件中的占位符的信息
     * @return 将占位符中的信息对应填充后的字符串
     */
    public static String getProperty(String key, String... values) {
        // 对应占位符参数值
        String[] vs = values;
        // 属性文件中的值
        String v = getProperty(key);

        // 如果没有参数
        if (vs == null || vs.length == 0) {
            return getProperty(key);
        }

        // 如果属性文件中没有值,则返回空字符串
        if (v == null) {
            return "";
        }

        StringBuffer buffer = new StringBuffer();

        // 遍历参数数组
        for (int i = 0; i < vs.length; i++) {
            // 替换前清空原有替换值
            buffer.delete(0, buffer.length());
            Pattern pattern = Pattern.compile("\\{" + i + "\\}");
            Matcher matcher = pattern.matcher(v);
            while (matcher.find()) {
                matcher.appendReplacement(buffer, vs[i]);
            }
            matcher.appendTail(buffer);
            // 进行下一次替换
            v = buffer.toString();
        }
        // 返回后替换的字符串
        return buffer.toString();
    }

    /**
     * <pre>
     * 此时的configFilePath若是非普通文件，即properties文件的话，要另行处理
     * @param configFilePath
     * @param isConfig
     * @param encoding
     */
    public MessageUtil(String configFilePath, boolean isConfig, String encoding) {
        InputStream in = null;
        in = MessageUtil.class.getClassLoader().getResourceAsStream(configFilePath);
        try {
            if (isConfig) {
                config = new Properties();
                config.load(in);
                in.close();
            } else {
                br = new BufferedReader(new InputStreamReader(in, encoding));
                this.lineConfigTxt = getTextLines(br);
            }
        } catch (IOException e) {
            logger.error("读取配置文件异常: {}", e.getMessage());
        }
    }

    // 测试方法
    public static void main(String[] args) {
        System.out.println(getProperty("系统管理"));
    }

    public String getLineConfigTxt() {
        return lineConfigTxt;
    }

    public void setLineConfigTxt(String lineConfigTxt) {
        this.lineConfigTxt = lineConfigTxt;
    }

    /**
     * <pre>
     * <p>Description:  读取text文本内容</p>
     * @author wusong
     * @date 2016年8月23日上午11:08:51
     * @return String
     * @return
     */
    private String getTextLines(BufferedReader br) {
        StringBuilder sb = new StringBuilder();
        String temp = null;
        try {
            while ((temp = br.readLine()) != null) {
                if (temp.trim().length() > 0 && (!temp.trim().startsWith("#"))) {
                    sb.append(temp);
                    sb.append("\n");
                }
            }
            br.close();
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("读取配置文件异常: {}", e.getMessage());
        }
        return sb.toString();
    }

    /**
     * <pre>
     * <p>Description:  获取属性文件中的值</p>
     * @author wusong
     * @date 2016年8月23日上午11:09:07
     * @return String
     * @param key
     * @return
     */
    public String getValue(String key) {
        try {
            String value = config.getProperty(key);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取值出现异常: {}", e.getMessage());
            return null;
        }
    }

}