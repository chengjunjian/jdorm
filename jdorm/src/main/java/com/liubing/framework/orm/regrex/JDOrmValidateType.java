/**   
* @Title: JDOrmValidateType.java 
* @Package com.jd.framework.orm.regrex 
* @Description: TODO(用一句话描述该文件做什么) 
* @author liubingsmile@gmail.com	   
* @date 2014-5-2 下午1:39:03 
* @version V1.0   
*/ 
package com.liubing.framework.orm.regrex;

/**
 * @author liubingsmile@gmail.com
 *
 */
public class JDOrmValidateType {
	/** 整数 */
	public static String	V_INTEGER="V_INTEGER";
	/** 正整数 */
    public static String   V_Z_INDEX="V_Z_INDEX";
	/** 负整数 */
    public static String   V_NEGATIVE_INTEGER="V_NEGATIVE_INTEGER";
	/** 数字 */
    public static String   V_NUMBER="V_NUMBER";
	/** 正数 */
    public static String   V_POSITIVE_NUMBER="V_POSITIVE_NUMBER";
	/** 负数 */
    public static String   V_NEGATINE_NUMBER="V_NEGATINE_NUMBER";
	/** 浮点数 */
    public static String   V_FLOAT="V_FLOAT";
	/** 正浮点数 */
    public static String   V_POSTTIVE_FLOAT="V_POSTTIVE_FLOAT";
	/** 负浮点数 */
    public static String   V_NEGATIVE_FLOAT="V_NEGATIVE_FLOAT";
	/** 非负浮点数（正浮点数 + 0） */
    public static String   V_UNPOSITIVE_FLOAT="V_UNPOSITIVE_FLOAT";
	/** 非正浮点数（负浮点数 + 0） */
    public static String   V_UN_NEGATIVE_FLOAT="V_UN_NEGATIVE_FLOAT";
	/** 邮件 */
    public static String   V_EMAIL="V_EMAIL";
	/** url */
    public static String   V_URL="V_URL";
	/** 仅中文 */
    public static String   V_CHINESE="V_CHINESE";
	/** 邮编 */
    public static String   V_ZIPCODE="V_ZIPCODE";
	/** 手机 */
    public static String   V_MOBILE="V_MOBILE";
	/** ip4地址 */
    public static String   V_IP4="V_IP4";
	/** 非空 */
    public static String   V_NOTEMPTY="V_NOTEMPTY";
	/** 压缩文件 */
    public static String   V_RAR="V_RAR";
	/** 日期 */
    public static String   V_DATE="V_DATE";
	/** QQ号码 */
    public static String   V_QQ_NUMBER="V_QQ_NUMBER";
	/** 电话号码的函数(包括验证国内区号;国际区号;分机号) */
    public static String   V_TEL="V_TEL";
	/** 字母 */
    public static String   V_LETTER="V_LETTER";
	/** 用来用户注册。匹配由数字、26个英文字母或者下划线组成的字符串 */
    public static String   V_USERNAME="V_USERNAME";
	/** 身份证 */
    public static String   V_IDCARD="V_LETTER_I";
	/** 小写字母 */
    public static String   V_LETTER_I="V_LETTER_I";
	/** 大写字母 */
    public static String   V_LETTER_U="V_LETTER_U";
}
