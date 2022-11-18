package com.codingmart.springbootkafkaproject.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "wikimedia_recentChange")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WikimediaData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String wikiEventData;
}