package com.obsms.test.api.converter;

import com.obsms.test.api.abs.RequestStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class RequestStatusConverter implements AttributeConverter<RequestStatus, String> {

    private static Logger LOGGER = LoggerFactory.getLogger(RequestStatusConverter.class);

    /**
     * @param attribute the entity attribute value to be converted
     * @return
     */
    @Override
    public String convertToDatabaseColumn(RequestStatus attribute) {
        if (attribute == null) {
            return null;
        }
        switch (attribute) {
            case NEW:
                return RequestStatus.NEW.getStatus();
            case APPROVED:
                return RequestStatus.APPROVED.getStatus();
            default:
                LOGGER.error(String.format("Unknown value: %s", attribute));
        }
        return null;
    }

    /**
     * @param dbData the data from the database column to be
     *               converted
     * @return
     */
    @Override
    public RequestStatus convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        switch (dbData) {
            case "Newly added book request":
                return RequestStatus.NEW;
            case "Approved request":
                return RequestStatus.APPROVED;
            default:
                LOGGER.error(String.format("Unknown value: %s", dbData));
        }
        return null;
    }
}
