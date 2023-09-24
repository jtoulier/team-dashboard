package com.bcp.transform1.teamdashboard.restapi.bearer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Data
public class GitHubActivityIn {
    private String id;
    private String nodeId;
    private String activity_type;
    private String timestamp;
    private GitHubActorIn actor;
}