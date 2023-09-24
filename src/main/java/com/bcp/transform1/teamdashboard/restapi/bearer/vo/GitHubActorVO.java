package com.bcp.transform1.teamdashboard.restapi.bearer.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Data
public class GitHubActorVO {
    private String login;
    private String type ;
    private String url;

}