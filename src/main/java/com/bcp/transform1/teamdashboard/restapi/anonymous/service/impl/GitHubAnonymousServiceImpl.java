package com.bcp.transform1.teamdashboard.restapi.anonymous.service.impl;

import com.bcp.transform1.teamdashboard.restapi.anonymous.dto.GitHubUserIn;
import com.bcp.transform1.teamdashboard.restapi.anonymous.mapper.GitHubUserMapper;
import com.bcp.transform1.teamdashboard.restapi.anonymous.vo.GitHubUserVO;
import com.bcp.transform1.teamdashboard.restapi.anonymous.repository.GitHubAnonymousClient;
import com.bcp.transform1.teamdashboard.restapi.anonymous.service.GitHubAnonymousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GitHubAnonymousServiceImpl implements GitHubAnonymousService {
    @Autowired
    private GitHubAnonymousClient gitHubAnonymousClient;

    @Autowired
    private GitHubUserMapper gitHubUserMapper;

    @Override
    public GitHubUserVO getUser(String user) {
        GitHubUserIn gitHubUserIn;
        gitHubUserIn =  gitHubAnonymousClient.getUser(user);

        return gitHubUserMapper.mapInToVO(gitHubUserIn);
    }
}
