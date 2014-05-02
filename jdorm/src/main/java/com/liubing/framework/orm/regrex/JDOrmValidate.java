/**   
* @Title: JDOrmValidate.java 
* @Package com.jd.framework.orm.regrex 
* @Description: TODO(java 验证工具类) 
* @author liubingsmile@gmail.com	   
* @date 2014-5-2 下午1:48:27 
* @version V1.0   
*/ 
package com.liubing.framework.orm.regrex;

/**
 * @author liubingsmile@gmail.com
 *
 */
public class JDOrmValidate {
	/**
	 * 
	* <p>Title: </p> 
	* <p>Description:系统默认验证方法 </p> 
	* @return
	 */
	public static Boolean defaultValidate(String validateType,String value){
		Boolean flag=true;
		if(validateType.equals(JDOrmValidateType.V_CHINESE)){
			flag=JDOrmValidateUtils.Chinese(value);
		}else if(validateType.equals(JDOrmValidateType.V_DATE)){
			flag=JDOrmValidateUtils.Date(value);
		}else if(validateType.equals(JDOrmValidateType.V_EMAIL)){
			flag=JDOrmValidateUtils.Email(value);
		}else if(validateType.equals(JDOrmValidateType.V_FLOAT)){
			flag=JDOrmValidateUtils.Float(value);
		}else if(validateType.equals(JDOrmValidateType.V_IDCARD)){
			flag=JDOrmValidateUtils.IDcard(value);
		}else if(validateType.equals(JDOrmValidateType.V_INTEGER)){
			flag=JDOrmValidateUtils.Integer(value);
		}else if(validateType.equals(JDOrmValidateType.V_IP4)){
			flag=JDOrmValidateUtils.IP4(value);
		}else if(validateType.equals(JDOrmValidateType.V_LETTER)){
			flag=JDOrmValidateUtils.Letter(value);
		}else if(validateType.equals(JDOrmValidateType.V_LETTER_I)){
			flag=JDOrmValidateUtils.Letter_i(value);
		}else if(validateType.equals(JDOrmValidateType.V_LETTER_U)){
			flag=JDOrmValidateUtils.Letter_u(value);
		}else if(validateType.equals(JDOrmValidateType.V_MOBILE)){
			flag=JDOrmValidateUtils.Mobile(value);
		}else if(validateType.equals(JDOrmValidateType.V_NEGATINE_NUMBER)){
			flag=JDOrmValidateUtils.NegatineNumber(value);
		}else if(validateType.equals(JDOrmValidateType.V_NEGATIVE_FLOAT)){
			flag=JDOrmValidateUtils.Negative_float(value);
		}else if(validateType.equals(JDOrmValidateType.V_NEGATIVE_INTEGER)){
			flag=JDOrmValidateUtils.Negative_integer(value);
		}else if(validateType.equals(JDOrmValidateType.V_NOTEMPTY)){
			flag=JDOrmValidateUtils.Notempty(value);
		}else if(validateType.equals(JDOrmValidateType.V_NUMBER)){
			flag=JDOrmValidateUtils.Number(value);
		}else if(validateType.equals(JDOrmValidateType.V_POSITIVE_NUMBER)){
			flag=JDOrmValidateUtils.PositiveNumber(value);
		}else if(validateType.equals(JDOrmValidateType.V_POSTTIVE_FLOAT)){
			flag=JDOrmValidateUtils.Posttive_float(value);
		}else if(validateType.equals(JDOrmValidateType.V_QQ_NUMBER)){
			flag=JDOrmValidateUtils.QQnumber(value);
		}else if(validateType.equals(JDOrmValidateType.V_RAR)){
			flag=JDOrmValidateUtils.Rar(value);
		}else if(validateType.equals(JDOrmValidateType.V_TEL)){
			flag=JDOrmValidateUtils.Tel(value);
		}else if(validateType.equals(JDOrmValidateType.V_UN_NEGATIVE_FLOAT)){
			flag=JDOrmValidateUtils.Un_negative_float(value);
		}else if(validateType.equals(JDOrmValidateType.V_UNPOSITIVE_FLOAT)){
			flag=JDOrmValidateUtils.Unpositive_float(value);
		}else if(validateType.equals(JDOrmValidateType.V_URL)){
			flag=JDOrmValidateUtils.Url(value);
		}else if(validateType.equals(JDOrmValidateType.V_USERNAME)){
			flag=JDOrmValidateUtils.UserName(value);
		}else if(validateType.equals(JDOrmValidateType.V_ZIPCODE)){
			flag=JDOrmValidateUtils.Zipcode(value);
		}else if(validateType.equals(JDOrmValidateType.V_Z_INDEX)){
			flag=JDOrmValidateUtils.Z_index(value);
		}
		
		return flag;
	}
	/**
	 * 
	* <p>Title: </p> 
	* <p>Description:自定义验证方法 </p> 
	* @param validateType
	* @return
	 */
	public static Boolean userValidate(String validateType,String value){
		return true;
	}
	
	public static Boolean validateLength(String value,Integer length) throws Exception{
		if(value.getBytes().length>length){
			//throw new Exception("");
			return false;
		}
		return true;
	}
	
}
