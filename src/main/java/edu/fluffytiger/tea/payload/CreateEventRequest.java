package edu.fluffytiger.tea.payload;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

public class CreateEventRequest {
    @Setter
    @Getter
    private String name;
    @Setter @Getter
    private String description;
    @Setter @Getter
    private String place;
}
