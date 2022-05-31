package com.externalApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.externalApi.dto.VersionDataDto;
import com.externalApi.model.VersionData;
import com.externalApi.service.VersionService;

@RestController
public class MyController {
	
	
	@Autowired VersionService versionService;
	
	@PostMapping("/addVersion")
	public ResponseEntity<Object> saveVersion(@RequestBody VersionDataDto version){
		Object saveVersion = versionService.createVersion(version);
		if(saveVersion != null) {
			return ResponseEntity.ok(saveVersion);
		}
		return null;
	}

}
