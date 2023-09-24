package com.bcp.transform1.teamdashboard.restapi.anonymous.service;

import com.bcp.transform1.teamdashboard.restapi.anonymous.vo.GitHubUserVO;

public interface GitHubAnonymousService {
    GitHubUserVO getUser(String user);
}
