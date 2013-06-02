/**
 * 
 */
package org.mini.framework.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.mini.framework.bean.FieldColumn;
import org.mini.framework.dao.GenericDao;
import org.mybatis.spring.SqlSessionTemplate;

/**
 * @author Administrator
 *
 */
public abstract class MyBatisGenericDaoImpl<T> implements GenericDao<T> {
	protected Class<T> entityClass;
	
	@SuppressWarnings("unchecked")
	public MyBatisGenericDaoImpl() {
		entityClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	protected SqlSession getSession() {
		return sqlSessionTemplate.getSqlSessionFactory().openSession();
	}

	@Override
	public void insert(String statement, T t, List<FieldColumn> parameters)
			throws Exception {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert(statement, t);
	}

	@Override
	public void delete(String statement, T t, List<FieldColumn> parameters)
			throws Exception {
		// TODO Auto-generated method stub
		sqlSessionTemplate.delete(statement, t);
	}

	@Override
	public void delete(String statement, Serializable id) throws Exception {
		// TODO Auto-generated method stub
		sqlSessionTemplate.delete(statement, id);
	}

	@Override
	public void update(String statement, T t, List<FieldColumn> parameters)
			throws Exception {
		// TODO Auto-generated method stub
		sqlSessionTemplate.update(statement, t);
	}

	@Override
	public T queryById(String statement, Serializable id) throws Exception {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(statement, id);
	}

	@Override
	public T query(String statement, T t, List<FieldColumn> parameters)
			throws Exception {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(statement, t);
	}

	@Override
	public List<T> queryAll(String statement) throws Exception {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(statement);
	}

	@Override
	public void insert(String statement, T t) throws Exception {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert(statement, t);
	}

	@Override
	public void delete(String statement, T t) throws Exception {
		// TODO Auto-generated method stub
		sqlSessionTemplate.delete(statement, t);
	}

	@Override
	public void update(String statement, T t) throws Exception {
		// TODO Auto-generated method stub
		sqlSessionTemplate.update(statement, t);
	}

	@Override
	public T query(String statement, T t) throws Exception {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(statement, t);
	}

	@Override
	public <P> List<T> queryAll(String statement, P p) throws Exception {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(statement, p);
	}
}
