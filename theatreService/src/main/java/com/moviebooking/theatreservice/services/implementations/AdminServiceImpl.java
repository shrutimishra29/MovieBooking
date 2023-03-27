package com.moviebooking.theatreservice.services.implementations;

import com.moviebooking.theatreservice.entities.Admin;
import com.moviebooking.theatreservice.exceptions.ResourceNotFoundException;
import com.moviebooking.theatreservice.repositories.AdminRepository;
import com.moviebooking.theatreservice.requests.AdminRequest;
import com.moviebooking.theatreservice.responses.AdminResponse;
import com.moviebooking.theatreservice.services.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public List<AdminResponse> getAllAdmins() {
        List<Admin> admins = adminRepository.findAll();
        List<AdminResponse> adminResponse = modelMapper.map(admins, ArrayList.class);
        return adminResponse;
    }

    @Override
    public AdminResponse getAdminById(int adminId) {
        Admin admin = adminRepository.findById(adminId).orElseThrow(() -> new ResourceNotFoundException("Admin user with the adminId not found"));
        return modelMapper.map(admin,AdminResponse.class);

    }

    @Override
    public Admin getAdminByUsername(String username) {
        return adminRepository.findByUsername(username);
    }



    @Override
    public AdminResponse saveAdmin(AdminRequest adminRequest) {
        Admin admin = modelMapper.map(adminRequest, Admin.class);
        adminRepository.save(admin);
        return modelMapper.map(admin,AdminResponse.class);
    }
}
