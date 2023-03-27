package com.moviebooking.theatreservice.controllers;

import com.moviebooking.theatreservice.entities.Admin;
import com.moviebooking.theatreservice.exceptions.ResourceNotFoundException;
import com.moviebooking.theatreservice.requests.AdminRequest;
import com.moviebooking.theatreservice.responses.AdminResponse;
import com.moviebooking.theatreservice.services.implementations.AdminServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.models.annotations.OpenAPI30;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@OpenAPI30
@RequestMapping("/theatre/admin")
public class AdminController {

    @Autowired
    AdminServiceImpl adminService;

    @Autowired
    ModelMapper modelMapper;


    @PostMapping
    @Operation(
            description = "Used to create Admin",
            responses = {
                    @ApiResponse(responseCode = "400",description = "Bad Request"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized access"),
                    @ApiResponse(responseCode = "200", description = "Successful Operation"),
                    @ApiResponse(responseCode = "500",description = "Server Error")
            }
    )
    public AdminResponse createAdmin(@Valid @RequestBody AdminRequest adminRequest) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        adminRequest.setPassword(passwordEncoder.encode(adminRequest.getPassword()));

        AdminResponse adminResponse = null;
        try {
            adminResponse = adminService.saveAdmin(adminRequest);
            log.trace("New Admin has been created.");

        } catch (Exception e) {
            log.error("Unable to create Admin.");
        }
        return adminResponse;
    }



    @GetMapping
    @Operation(
            description = "Used to get details of all admins",
            responses = {
                    @ApiResponse(responseCode = "400",description = "Bad Request"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized access"),
                    @ApiResponse(responseCode = "200", description = "Successful Operation"),
                    @ApiResponse(responseCode = "500",description = "Server Error")
            }
    )
    public List<AdminResponse> getAllAdmin(){

        List<AdminResponse> allAdmins = adminService.getAllAdmins();
        log.info("All admin details have been sent.");
        if(allAdmins == null){
            log.error("No admin found!!");
            throw new ResourceNotFoundException("No admins exist!");
        }
        return allAdmins;
    }

    @GetMapping("/{adminId}")
    @Operation(
            description = "Used to get Admin by admin id",
            responses = {
                    @ApiResponse(responseCode = "400",description = "Bad Request"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized access"),
                    @ApiResponse(responseCode = "200", description = "Successful Operation"),
                    @ApiResponse(responseCode = "500",description = "Server Error")
            }
    )
    public AdminResponse getAdminById(@PathVariable int adminId){
        AdminResponse adminById = adminService.getAdminById(adminId);
        log.info("Admin been id" + adminId + "has been sent.");
        if(adminById == null){
            log.error("Admin with id :"+ adminId + "does not exist.");
            throw new ResourceNotFoundException("Admin with id : "+ adminId + " does not exist.");
        }

       return adminById;
    }

}
