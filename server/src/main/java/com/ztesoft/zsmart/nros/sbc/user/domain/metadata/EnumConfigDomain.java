package com.ztesoft.zsmart.nros.sbc.user.domain.metadata;

import com.ztesoft.zsmart.nros.sbc.user.dao.mapper.EnumConfigMapper;
import com.ztesoft.zsmart.nros.sbc.user.dao.dataobject.generator.EnumConfigDO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.query.EnumConfigQuery;
import jodd.bean.BeanCopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: yaodingw
 * Date: 2019-04-17
 * Time: 11:20
 */
@Repository
public class EnumConfigDomain {
    @Autowired
    private EnumConfigMapper enumConfigMapper;

    /**
     * 根据查询条件查询系统元数据值
     * @param enumConfigQuery
     * @return
     */
    public List<EnumConfigDO> queryEnumConfigList(EnumConfigQuery enumConfigQuery){
        EnumConfigDO enumConfigDO=query2DO(enumConfigQuery);
        return enumConfigMapper.queryEnumConfigListByParams(enumConfigDO);
    }

    /**
     * 查询所有种类
     * @return
     */
    public List<EnumConfigDO> queryAllEnumConfigType(){
        return enumConfigMapper.queryAllEnumConfigType();
    }

    private EnumConfigDO query2DO(EnumConfigQuery enumConfigQuery) {
        EnumConfigDO enumConfigDO = new EnumConfigDO();
        BeanCopy.beans(enumConfigQuery, enumConfigDO).copy();
        return enumConfigDO;
    }
}
