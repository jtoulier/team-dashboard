package com.bcp.transform1.teamdashboard.restapi.bearer.repository;

import com.bcp.transform1.teamdashboard.restapi.bearer.dto.GitHubActivityIn;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
@FeignClient(
    name = "gitHubBearerClient",
    url = "${github.url}",
    configuration = GitHubBearerClientConfiguration.class
)
public interface GitHubBearerClient {
    @GetMapping(
        value = "/repos/{user}/{repo}/activity",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    List<GitHubActivityIn> getRepoActivities(
        @PathVariable String user,
        @PathVariable String repo
    );
}