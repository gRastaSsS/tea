package edu.fluffytiger.tea.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
public class CreateEventRequest {
    @Setter @Getter
    private String name;
    @Setter @Getter
    private String description;
    @Setter @Getter
    private String place;
    @Setter @Getter
    private LocalDate date;
    @Setter @Getter
    private boolean custom;
    @Setter @Getter
    private List<LocalDate> notifyAt;
}
