package com.zebrunner.carina.demo.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/users", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/users/_post/rq_regres.json")
@ResponseTemplatePath(path = "api/users/_post/rs_regres.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)

public class PostRegresMethod extends AbstractApiMethodV2 {

    public PostRegresMethod() {
        super("api/users/_post/rq_regres.json", "api/users/_post/rs_regres.json", "api/users/regres.properties");
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }

}
