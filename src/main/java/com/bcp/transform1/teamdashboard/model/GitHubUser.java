package com.bcp.transform1.teamdashboard.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Data
public class GitHubUser {
    private String login;
    private String id;
    private String name;
    private String type;
}
