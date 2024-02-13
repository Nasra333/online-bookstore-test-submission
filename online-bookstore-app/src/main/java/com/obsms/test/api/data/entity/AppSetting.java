/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.obsms.test.api.data.entity;

import com.obsms.test.api.commons.abs.data.AbstractAddonAuditable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * @author walles
 */

@Entity
@Table(name = "app_setting", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"app_key"}),
        @UniqueConstraint(columnNames = {"app_value"})})
public class AppSetting extends AbstractAddonAuditable {

    @Column(name = "app_key", nullable = false)
    private String appKey;
    @Column(name = "app_value", nullable = false)
    private String appValue;
    @Basic(optional = false)
    @Column(name = "caching_enabled", columnDefinition = "BOOLEAN NOT NULL DEFAULT TRUE")
    @Type(type = "org.hibernate.type.BooleanType")
    private boolean cachingEnabled;

    /**
     * default constructor.
     */
    public AppSetting() {
    }

    /**
     * constructor.
     *
     * @param appKey
     * @param appValue
     * @param cachingEnabled
     */
    public AppSetting(String appKey, String appValue, boolean cachingEnabled) {
        this.appKey = appKey;
        this.appValue = appValue;
        this.cachingEnabled = cachingEnabled;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppValue() {
        return appValue;
    }

    public void setAppValue(String appValue) {
        this.appValue = appValue;
    }

    public boolean isCachingEnabled() {
        return cachingEnabled;
    }

    public void setCachingEnabled(boolean cachingEnabled) {
        this.cachingEnabled = cachingEnabled;
    }

    @Override
    public String toString() {
        return "AppSetting{" +
                "key='" + appKey + '\'' +
                ", value='" + appValue + '\'' +
                ", cachingEnabled=" + cachingEnabled +
                ", id='" + id + '\'' +
                '}';
    }
}
