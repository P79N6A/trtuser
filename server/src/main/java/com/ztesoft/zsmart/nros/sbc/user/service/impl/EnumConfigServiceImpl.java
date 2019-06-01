package com.ztesoft.zsmart.nros.sbc.user.service.impl;

import com.ztesoft.zsmart.nros.sbc.user.client.api.EnumConfigService;
import com.ztesoft.zsmart.nros.sbc.user.dao.dataobject.generator.EnumConfigDO;
import com.ztesoft.zsmart.nros.sbc.user.domain.metadata.EnumConfigDomain;
import com.ztesoft.zsmart.nros.sbc.user.common.enums.MetadataTypeEnum;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.EnumConfigDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.query.EnumConfigQuery;
import jodd.bean.BeanCopy;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: yaodingw
 * Date: 2019-04-17
 * Time: 11:18
 */
@Service
public class EnumConfigServiceImpl implements EnumConfigService {

    @Autowired
    private EnumConfigDomain enumConfigDomain;

    @Override
    public List<EnumConfigDTO> listAllEnumConfigType() {
        List<EnumConfigDO> enumConfigDOList=enumConfigDomain.queryAllEnumConfigType();
        return do2DTO(enumConfigDOList);
    }

    @Override
    public List<EnumConfigDTO> listEnumConfigByParams(EnumConfigQuery enumConfigQuery) {
        List<EnumConfigDO> listEnumConfigDO=enumConfigDomain.queryEnumConfigList(enumConfigQuery);
        List<EnumConfigDTO> result = do2DTO(listEnumConfigDO);
        return result;
    }

    @Override
    public List<EnumConfigDTO> listChannelEnumConfig() {
        EnumConfigQuery enumConfigQuery=new EnumConfigQuery();
        enumConfigQuery.setTableCode(MetadataTypeEnum.CHANNEL_TYPE.getCode());
        return this.listEnumConfigByParams(enumConfigQuery);
    }

    private List<EnumConfigDTO> do2DTO(List<EnumConfigDO> enumConfigDOList) {
        if (CollectionUtils.isEmpty(enumConfigDOList)) {
            return null;
        }
        List<EnumConfigDTO> result=new ArrayList<>();

        for (EnumConfigDO enumConfigDO : enumConfigDOList) {
            EnumConfigDTO enumConfigDTO=new EnumConfigDTO();
            BeanCopy.beans(enumConfigDO,enumConfigDTO).copy();
            result.add(enumConfigDTO);
        }
        return result;
    }
}
