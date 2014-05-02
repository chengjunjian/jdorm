/**   
* @Title: BaseComplexDaoImpl.java 
* @Package com.jd.framework.orm.dao.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author liubingsmile@gmail.com	   
* @date 2014-5-1 下午5:29:40 
* @version V1.0   
*/ 
package com.liubing.framework.orm.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liubing.framework.orm.dao.IBaseComplexDao;
import com.liubing.framework.orm.dao.support.impl.ComplexDaoSupportImpl;
import com.liubing.framework.orm.dialect.Dialect;
import com.liubing.framework.orm.entity.BaseEntity;
import com.liubing.framework.orm.regrex.JDOrmValidate;
import com.liubing.framework.orm.schema.SchemaColumn;
import com.liubing.framework.orm.schema.SchemaInfo;
import com.liubing.framework.orm.util.BeanSQLUtils;
import com.liubing.framework.orm.util.PageResult;
import com.liubing.framework.orm.util.QueryCriteria;
import com.liubing.framework.orm.util.StringUtil;

/**
 * @author liubingsmile@gmail.com
 *
 */
public class BaseComplexDaoImpl<T extends BaseEntity> extends ComplexDaoSupportImpl implements
		IBaseComplexDao<T> {
	public  final Log log = LogFactory.getLog(getClass());
	private Class<T> entityClass;
	public BaseComplexDaoImpl() {
		if (ParameterizedType.class.isAssignableFrom(getClass()
				.getGenericSuperclass().getClass())) {
			Type[] actualTypeArguments = ((ParameterizedType) getClass()
					.getGenericSuperclass()).getActualTypeArguments();
			entityClass = (Class<T>) actualTypeArguments[0];
		}
	}
	@Override
	public void doCreateEntity(String datasourcename, T t) throws Exception {
		// TODO Auto-generated method stub
		SchemaInfo schemaInfo=t.getSchemaInfo();
		String insertSql=BeanSQLUtils.get_sql_insert(schemaInfo, super.getDao().getDialect(datasourcename));
		Boolean flag=true;
		for(SchemaColumn schemaColumn:schemaInfo.getColumns()){
			if(StringUtil.isNullOrEmpty(schemaColumn.getFieldValue())&&!schemaColumn.isNullable()){
				throw new Exception("字段"+schemaColumn.getFieldName()+"必填");
			}
			if(!StringUtil.isNullOrEmpty(schemaColumn.getFieldValue())&&!StringUtil.isNullOrEmpty(schemaColumn.getTypeLength())){
				flag=JDOrmValidate.validateLength(schemaColumn.getFieldValue()+"", schemaColumn.getTypeLength());
				if(!flag){
					throw new Exception("字段"+schemaColumn.getFieldName()+"长度过长，超过最大值:"+schemaColumn.getTypeLength());
				}
			}
			
			if(!StringUtil.isNullOrEmpty(schemaColumn.getValidateType())&&!StringUtil.isNullOrEmpty(schemaColumn.getFieldValue())){
				flag=JDOrmValidate.userValidate(schemaColumn.getValidateType(), schemaColumn.getFieldValue()+"");
				if(!flag){
					throw new Exception("字段"+schemaColumn.getFieldName()+"验证不通过，验证类型为:"+schemaColumn.getValidateType());
				}
			}
			if(!StringUtil.isNullOrEmpty(schemaColumn.getValidateType())&&!StringUtil.isNullOrEmpty(schemaColumn.getFieldValue())){
				flag=JDOrmValidate.defaultValidate(schemaColumn.getValidateType(), schemaColumn.getFieldValue()+"");
				if(!flag){
					throw new Exception("字段"+schemaColumn.getFieldName()+"验证不通过，验证类型为:"+schemaColumn.getValidateType());
				}
			}
		}
		super.execute(datasourcename,insertSql, null);
	}

	@Override
	public void doCreateBySql(String datasourcename, String sql,
			Object... params) throws Exception {
		// TODO Auto-generated method stub
		super.execute(datasourcename,sql, params);
	}

	@Override
	public void doUpdateEntity(String datasourcename, T t) throws Exception {
		// TODO Auto-generated method stub
		SchemaInfo schemaInfo=t.getSchemaInfo();
		String updatesql=BeanSQLUtils.get_sql_update(schemaInfo, super.getDao().getDialect(datasourcename));
		Boolean flag=true;
		for(SchemaColumn schemaColumn:schemaInfo.getColumns()){
			if(StringUtil.isNullOrEmpty(schemaColumn.getFieldValue())&&!schemaColumn.isNullable()){
				throw new Exception("字段"+schemaColumn.getFieldName()+"必填");
			}
			if(!StringUtil.isNullOrEmpty(schemaColumn.getFieldValue())&&!StringUtil.isNullOrEmpty(schemaColumn.getTypeLength())){
				flag=JDOrmValidate.validateLength(schemaColumn.getFieldValue()+"", schemaColumn.getTypeLength());
				if(!flag){
					throw new Exception("字段"+schemaColumn.getFieldName()+"长度过长，超过最大值:"+schemaColumn.getTypeLength());
				}
			}
			
			if(!StringUtil.isNullOrEmpty(schemaColumn.getValidateType())&&!StringUtil.isNullOrEmpty(schemaColumn.getFieldValue())){
				flag=JDOrmValidate.userValidate(schemaColumn.getValidateType(), schemaColumn.getFieldValue()+"");
				if(!flag){
					throw new Exception("字段"+schemaColumn.getFieldName()+"验证不通过，验证类型为:"+schemaColumn.getValidateType());
				}
			}
			if(!StringUtil.isNullOrEmpty(schemaColumn.getValidateType())&&!StringUtil.isNullOrEmpty(schemaColumn.getFieldValue())){
				flag=JDOrmValidate.defaultValidate(schemaColumn.getValidateType(), schemaColumn.getFieldValue()+"");
				if(!flag){
					throw new Exception("字段"+schemaColumn.getFieldName()+"验证不通过，验证类型为:"+schemaColumn.getValidateType());
				}
			}
		}
		super.execute(datasourcename,updatesql, null);
	}

	@Override
	public void doUpdateBySql(String datasourcename, String sql,
			Object... params) throws Exception {
		// TODO Auto-generated method stub
		super.execute(datasourcename,sql, params);
	}

	@Override
	public void doRemoveEntity(String datasourcename, T t) throws Exception {
		// TODO Auto-generated method stub
		SchemaInfo schemaInfo=t.getSchemaInfo();
		String deletesql=BeanSQLUtils.get_sql_delete(schemaInfo, super.getDao().getDialect(datasourcename));
		super.execute(datasourcename,deletesql, null);
	}

	@Override
	public void doRemoveBySql(String datasourcename, String sql,
			Object... params) throws Exception {
		// TODO Auto-generated method stub
		super.execute(datasourcename,sql, params);
	}

	@Override
	public T findById(String datasourcename, Serializable id) throws Exception {
		// TODO Auto-generated method stub
		entityClass.newInstance();
		if(entityClass.newInstance() instanceof BaseEntity){
			BaseEntity baseEntity=entityClass.newInstance();
			SchemaInfo schemaInfo=baseEntity.getSchemaInfo();
			Dialect dialect=super.getDao().getDialect(datasourcename);
			String sql=BeanSQLUtils.get_sql_select_object(schemaInfo,dialect );
			return super.getDao().queryAsObject(datasourcename,entityClass, sql, id);
		}
		return null;
	}

	@Override
	public List<T> findAll(String datasourcename) throws Exception {
		// TODO Auto-generated method stub
		if(entityClass.newInstance() instanceof BaseEntity){
			BaseEntity baseEntity=entityClass.newInstance();
			SchemaInfo schemaInfo=baseEntity.getSchemaInfo();
			String sql=BeanSQLUtils.get_sql_select_all_object(schemaInfo, super.getDao().getDialect(datasourcename));
			return super.getDao().queryAsList(datasourcename,entityClass, sql, null);//根据主键查询
		}
		return null;
	}

	@Override
	public List<T> findByBean(String datasourcename, T t) throws Exception {
		// TODO Auto-generated method stub
		SchemaInfo schemaInfo=t.getSchemaInfo();
		Map<String, Object>params=PropertyUtils.describe(t);
		String sql=BeanSQLUtils.get_complex_sql_select_object(schemaInfo, super.getDao().getDialect(datasourcename), params, null, null);
		return super.getDao().queryAsList(datasourcename,entityClass, sql, params);//根据主键查询
	}

	@Override
	public List<T> findByMap(String datasourcename, Map<String, Object> params)
			throws Exception {
		// TODO Auto-generated method stub
		if(entityClass.newInstance() instanceof BaseEntity){
			BaseEntity baseEntity=entityClass.newInstance();
			SchemaInfo schemaInfo=baseEntity.getSchemaInfo();
			String sql=BeanSQLUtils.get_complex_sql_select_object(schemaInfo, super.getDao().getDialect(datasourcename), params, null, null);
			return super.getDao().queryAsList(datasourcename,entityClass, sql, null);//根据主键查询
		}
		return null;
	}

	@Override
	public List<T> findReturnClassByParamsAndSql(String datasourcename,
			String sql, Class<?> returnentityclass, Object... params)
			throws Exception {
		// TODO Auto-generated method stub
		return super.getDao().queryAsList(datasourcename,entityClass, sql, params);
	}

	@Override
	public Object findReturnObjectByParamsAndSql(String datasourcename,
			String sql, Class<?> cls, Object... params) throws Exception {
		// TODO Auto-generated method stub
		return super.getDao().queryAsObject(datasourcename,cls, sql, params);
	}

	@Override
	public Integer findAsInt(String datasourcename, String sql,
			Object... parameters) throws Exception {
		// TODO Auto-generated method stub
		return super.getDao().queryAsInt(datasourcename,sql, parameters);
	}

	@Override
	public Long findAsLong(String datasourcename, String sql,
			Object... parameters) throws Exception {
		// TODO Auto-generated method stub
		return super.getDao().queryAsLong(datasourcename,sql, parameters);
	}

	@Override
	public Float findAsFloat(String datasourcename, String sql,
			Object... parameters) throws Exception {
		// TODO Auto-generated method stub
		return super.getDao().queryAsFloat(datasourcename,sql, parameters);
	}

	@Override
	public String findAsString(String datasourcename, String sql,
			Object... parameters) throws Exception {
		// TODO Auto-generated method stub
		return super.getDao().queryAsString(datasourcename,sql, parameters);
	}

	@Override
	public Map<String, Object> findAsMap(String datasourcename, String sql,
			Object... parameters) throws Exception {
		// TODO Auto-generated method stub
		return super.getDao().queryAsMap(datasourcename,sql, parameters);
	}

	@Override
	public PageResult<T> findByCriteria(String datasourcename,
			QueryCriteria queryCriteria) throws Exception {
		// TODO Auto-generated method stub
		if(entityClass.newInstance() instanceof BaseEntity){
			BaseEntity baseEntity=entityClass.newInstance();
			SchemaInfo schemaInfo=baseEntity.getSchemaInfo();
			String orderField="";
	    	if(!BeanSQLUtils.validateTransient(schemaInfo.getColumns(), queryCriteria.getOrderField())){
	    		if(!StringUtil.isNullOrEmpty(queryCriteria.getOrderField())){
		    		orderField=queryCriteria.getOrderField().substring(0, queryCriteria.getOrderField().indexOf("name"));
	    		}
	    	}else{
	    		if(!StringUtil.isNullOrEmpty(queryCriteria.getOrderField())){
	    			orderField=queryCriteria.getOrderField();
	    		}
	    		
	    	}
	    	orderField=BeanSQLUtils.getOrderField(schemaInfo.getColumns(), orderField);
			String sql=BeanSQLUtils.get_complex_sql_select_object(schemaInfo, super.getDao().getDialect(datasourcename), queryCriteria.getQueryCondition(), orderField, queryCriteria.getOrderDirection());
	    	return super.getDao().queryAsPagelist(datasourcename,entityClass, sql, queryCriteria);
		}
		return null;
	}

}
