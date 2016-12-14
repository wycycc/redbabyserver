package com.ycc.redbabyserver.factory;

import com.ycc.redbabyserver.utils.ConfigUtil;

public class BasicFactory {
	private static BasicFactory factory = new BasicFactory();

	private BasicFactory() {
	}

	public static BasicFactory getFactory() {
		return factory;
	}

	public static <T> T getInstance(Class<T> clazz) {
		try {
			String name = clazz.getSimpleName();
			String implClazzStr = ConfigUtil.getProp(name);
//			System.out.println(implClazzStr);
			return (T) Class.forName(implClazzStr).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
