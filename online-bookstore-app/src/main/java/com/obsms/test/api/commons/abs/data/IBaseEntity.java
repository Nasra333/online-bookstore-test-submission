package com.obsms.test.api.commons.abs.data;

import java.io.Serializable;

interface IBaseEntity<PK> extends Serializable {

    Long getVersion();

    void setVersion(Long version);

    PK getId();
}
