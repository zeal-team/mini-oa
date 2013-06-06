/**
 * 
 */
package org.mini.framework.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.mini.common.config.Config;
import org.mini.common.model.Pager;
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

	@Override
	public <P> List<T> queryAll(String statement, P p, Pager pager,
			List<FieldColumn> parameters) throws Exception {
		// TODO Auto-generated method stub
		Integer count = (Integer) sqlSessionTemplate.selectOne(statement + Config.MYBATIS_RECORD_COUNT, p);
		
		pager.setCount(count == null ? 0 : count.intValue());

		int index = pager.getIndex();
		int totalPage = pager.getTotalPage();

		if (index < 1) {
			pager.setIndex(1);
		} else if (index > totalPage) {
			pager.setIndex(totalPage);
		}

		int offset = pager.getSize() * (pager.getIndex() - 1);
		int row = pager.getSize();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("bean", p);
		map.put("offset", offset);
		map.put("row", row);
		
		return sqlSessionTemplate.selectList(statement, map);
	}

	@Override
	public <P> List<T> queryAll(String statement, P p, Pager pager)
			throws Exception {
		// TODO Auto-generated method stub
		return queryAll(statement, p, pager, null);
	}
}
