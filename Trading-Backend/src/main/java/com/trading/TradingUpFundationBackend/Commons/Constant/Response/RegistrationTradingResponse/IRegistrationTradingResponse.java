package com.trading.TradingUpFundationBackend.Commons.Constant.Response.RegistrationTradingResponse;

/**
 * Interface who represent a response for each possible situation of the manage to the entity "RegistrationEntity"
 */
public interface IRegistrationTradingResponse {
    String REGISTRATION_REGISTRATION_SUCCESS = "Successful registration registration";//If the registration could be registered
    String REGISTRATION_REGISTRATION_FAILED = "Failed registration registration";//If the registration could not be registered
    String REGISTRATION_UPDATED_SUCCESS = "Successfully registration updated";
    String REGISTRATION_UPDATED_FAILED = "Failed registration updated";
    String REGISTRATION_DELETED_SUCCESS = "Successfully registration deleted";
    String REGISTRATION_DELETED_FAILED = "Failed registration deleted";
}
