package liuzc.dynamicDatasource.util.dynamicDatasource;

/**
 * 线程上下文类
 * @author liuzongchang
 * @version 1.0  2017/6/8 16:58
 */

public class DbContextHolder {
	private static final ThreadLocal contextHolder = new ThreadLocal();

	public static void setDbType(String dbType) {
		contextHolder.set(dbType);
	}

	public static String getDbType() {
		return (String) contextHolder.get();
	}

	public static void clearDbType() {
		contextHolder.remove();
	}
}

