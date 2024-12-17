package pe.edu.i20221272.ef_spring_result_nuevo_luis.dto;

import java.util.Date;

public record CarDto(
        Integer car_id,
        String license_plate,
        String owner_name,
        String owner_contact,
        String engine_type,
        String color,
        String insurance_company,
        String insurance_policy_number,
        Date registration_expiration_date,
        Date service_due_date
) {
}
