/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.obsms.test.api.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.obsms.test.api.commons.abs.data.AbstractActiveAuditable;
import com.obsms.test.api.commons.abs.data.AbstractAddonAuditable;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author walles
 */

@Getter
@Setter
@Entity
@Table(name = "data_change_log", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"change_log"})})
@XmlRootElement
public class DataChangeLog extends AbstractAddonAuditable {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "change_log", nullable = false, length = 10)
    private String changeLog;

    public DataChangeLog() {
    }

    public DataChangeLog(String changeLog) {
        this.changeLog = changeLog;
    }

    @Override
    public String toString() {
        return "DataChangeLog{" +
                "changeLog='" + changeLog + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
