package com.crossasyst.rpm.controller;

import com.crossasyst.rpm.model.PatientObs;
import com.crossasyst.rpm.response.PatientObsResponse;
import com.crossasyst.rpm.service.PatientObsService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@Tag(name = "Create pateintObs", description = "Create patientObs")
@RequestMapping(path = "v1")
@RestController
public class PatientObsController {
    @Autowired
    private final PatientObsService patientObsService;

    public PatientObsController(PatientObsService patientObsService) {
        this.patientObsService = patientObsService;
    }

    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @PostMapping(path = "/patientObs", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PatientObsResponse> createPatientObs(@RequestBody @Valid PatientObs patientObs) {
        return new ResponseEntity<>(patientObsService.createPatientObs(patientObs), HttpStatus.OK);
    }

    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @GetMapping(path = "/patients/{patientId}/patientObs", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PatientObsResponse>> getPatientObs(Long patientId) {
        List<PatientObsResponse> res=patientObsService.getPatientObs(patientId);
        if(CollectionUtils.isEmpty(res)){
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(res, HttpStatus.OK);

    }


}
