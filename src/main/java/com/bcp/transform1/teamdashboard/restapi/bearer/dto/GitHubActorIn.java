package com.bcp.transform1.teamdashboard.restapi.bearer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Data
public class GitHubActorIn {
    private String login;
    private String id;
    private String type ;
    private String url;

}
