package com.digisolfze.expedia.mapper;

import org.mapstruct.Mapper;

import com.digisolfze.expedia.bean.Offers;
import com.digisolfze.expedia.dto.OffersDTO;

/**
 * Mapper interface for mapping {@link Offers} entities to {@link OffersDTO} objects.
 * This interface utilizes MapStruct to perform the conversion between the entity
 * and DTO layers of the application. The conversion is intended to allow the transformation
 * of data from the internal model to a more suitable format for external exposure or further processing.
 * 
 * <p>The interface is annotated with {@code @Mapper} and uses Spring as the component model, which allows
 * MapStruct to automatically generate the implementation of the mapping logic and register it as a Spring Bean.</p>
 * 
 * @author Mohammed Nasro
 * 
 */
@Mapper(componentModel = "spring")
public interface OffersMapper {

    /**
     * Converts an {@link Offers} entity to its corresponding {@link OffersDTO}.
     * 
     * @param entity the {@link Offers} entity to be converted.
     * @return the corresponding {@link OffersDTO} object, or {@code null} if the input entity is {@code null}.
     */
    public OffersDTO toDTO(Offers entity);
}
