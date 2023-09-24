package com.bcp.transform1.teamdashboard.restapi.bearer.repository;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;


public class GitHubBearerClientConfiguration {
    @Value("${github.bearer-token}")
    private String gitHubBearerToken;

    @Bean
    public RequestInterceptor bearerTokenRequestInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate template) {
                template.header(
                    "Authorization",
                    String.format("Bearer %s", gitHubBearerToken)
                );
            }
        };
    }
}
