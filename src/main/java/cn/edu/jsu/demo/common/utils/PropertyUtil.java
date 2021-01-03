package cn.edu.jsu.demo.common.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * 配置文件读取工具类
 */
public class PropertyUtil {

  private PropertyUtil() {
    //nothing
  }

  private static Properties applicationProps;
  private static Properties jdbcProps;

  private static final String APPLICATION_PROPERTIES="application.properties";

  private static final String JDBC_PROPERTIES="jdbc.properties";

  /**
   * 加载配置文件
   * @param propertiesFileName 配置文件名
   * @return 配置对象
   */
  public static synchronized Properties loadProps(String propertiesFileName) {
    Properties properties = null;
    InputStream in = null;
    //todo
    return properties;
  }

  /**
   * 获取应用配置信息
   * @param key 配置信息头
   * @return 应用配置信息
   */
  public static String getApplicationProperty(String key) {
    if (null == applicationProps) {
      applicationProps = loadProps(APPLICATION_PROPERTIES);
    }
    return applicationProps.getProperty(key);
  }

  /**
   * 获取jdbc连接信息
   * @param key 配置信息头
   * @return 连接信息
   */
  public static String getJdbcProperty(String key) {
    if (null == jdbcProps) {
      jdbcProps = loadProps(JDBC_PROPERTIES);
    }
    return jdbcProps.getProperty(key);
  }
}