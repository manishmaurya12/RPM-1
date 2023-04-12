package com.crossasyst.rpm.controller;

import com.crossasyst.rpm.model.Obsterm;
import com.crossasyst.rpm.service.ObstermService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Create obsterm", description = "Create obsterm")
@RequestMapping(path = "v1")
@RestController
public class ObstermController {
    @Autowired
    private final ObstermService obstermService;

    public ObstermController(ObstermService obstermService) {
        this.obstermService = obstermService;
    }

    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @GetMapping(value = "/obsterms", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Obsterm>> getAllObsterm() {
        List<Obsterm> obstermList = obstermService.getAllObsterm();
        return new ResponseEntity<>(obstermList, HttpStatus.OK);
    }

    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @GetMapping(value = "/obsterms/{obstermId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Obsterm> getObsterm(@PathVariable Long obstermId) {
        Obsterm obsterm = obstermService.getObsterm(obstermId);
        return new ResponseEntity<>(obsterm, HttpStatus.OK);
    }


}
