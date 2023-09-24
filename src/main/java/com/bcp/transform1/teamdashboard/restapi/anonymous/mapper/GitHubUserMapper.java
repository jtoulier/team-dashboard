package com.bcp.transform1.teamdashboard.restapi.anonymous.mapper;

import com.bcp.transform1.teamdashboard.restapi.anonymous.dto.GitHubUserIn;
import com.bcp.transform1.teamdashboard.restapi.anonymous.vo.GitHubUserVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GitHubUserMapper {
    GitHubUserIn mapVOToIn(GitHubUserVO gitHubUser);
    GitHubUserVO mapInToVO(GitHubUserIn gitHubUserIn);
}
