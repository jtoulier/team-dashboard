package com.bcp.transform1.teamdashboard.proxy;

import com.bcp.transform1.teamdashboard.model.GitHubUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "githubClient", url = "https://api.github.com")
public interface GitHubClient {
    @GetMapping(value = "/users/{user}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GitHubUser getUser(@PathVariable String user);

}