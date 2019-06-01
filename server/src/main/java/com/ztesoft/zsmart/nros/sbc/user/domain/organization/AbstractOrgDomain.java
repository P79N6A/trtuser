package com.ztesoft.zsmart.nros.sbc.user.domain.organization;

import com.ztesoft.zsmart.nros.sbc.user.dao.dataobject.OrgDetail;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.OrgDTO;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: yaodingw
 * Date: 2019-05-27
 * Time: 15:59
 */
public abstract class AbstractOrgDomain<T extends OrgDTO > {
   public abstract void addOrg(T org);

   public abstract void updateOrg(T org);

   public abstract void deleted(Long orgId);

   public abstract OrgDetail findByOrgId(Long orgId);
}
