package com.bcp.transform1.teamdashboard.restapi.anonymous.repository;

import com.bcp.transform1.teamdashboard.restapi.anonymous.dto.GitHubUserIn;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
@FeignClient(
    name = "gitHubAnonymousClient",
    url = "${github.url}"
)
public interface GitHubAnonymousClient {
    @GetMapping(
        value = "/users/{user}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    GitHubUserIn getUser(
        @PathVariable String user
    );
}