package com.bcp.transform1.teamdashboard.restapi.bearer.service;

import com.bcp.transform1.teamdashboard.restapi.bearer.vo.GitHubActivityVO;
import java.util.List;

public interface GitHubBearerService {
    List<GitHubActivityVO> getRepoActivities(
            String user,
            String repo
    );
}
