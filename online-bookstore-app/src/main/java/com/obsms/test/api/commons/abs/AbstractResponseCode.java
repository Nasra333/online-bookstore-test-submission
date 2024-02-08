package com.obsms.test.api.commons.abs;

/**
 * @author Ikram Samaad.
 */
public abstract class AbstractResponseCode implements IResponseCode {

    private String code;
    private String description;

    /**
     * default constructor.
     */
    public AbstractResponseCode() {
    }

    /**
     * constructor.
     *
     * @param code
     * @param description
     */
    public AbstractResponseCode(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public IResponseCode build(String code, String description) {
        this.code = code;
        this.description = description;
        return this;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public IResponseCode clone() throws CloneNotSupportedException {
        return (IResponseCode) super.clone();
    }
}