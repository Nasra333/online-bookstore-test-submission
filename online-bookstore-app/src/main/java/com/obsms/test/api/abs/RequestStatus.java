/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.obsms.test.api.abs;

/**
 * @author ope
 */
public enum RequestStatus {
    NEW("Newly added book request"),
    APPROVED("Approved request");

    private final String status;

    private RequestStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
