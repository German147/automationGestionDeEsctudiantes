package com.germanBarrera.utils.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.Configuration;

@Endpoint(url = "${base_url}${id}/lists", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetCardById extends AbstractApiMethodV2 {

    public GetCardById() {
        replaceUrlPlaceholder("base_url",
                Configuration.getEnvArg("api_card_url"));
        replaceUrlPlaceholder("id",
                Configuration.getEnvArg("card_id"));
    }
}
