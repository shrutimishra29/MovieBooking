package com.moviebooking.theatreservice.mapper;

import com.moviebooking.theatreservice.entities.Admin;
import com.moviebooking.theatreservice.requests.AdminRequest;
import com.moviebooking.theatreservice.responses.AdminResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminMapper {

    AdminMapper adminMapper = Mappers.getMapper(AdminMapper.class);
    Admin formRequestToEntity(AdminRequest adminRequest);

    AdminResponse formEntityToResponse(Admin admin);
}
