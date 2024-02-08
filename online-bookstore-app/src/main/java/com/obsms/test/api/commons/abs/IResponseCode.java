package com.obsms.test.api.commons.abs;

public interface IResponseCode extends Cloneable {

    /**
     * Response code.
     *
     * @return {@link String}
     */
    String getCode();

    /**
     * @param code
     */
    void setCode(String code);

    /**
     * Response code description.
     *
     * @return {@link String}
     */
    String getDescription();

    /**
     * @param description
     */
    void setDescription(String description);

    /**
     *
     * @param code
     * @param description
     */
    IResponseCode build(String code, String description);
}
