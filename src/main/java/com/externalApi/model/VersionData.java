package com.externalApi.model;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "versiondata")
@Data
public class VersionData {
	
	private long buildNumber;
	private double version;
	private String buildType;
	private String updatedBy;
	private String branchName;
	private String repositoryUrl;
	private String revisionNumber;
	private LocalDateTime deploymentDate;

}
