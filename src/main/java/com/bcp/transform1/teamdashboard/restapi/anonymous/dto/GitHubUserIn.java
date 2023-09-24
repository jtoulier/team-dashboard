package com.bcp.transform1.teamdashboard.restapi.anonymous.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Data
public class GitHubUserIn {
    private String login;
    private String id;
    private String name;
    private String type;
}