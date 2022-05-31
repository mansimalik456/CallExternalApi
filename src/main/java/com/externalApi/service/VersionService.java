package com.externalApi.service;

import org.springframework.stereotype.Service;

import com.externalApi.dto.VersionDataDto;


@Service
public interface VersionService {
	
	public Object saveVersionData();
	
	Object createVersion(VersionDataDto version);
}
