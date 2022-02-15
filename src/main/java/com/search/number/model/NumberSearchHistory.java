package com.search.number.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "number_search_history")
public class NumberSearchHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @JsonIgnore
    private Long id;

    @JsonIgnore
    private int number;

    private boolean result;

    @JsonProperty("first-insert-date-time")
    private Long firstInsertDateTime;

    @JsonProperty("last-search-date-time")
    private Long lastSearchDateDime;

    @JsonProperty("search-count")
    private String searchCount = "0";

    @JsonIgnore
    private int count = 0;

}
