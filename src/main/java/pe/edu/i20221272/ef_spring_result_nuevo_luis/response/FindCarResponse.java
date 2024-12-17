package pe.edu.i20221272.ef_spring_result_nuevo_luis.response;

import pe.edu.i20221272.ef_spring_result_nuevo_luis.dto.CarDetallesDto;
import pe.edu.i20221272.ef_spring_result_nuevo_luis.dto.CarDto;

import java.util.List;
import java.util.Optional;

public record FindCarResponse(
        String code,
        String error,
        CarDetallesDto carDetallesDto
) {
}
