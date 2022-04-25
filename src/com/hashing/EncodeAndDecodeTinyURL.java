/**
 * https://leetcode.com/problems/encode-and-decode-tinyurl/
 */
package com.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * @author satis
 *
 */
public class EncodeAndDecodeTinyURL {

	static final String BASE_URL = "http://tinyurl.com/";
	static final String CHAR_SET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static Map<String, String> url2code;
	static Map<String, String> code2url;

	static {
		url2code = new HashMap<>();
		code2url = new HashMap<>();
	}
	
	public EncodeAndDecodeTinyURL() {
	}

	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		// if url already shortened, avoid duplicates.
		if (url2code.containsKey(longUrl))
			return url2code.get(longUrl);
		StringBuilder uri;
		do {
			uri = new StringBuilder();
			for (int i = 0; i < 6; i++) {
				uri.append(CHAR_SET.charAt((int) (Math.random() * CHAR_SET.length())));
			}
		} while (code2url.containsKey(uri.toString()));

		String code = uri.toString();
		url2code.put(longUrl, code);
		code2url.put(code, longUrl);
		return BASE_URL + code;
	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		// here it is guaranteed that url is already encoded
		return code2url.get(shortUrl.replace(BASE_URL, ""));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String url1 = "https://leetcode.com/problems/encode-and-decode-tinyurl/";
		String url2 = "https://leetcode.com/problems/minimum-jumps-to-reach-home/discuss/936440/JavaPython-3-BFS-clean-codes-w-brief-explanation-and-analysis.";
		EncodeAndDecodeTinyURL coder = new EncodeAndDecodeTinyURL();
		System.out.println(coder.encode(url1));
		System.out.println(coder.encode(url2));
		System.out.println(code2url);
		System.out.println(url2code);
		
	}

}
