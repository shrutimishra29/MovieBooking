package com.moviebooking.theatreservice.config;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
@Endpoint(id = "release-notes")
public class CustomEndpoint {

    Map<String, List<String>> releaseNotesMap = new LinkedHashMap<>();

    @PostConstruct
    public void initNotes(){
        releaseNotesMap.put("version-1.0", Arrays.asList("Home page created.","Adding a new item form added."));
        releaseNotesMap.put("version-1.1", Arrays.asList("Reading from OMBb API added ", "Actuator Endpoints added."));
    }

    @ReadOperation
    public Map<String, List<String>> getReleaseNotes(){
        return releaseNotesMap;
    }


}
