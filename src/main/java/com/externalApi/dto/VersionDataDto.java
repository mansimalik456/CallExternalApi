package com.externalApi.dto;

import lombok.Data;

@Data
public class VersionDataDto {
	
	private long buildNumber;
	private double version;
	private String buildType;
	private String updatedBy;
	private String branchName;
	private String repositoryUrl;
	private String revisionNumber;
	

}
