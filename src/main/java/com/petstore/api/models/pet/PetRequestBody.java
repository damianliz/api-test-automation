package com.petstore.api.models.pet;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PetRequestBody {

    private int id;
    private String name;
    private PetCategory category;
    private List<String> photoUrls;
    private List<PetTags> tags;
    private String status;
}
