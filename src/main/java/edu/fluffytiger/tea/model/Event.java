package edu.fluffytiger.tea.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "events_table")
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter @Getter
    private Long id;
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
    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "emails_table")
    private Set<String> emails;
    @Setter @Getter
    @ElementCollection(targetClass = LocalDate.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "notify_dates_table")
    private List<LocalDate> notifyAt;
}
