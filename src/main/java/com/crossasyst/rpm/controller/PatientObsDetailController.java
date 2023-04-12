package com.crossasyst.rpm.controller;

import com.crossasyst.rpm.service.PatientObsDetailService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@Tag(name = "Create patientObsDetail", description = "Create patientObsDetail")
@RequestMapping(path = "v1")
@RestController
public class PatientObsDetailController {
    @Autowired
    private final PatientObsDetailService patientObsDetailService;

    public PatientObsDetailController(PatientObsDetailService patientObsDetailService) {
        this.patientObsDetailService = patientObsDetailService;
    }

//    @ApiResponse(responseCode = "200", description = "Success")
//    @ApiResponse(responseCode = "400", description = "Invalid request")
//    @ApiResponse(responseCode = "404", description = "Not found")
//    @ApiResponse(responseCode = "500", description = "System error")
//    @GetMapping(path = "/{patientObsId}/patientObsDetails", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<PatientObsDetailResponse>> getPatientObsDetail(@PathVariable Long patientObsId) {
//        List<PatientObsDetailResponse> patientObsDetailResponses = patientObsDetailService.getPatientObsDetail(patientObsId);
//        return new ResponseEntity<>(patientObsDetailResponses, HttpStatus.OK);
//
//    }
}
