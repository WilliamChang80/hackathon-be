package com.hackathon.hackbe.url;

import com.amazonaws.services.elasticmapreduce.model.ScalingTrigger;

public class Url {
    public static final String LOGIN_URL = "api/auth/login";
    public static final String REGISTER_URL = "api/auth/register";
    public static final String SWAGGER_UI_URL = "/swagger-ui.html";
    public static final String CREATE_CLIENT_TYPE_URL = "api/client-type";
    public static final String GET_CLIENT_TYPES_URL = "api/client-types";
    public static final String GET_CLIENT_TYPE_BY_ID_URL = "api/client-type/{id}";
    public static final String UPDATE_CLIENT_TYPE_URL = "api/client-type/{id}";
    public static final String DELETE_CLIENT_TYPE_URL = "api/client-type/{id}";

    public static final String CREATE_SERVICE_TYPE_URL = "api/service-type";
    public static final String GET_SERVICE_TYPES_URL = "api/service-types";
    public static final String GET_SERVICE_TYPE_BY_ID_URL = "api/service-type/{id}";
    public static final String UPDATE_SERVICE_TYPE_URL = "api/service-type/{id}";
    public static final String DELETE_SERVICE_TYPE_URL = "api/service-type/{id}";

    public static final String ADD_AGENCY_PROFILE_URL = "api/user/agency/profile";
    public static final String ADD_CLIENT_PROFILE_URL = "api/user/client/profile";
    public static final String GET_AGENCY_RECOMMENDATION = "api/user/{id}/agencies";

    public static final String CREATE_SERVICE_URL = "api/service";
    public static final String UPDATE_SERVICE_URL = "api/service/{id}";
    public static final String DELETE_SERVICE_URL = "api/service/{id}";
    public static final String GET_SERVICES_URL = "api/services";
    public static final String GET_SERVICE_BY_ID_URL = "api/service/{id}";
    public static final String GET_SERVICE_BY_AGENCY_ID_URL = "api/services/agency/{id}";
}
