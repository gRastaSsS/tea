package edu.fluffytiger.tea.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "emails_table")
    private Set<String> emails;
}
