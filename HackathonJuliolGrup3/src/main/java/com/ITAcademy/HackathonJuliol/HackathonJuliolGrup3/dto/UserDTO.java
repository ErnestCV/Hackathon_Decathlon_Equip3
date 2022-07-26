package com.ITAcademy.HackathonJuliol.HackathonJuliolGrup3.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {    
    private String idUser;
    private String reputation;
    @Builder.Default
    private List<SportDTO> sports = new ArrayList<SportDTO>();
    
}
