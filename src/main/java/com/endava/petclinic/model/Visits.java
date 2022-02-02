package com.endava.petclinic.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

@Data
@NoArgsConstructor
public class Visits {

    @EqualsAndHashCode.Exclude
    private Long id;
    private Pet pet;
    private String description;
    private String date;

    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return super.toString();
        }
    }
}
