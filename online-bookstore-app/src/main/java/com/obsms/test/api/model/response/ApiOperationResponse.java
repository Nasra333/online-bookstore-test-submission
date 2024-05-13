package com.obsms.test.api.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiOperationResponse {

    @JsonProperty("responseCode")
    private ResponseCodeEnum responseCode = null;

    @JsonProperty("responseMessage")
    private String responseMessage = null;

    @JsonProperty("responsePayload")
    private String responsePayload = null;

    public enum ResponseCodeEnum {
        SUCCESS, FAILED,
    }
}
