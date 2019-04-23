package com.dliyun.platform.common.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class HostInfoUtil {
	public static void main(String[] args) {
		HostInfoUtil hostInfo = new HostInfoUtil();
//		System.out.println(hostInfo);
	}

	private final String HOST_NAME;
	private final String HOST_ADDRESS;

	/**
	 * 防止从外界创建此对象。
	 */
	public HostInfoUtil() {
		String hostName;
		String hostAddress;

		try {
			InetAddress localhost = InetAddress.getLocalHost();

			hostName = localhost.getHostName();
			hostAddress = localhost.getHostAddress();
		} catch (UnknownHostException e) {
			hostName = "localhost";
			hostAddress = "127.0.0.1";
		}

		HOST_NAME = hostName;
		HOST_ADDRESS = hostAddress;
	}

	/**
	 * 取得当前主机的名称。
	 * 
	 * <p>
	 * 例如：<code>"webserver1"</code>
	 * </p>
	 *
	 * @return 主机名
	 */
	public final String getName() {
		return HOST_NAME;
	}

	/**
	 * 取得当前主机的地址。
	 * 
	 * <p>
	 * 例如：<code>"192.168.0.1"</code>
	 * </p>
	 *
	 * @return 主机地址
	 */
	public final String getAddress() {
		return HOST_ADDRESS;
	}

	/**
	 * 将当前主机的信息转换成字符串。
	 *
	 * @return 主机信息的字符串表示
	 */
	@Override
	public final String toString() {
		return getName() + "/" + getAddress();
	}

}