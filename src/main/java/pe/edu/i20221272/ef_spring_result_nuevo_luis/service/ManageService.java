package pe.edu.i20221272.ef_spring_result_nuevo_luis.service;

import pe.edu.i20221272.ef_spring_result_nuevo_luis.dto.CarDetallesDto;
import pe.edu.i20221272.ef_spring_result_nuevo_luis.dto.CarDto;
import pe.edu.i20221272.ef_spring_result_nuevo_luis.dto.CarUpdateDto;

import java.util.List;
import java.util.Optional;

public interface ManageService {

    List<CarDto> getAllCars() throws Exception;

    Optional<CarDetallesDto> getCarById(Integer id) throws Exception;

    boolean updateCar(CarDto carDto) throws Exception;

    boolean deleteCarById(Integer id) throws Exception;

    boolean addCar(CarUpdateDto updateDto) throws Exception;

}
