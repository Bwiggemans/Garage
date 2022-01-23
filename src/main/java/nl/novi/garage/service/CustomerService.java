package nl.novi.garage.service;

import nl.novi.garage.dto.CustomerRequestDto;
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

    @Autowired
    private CarRepository carRepository;

    public Iterable<Customer> getCustomers(String name){
        if (name.isEmpty()){
            return customerRepository.findAll();
        }
        else {
            return customerRepository.findAllByNameContainingIgnoreCase(name);
        }
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

    public int addCustomer(CustomerRequestDto customerRequestDto){

        String email = customerRequestDto.getEmail();
        List<Customer> customers = (List<Customer>)customerRepository.findAllByEmail(email);
        if (customers.size() > 0) {
            throw new BadRequestException("E-mail already exists!!!");
        }
        Customer customer = new Customer();
        customer.setName(customerRequestDto.getName());
        customer.setAdress(customerRequestDto.getAdress());
        customer.setResidence(customerRequestDto.getResidence());
        customer.setPostalCode(customerRequestDto.getPostalCode());
        customer.setEmail(customerRequestDto.getEmail());
        customer.setAreaCode(customerRequestDto.getAreaCode());
        customer.setPhoneNumber(customerRequestDto.getPhoneNumber());

        Customer newCustomer = customerRepository.save(customer);
        return newCustomer.getId();
    }

    public void updateCustomer(int id, Customer customer){

        Customer existingCustomer = customerRepository.findById(id).orElse(null);

        if (!customer.getName().isEmpty()) {
            existingCustomer.setName(customer.getName());
        }
        if (!customer.getAdress().isEmpty()) {
            existingCustomer.setAdress(customer.getAdress());
        }
        if (!customer.getResidence().isEmpty()) {
            existingCustomer.setResidence(customer.getResidence());
        }
        if (!customer.getPostalCode().isEmpty()) {
            existingCustomer.setPostalCode(customer.getPostalCode());
        }
        if (!customer.getEmail().isEmpty()) {
            existingCustomer.setEmail(customer.getEmail());
        }
        if ((customer.getAreaCode()) != (existingCustomer.getAreaCode())){
            existingCustomer.setAreaCode(customer.getAreaCode());
        }
        if ((customer.getPhoneNumber()) != (existingCustomer.getPhoneNumber())){
            existingCustomer.setPhoneNumber(customer.getPhoneNumber());
        }
        customerRepository.save(existingCustomer);
    }

    public void partialUpdateCustomer(int id, Customer customer){

        Customer existingCustomer = customerRepository.findById(id).orElse(null);

        if (!(customer.getName()==null) && !customer.getName().isEmpty()){
            existingCustomer.setName(customer.getName());
        }
        if (!(customer.getAdress()==null) && !customer.getAdress().isEmpty()){
            existingCustomer.setAdress(customer.getAdress());
        }
        if (!(customer.getResidence()==null) && !customer.getResidence().isEmpty()){
            existingCustomer.setResidence(customer.getResidence());
        }
        if (!(customer.getPostalCode()==null) && !customer.getPostalCode().isEmpty()){
            existingCustomer.setPostalCode(customer.getPostalCode());
        }
        if (!(customer.getEmail()==null) && !customer.getEmail().isEmpty()){
            existingCustomer.setEmail(customer.getEmail());
        }
        if ((customer.getAreaCode()) != (existingCustomer.getAreaCode())){
            existingCustomer.setAreaCode(customer.getAreaCode());
        }
        if ((customer.getPhoneNumber()) != (existingCustomer.getPhoneNumber())){
            existingCustomer.setPhoneNumber(customer.getPhoneNumber());
        }
        customerRepository.save(existingCustomer);
    }

    public Iterable<Car> getCustomerCars(int id){
        Optional<Customer> optionalCustomer = customerRepository.findById(id);

        if (optionalCustomer.isPresent()){
            Customer customer = optionalCustomer.get();
            return customer.getCars();
        }
        else {
            //exception create
            throw new RecordNotFoundException("ID does not exist!!!");
        }
    }

    public void addCustomerCar(int id, Car car){
        Optional<Customer> optionalCustomer = customerRepository.findById(id);

        if (optionalCustomer.isPresent()){
            Customer customer = optionalCustomer.get();
            List<Car> cars = customer.getCars();

            cars.add(car);
            car.setOwner(customer);
            customerRepository.save(customer);
            carRepository.save(car);
        }
        else {
            //exception create
            throw new RecordNotFoundException("ID does not exist!!!");
        }
    }
}
