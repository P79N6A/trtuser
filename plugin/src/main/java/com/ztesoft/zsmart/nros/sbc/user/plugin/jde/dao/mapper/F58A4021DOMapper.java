package com.ztesoft.zsmart.nros.sbc.nrosuser.plugin.jde.dao.mapper;

import com.ztesoft.zsmart.nros.sbc.nrosuser.plugin.base.BaseDao;
import com.ztesoft.zsmart.nros.sbc.nrosuser.plugin.jde.dao.model.F58A4021DO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * 库存表
 * @author 浩鲸云计算科技股份有限公司
 * @date 2019-05-06
 */
@Repository
public class F58A4021DOMapper extends BaseDao<F58A4021DO> {

    @Autowired
    @Qualifier("jdeSqlSessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    protected String getNameSpace() {
        return this.getClass().getName() + ".";
    }

    @Override
    protected SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }

}