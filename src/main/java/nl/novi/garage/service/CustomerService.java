package nl.novi.garage.service;

import nl.novi.garage.dto.CarRequestDto;
import nl.novi.garage.exception.BadRequestException;
import nl.novi.garage.exception.RecordNotFoundException;
import nl.novi.garage.model.Car;
import nl.novi.garage.model.Customer;
import nl.novi.garage.repository.CarRepository;
import nl.novi.garage.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Iterable<Customer> getCustomers(String licencePlate){
            return customerRepository.findAll();
    }

    public Customer getCustomer(int id){
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()){
            return optionalCustomer.get();
        }
        else {
            //exception create
            throw new RecordNotFoundException("ID does not exist!!!");
        }
    }

    public void deleteCustomer(int id){
        if (customerRepository.existsById(id)){
            customerRepository.deleteById(id);
        }
        else {
            throw new RecordNotFoundException("ID does not exist!!!");
        }
    }

    public int addCustomer(Customer customer){

        Customer newCustomer = customerRepository.save(customer);
        return newCustomer.getId();
    }

}
