package com.bcp.transform1.teamdashboard.restapi.bearer.mapper;

import com.bcp.transform1.teamdashboard.restapi.bearer.dto.GitHubActorIn;
import com.bcp.transform1.teamdashboard.restapi.bearer.vo.GitHubActorVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GitHubActorMapper {
    GitHubActorIn mapVOToIn(GitHubActorVO gitHubActorVO);
    GitHubActorVO mapInToVO(GitHubActorIn gitHubActor);
}
