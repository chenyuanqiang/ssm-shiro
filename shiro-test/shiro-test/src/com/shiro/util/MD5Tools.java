package com.shiro.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MD5Tools {

	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	public static String encode(String txt) {
		try {
			return encodeByMD5(encodeByMD5(encodeByMD5(txt) + txt) + txt);
		} catch (Exception ex) {
			return null;
		}
	}

	

	public static String encodeByMD5(String originString) throws NoSuchAlgorithmException {
		if (originString != null) {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] results = md.digest(originString.getBytes());
			String resultString = byteArrayToHexString(results);
			return resultString;
		}
		return null;
	}

	private static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}
	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}
	public static void main(String[] args) {
		try {
		String pass=MD5Tools.encodeByMD5("1234");
		System.out.println(pass);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
