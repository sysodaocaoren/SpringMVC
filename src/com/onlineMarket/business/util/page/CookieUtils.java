package com.onlineMarket.business.util.page;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cookie宸ュ叿绫�
 * @author ThinkGem
 * @version 2013-01-15
 */
public class CookieUtils {

	/**
	 * 璁剧疆 Cookie锛堢敓鎴愭椂闂翠负1澶╋級
	 * @param name 鍚嶇О
	 * @param value 鍊�
	 */
	public static void setCookie(HttpServletResponse response, String name, String value) {
		setCookie(response, name, value, 60*60*24);
	}
	
	/**
	 * 璁剧疆 Cookie
	 * @param name 鍚嶇О
	 * @param value 鍊�
	 * @param maxAge 鐢熷瓨鏃堕棿锛堝崟浣嶇锛�
	 * @param uri 璺緞
	 */
	public static void setCookie(HttpServletResponse response, String name, String value, int maxAge) {
		Cookie cookie = new Cookie(name, null);
		cookie.setPath("/");
		cookie.setMaxAge(maxAge);
		try {
			cookie.setValue(URLEncoder.encode(value, "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		response.addCookie(cookie);
	}
	/**
	 * 鑾峰緱鎸囧畾Cookie鐨勫�
	 * @param name 鍚嶇О
	 * @return 鍊�
	 */
	public static String getCookie(HttpServletRequest request, String name) {
		return getCookie(request, null, name, false);
	}
	/**
	 * 鑾峰緱鎸囧畾Cookie鐨勫�锛屽苟鍒犻櫎銆�
	 * @param name 鍚嶇О
	 * @return 鍊�
	 */
	public static String getCookie(HttpServletRequest request, HttpServletResponse response, String name) {
		return getCookie(request, response, name, true);
	}
	/**
	 * 鑾峰緱鎸囧畾Cookie鐨勫�
	 * @param request 璇锋眰瀵硅薄
	 * @param response 鍝嶅簲瀵硅薄
	 * @param name 鍚嶅瓧
	 * @param isRemove 鏄惁绉婚櫎
	 * @return 鍊�
	 */
	public static String getCookie(HttpServletRequest request, HttpServletResponse response, String name, boolean isRemove) {
		String value = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(name)) {
					try {
						value = URLDecoder.decode(cookie.getValue(), "utf-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					if (isRemove) {
						cookie.setMaxAge(0);
						response.addCookie(cookie);
					}
				}
			}
		}
		return value;
	}
}
