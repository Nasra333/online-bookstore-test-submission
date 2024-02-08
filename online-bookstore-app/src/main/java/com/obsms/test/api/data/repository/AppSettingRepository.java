
package com.obsms.test.api.data.repository;

import com.obsms.test.api.commons.abs.data.AddonAuditableJpaRepository;
import com.obsms.test.api.data.entity.AppSetting;
import org.springframework.stereotype.Repository;

/**
 * @author walles
 */

@Repository
public interface AppSettingRepository extends AddonAuditableJpaRepository<AppSetting> {
}
