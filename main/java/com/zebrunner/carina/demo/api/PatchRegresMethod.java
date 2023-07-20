package com.zebrunner.carina.demo.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/users/2", methodType = HttpMethodType.PATCH)
@RequestTemplatePath(path = "api/users/_post/rq_regres.json")
@ResponseTemplatePath(path = "api/users/_post/rs_regres.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)

public class PatchRegresMethod extends AbstractApiMethodV2 {

    public PatchRegresMethod() {

        super("api/users/_post/rq_patch_regress.json", "api/users/_post/rs_patch_regres.json", "api/users/regres.properties");
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }
}
