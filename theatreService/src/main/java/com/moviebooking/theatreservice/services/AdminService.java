package com.moviebooking.theatreservice.services;

import com.moviebooking.theatreservice.entities.Admin;
import com.moviebooking.theatreservice.requests.AdminRequest;
import com.moviebooking.theatreservice.responses.AdminResponse;

import java.util.List;

public interface AdminService {

    //Save admin details in database
    public Admin saveAdmin(Admin admin);

    //get all admins
    public List<AdminResponse> getAllAdmins();

    //get admin by id
    public AdminResponse getAdminById(int adminId);

    Admin getAdminByUsername(String username);

    //using Request to save and update Admin
    AdminResponse saveAdmin(AdminRequest adminRequest);
}
