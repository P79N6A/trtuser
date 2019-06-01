package com.ztesoft.zsmart.nros.sbc.nrosuser.plugin.base;

import com.ztesoft.zsmart.nros.base.exception.BusiException;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.InitializingBean;

import java.util.List;

/**
 * Created by yang.chao.
 *
 * @date 2019-05-06
 */
@Slf4j
public abstract class BaseDao<T> implements InitializingBean {

    protected abstract String getNameSpace();

    protected abstract SqlSessionTemplate getSqlSessionTemplate();

    public int insert(T domain) {
        try {
            return this.insert(getNameSpace() + "insert", domain);
        }
        catch (Exception e) {
            log.error("insert failed", e);
            throw new BusiException("-1001", "insert error", e);
        }
    }

    public List<T> select(T query) {
        try {
            return this.queryForList(getNameSpace() + "select", query);
        }
        catch (Exception e) {
            log.error("select failed", e);
            throw new BusiException("-1005", "select error", e);
        }
    }

    public Integer count(T query) {
        try {
            return (Integer) this.queryForObject(getNameSpace() + "count", query);
        }
        catch (Exception e) {
            log.error("count failed", e);
            throw new BusiException("-1006", "count error", e);
        }
    }

    public Object queryForObject(String statementName, Object parameterObject) throws Exception {
        return this.getSqlSessionTemplate().selectOne(statementName, parameterObject);
    }

    public <T> List<T> queryForList(String statementName, Object parameterObject) throws Exception {
        return this.getSqlSessionTemplate().selectList(statementName, parameterObject);
    }

    public int insert(String statementName, Object parameterObject) throws Exception {
        return this.getSqlSessionTemplate().insert(statementName, parameterObject);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (this.getSqlSessionTemplate() == null) {
            throw new Exception("BaseDao initialize fail,check related Spring's configuration file");
        }
    }
}
