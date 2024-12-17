package pe.edu.i20221272.ef_spring_result_nuevo_luis.response;

import pe.edu.i20221272.ef_spring_result_nuevo_luis.dto.CarDto;

import java.util.List;

public record FindCarsResponse(String code,
                               String error,
                               List<CarDto> cars) {
}
