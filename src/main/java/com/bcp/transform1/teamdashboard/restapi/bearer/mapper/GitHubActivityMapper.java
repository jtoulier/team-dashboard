package com.bcp.transform1.teamdashboard.restapi.bearer.mapper;

import com.bcp.transform1.teamdashboard.restapi.bearer.dto.GitHubActivityIn;
import com.bcp.transform1.teamdashboard.restapi.bearer.dto.GitHubActorIn;
import com.bcp.transform1.teamdashboard.restapi.bearer.vo.GitHubActivityVO;
import com.bcp.transform1.teamdashboard.restapi.bearer.vo.GitHubActorVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {GitHubActorMapper.class}
)
public interface GitHubActivityMapper {
    GitHubActivityIn mapVOToIn(GitHubActivityVO gitHubActivityVO);

    @Mapping(source="activity_type", target="activityType")
    @Mapping(source = "gitHubActivityIn.actor", target = "gitHubActorVO")
    GitHubActivityVO mapInToVO(GitHubActivityIn gitHubActivityIn);


    //List<GitHubActivityIn> mapListVOToListIn(List<GitHubActivityVO> gitHubActivityVOList);

    List<GitHubActivityVO> mapListInToListVO(List<GitHubActivityIn> gitHubActivityInList);
}
