package com.oj.utils;

import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class Utils {
	/**
	 * 进行MD5加密
	 */
	public static String toMD5(String data) {
		if (data == null) return null;

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(data.getBytes());
			String result = new BigInteger(1, md.digest()).toString(16);
			return result;
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}

	/**
	 * 获取随机整数
	 * @param min
	 * @param max
	 * @return
	 */

	private static Random random = new Random();

	public static int intRangedRandNum(int min, int max) {
		return random.nextInt(max)%(max-min+1)+min;
	}


    /**
     * 判断一个字符是否为中文标点符号
     * @param c
     * @return
     */
    public static boolean isChinesePunctuation(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_FORMS
                || ub == Character.UnicodeBlock.VERTICAL_FORMS) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断一个字符是否是汉字
     * 汉字的编码范围：[\u4e00-\u9fa5]
     */
    public static boolean isChineseChar(char c) {
        if(c == ' ') return true; //这里所需求的特殊情况，即不对空格进行甄别
        return String.valueOf(c).matches("[\u4e00-\u9fa5]");
    }


	/**
	 * 计算数学表达式的值
	 */

	private static Evaluator evaluator = new Evaluator();

	public static String getAnsOfAExpression(String expression){
		Double res = 0.0;
		BigDecimal bigDecimal = null;
		try{
			res = evaluator.getNumberResult(expression);
			bigDecimal = new BigDecimal(res.toString());
			//System.out.println(res.trim());
		}catch (EvaluationException e) {
			e.printStackTrace();
		}
		return bigDecimal.toPlainString();
	}
}
