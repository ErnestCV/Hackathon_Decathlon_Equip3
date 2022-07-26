package com.ITAcademy.HackathonJuliol.HackathonJuliolGrup3.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document("user")
public class User {
    @Id
    private String idUser;
    private String username;
    private String reputation;
    @Builder.Default
    private List<Sport> sports = new ArrayList<Sport>();
}
