package com.obsms.test.api.commons.abs.data;

interface IBaseEntity<PK> {

    Long getVersion();

    void setVersion(Long version);

    PK getId();
}
