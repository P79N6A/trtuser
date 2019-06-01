package com.ztesoft.zsmart.nros.sbc.user.dao.mapper;

import com.ztesoft.zsmart.nros.base.annotation.DatapriveAop;
import com.ztesoft.zsmart.nros.sbc.user.dao.dataobject.generator.EnumConfigDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * EnumConfigDO
 * @author 浩鲸云计算科技股份有限公司
 * @date 2019-04-17
 */
public interface EnumConfigMapper {

    @DatapriveAop
    List<EnumConfigDO> queryAllEnumConfigType();

    List<EnumConfigDO> queryEnumConfigListByParams(@Param("enumConfigDO") EnumConfigDO enumConfigDO);

}