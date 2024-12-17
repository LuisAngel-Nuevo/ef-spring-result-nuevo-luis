package pe.edu.i20221272.ef_spring_result_nuevo_luis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.i20221272.ef_spring_result_nuevo_luis.dto.CarDetallesDto;
import pe.edu.i20221272.ef_spring_result_nuevo_luis.dto.CarDto;
import pe.edu.i20221272.ef_spring_result_nuevo_luis.dto.CarUpdateDto;
import pe.edu.i20221272.ef_spring_result_nuevo_luis.entity.Car;
import pe.edu.i20221272.ef_spring_result_nuevo_luis.repository.CarRepository;
import pe.edu.i20221272.ef_spring_result_nuevo_luis.service.ManageService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    CarRepository carRepository;

    @Override
    public List<CarDto> getAllCars() throws Exception {
        List<CarDto> carDtos = new ArrayList<CarDto>();
        Iterable<Car> carIterable = carRepository.findAll();
        carIterable.forEach(car -> {
            CarDto carlist = new CarDto(
                    car.getCar_id(),
                    car.getLicense_plate(),
                    car.getOwner_name(),
                    car.getOwner_contact(),
                    car.getEngine_type(),
                    car.getColor(),
                    car.getInsurance_company(),
                    car.getInsurance_policy_number(),
                    car.getRegistration_expiration_date(),
                    car.getService_due_date()
            );
                 carDtos.add(carlist);
        });
        return carDtos;
    }

    @Override
    public Optional<CarDetallesDto> getCarById(Integer id) throws Exception {
        Optional<Car> optional =carRepository.findById(id);
        return optional.map(car -> new CarDetallesDto(car.getCar_id(),
                car.getMake(), car.getModel(), car.getVin(), car.getLicense_plate(),
                car.getOwner_name(), car.getOwner_contact(), car.getMileage()));

    }

    @Override
    public boolean updateCar(CarDto carDto) throws Exception {

        Optional<Car> optional = carRepository.findById(carDto.car_id());
        return optional.map(car -> {
            car.setLicense_plate(carDto.license_plate());
            car.setOwner_name(carDto.owner_name());
            car.setOwner_contact(carDto.owner_contact());
            car.setEngine_type(carDto.engine_type());
            car.setColor(carDto.color());
            car.setInsurance_company(carDto.insurance_company());
            car.setInsurance_policy_number(carDto.insurance_policy_number());
            car.setRegistration_expiration_date(carDto.registration_expiration_date());
            car.setService_due_date(carDto.service_due_date());
            carRepository.save(car);
            return true;
        }).orElse(false);

    }

    @Override
    public boolean deleteCarById(Integer id) throws Exception {
        Optional<Car> optional = carRepository.findById(id);
        return optional.map(car -> {
            carRepository.delete(car);
            return true;
        }).orElse(false);
    }

    @Override
    public boolean addCar(CarUpdateDto updateDto) throws Exception {
        Optional<Car> optional = carRepository.findById(updateDto.car_id());
        if (!optional.isPresent())
            return false;
        else {
            Car car = optional.get();
            car.setMake(updateDto.make());
            car.setModel(updateDto.model());
            car.setYear(updateDto.year());
            car.setVin(updateDto.vin());
            car.setLicense_plate(updateDto.license_plate());
            car.setOwner_name(updateDto.owner_name());
            car.setOwner_contact(updateDto.owner_contact());
            car.setPurchase_date(updateDto.purchase_date());
            car.setEngine_type(updateDto.engine_type());
            car.setColor(updateDto.color());
            car.setInsurance_company(updateDto.insurance_company());
            car.setInsurance_policy_number(updateDto.insurance_policy_number());
            car.setRegistration_expiration_date(updateDto.registration_expiration_date());
            car.setService_due_date(updateDto.service_due_date());
            carRepository.save(car);
            return true;
        }

    }
}
