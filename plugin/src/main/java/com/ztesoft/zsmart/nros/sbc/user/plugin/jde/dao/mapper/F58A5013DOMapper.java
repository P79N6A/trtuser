package com.ztesoft.zsmart.nros.sbc.nrosuser.plugin.jde.dao.mapper;

import com.ztesoft.zsmart.nros.sbc.nrosuser.plugin.base.BaseDao;
import com.ztesoft.zsmart.nros.sbc.nrosuser.plugin.jde.dao.model.F58A5013DO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * f58a5013
 * @author 浩鲸云计算科技股份有限公司
 * @date 2019-05-06
 */
@Repository
public class F58A5013DOMapper extends BaseDao<F58A5013DO> {

    @Autowired
    @Qualifier("jdeSqlSessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    protected String getNameSpace() {
        return this.getClass().getSimpleName() + ".";
    }

    @Override
    protected SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }

}