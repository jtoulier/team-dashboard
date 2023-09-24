package com.bcp.transform1.teamdashboard.restapi.anonymous.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Data
public class GitHubUserVO {
    private String login;
    private String name;
    private String type;
}