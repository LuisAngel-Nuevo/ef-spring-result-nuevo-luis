package pe.edu.i20221272.ef_spring_result_nuevo_luis.dto;

public record CarDetallesDto(
        Integer car_id,
        String make,
        String model,
        String vin,
        String license_plate,
        String owner_name,
        String owner_contact,
        Integer mileage
) {
}
