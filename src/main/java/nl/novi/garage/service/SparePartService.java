package nl.novi.garage.service;

import nl.novi.garage.dto.CustomerRequestDto;
import nl.novi.garage.dto.SparePartRequestDto;
import nl.novi.garage.exception.BadRequestException;
import nl.novi.garage.exception.RecordNotFoundException;
import nl.novi.garage.model.Customer;
import nl.novi.garage.model.SparePart;
import nl.novi.garage.repository.CustomerRepository;
import nl.novi.garage.repository.SparePartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SparePartService {

    @Autowired
    private SparePartRepository sparePartRepository;

    public Iterable<SparePart> getSpareParts(String part){
        if (part.isEmpty()){
            return sparePartRepository.findAll();
        }
        else {
            return sparePartRepository.findAllByPartContainingIgnoreCase(part);
        }
    }

    public SparePart getSparePart(int id){
        Optional<SparePart> optionalSparePart = sparePartRepository.findById(id);
        if (optionalSparePart.isPresent()){
            return optionalSparePart.get();
        }
        else {
            //exception create
            throw new RecordNotFoundException("ID does not exist!!!");
        }
    }

    public void deleteSparePart(int id){
        if (sparePartRepository.existsById(id)){
            sparePartRepository.deleteById(id);
        }
        else {
            throw new RecordNotFoundException("ID does not exist!!!");
        }
    }

    public int addSparePart(SparePartRequestDto sparePartRequestDto){

        String partNumber = sparePartRequestDto.getPartNumber();
        List<SparePart> spareParts = (List<SparePart>)sparePartRepository.findAllByPartNumber(partNumber);
        if (spareParts.size() > 0) {
            throw new BadRequestException("Partnumber already exists!!!");
        }
        SparePart sparePart = new SparePart();
        sparePart.setBrand(sparePartRequestDto.getBrand());
        sparePart.setPart(sparePartRequestDto.getPart());
        sparePart.setPartNumber(sparePartRequestDto.getPartNumber());
        sparePart.setPrice(sparePartRequestDto.getPrice());
        sparePart.setStock(sparePartRequestDto.getStock());

        SparePart newSparePart = sparePartRepository.save(sparePart);
        return newSparePart.getId();
    }

    public void updateSparePart(int id, SparePart sparePart){

        SparePart existingSparePart = sparePartRepository.findById(id).orElse(null);

        if (!sparePart.getBrand().isEmpty()) {
            existingSparePart.setBrand(sparePart.getBrand());
        }
        if (!sparePart.getPart().isEmpty()) {
            existingSparePart.setPart(sparePart.getPart());
        }
        if (!sparePart.getPartNumber().isEmpty()) {
            existingSparePart.setPartNumber(sparePart.getPartNumber());
        }
        if ((sparePart.getPrice()) != (existingSparePart.getPrice())){
            existingSparePart.setPrice(sparePart.getPrice());
        }
        if ((sparePart.getStock()) != (existingSparePart.getStock())){
            existingSparePart.setStock(sparePart.getStock());
        }
        sparePartRepository.save(existingSparePart);
    }

    public void partialUpdateSparePart(int id, SparePart sparePart){

        SparePart existingSparePart = sparePartRepository.findById(id).orElse(null);

        if (!(sparePart.getBrand()==null) && !sparePart.getBrand().isEmpty()){
            existingSparePart.setBrand(sparePart.getBrand());
        }
        if (!(sparePart.getPart()==null) && !sparePart.getPart().isEmpty()){
            existingSparePart.setPart(sparePart.getPart());
        }
        if (!(sparePart.getPartNumber()==null) && !sparePart.getPartNumber().isEmpty()){
            existingSparePart.setPartNumber(existingSparePart.getPartNumber());
        }
/*      This code does not work data will not be saved:
        if ((sparePart.getPrice()) != (existingSparePart.getPrice())){
            existingSparePart.setPrice(sparePart.getPrice());
        }
        if ((sparePart.getStock()) != (existingSparePart.getStock())){
            existingSparePart.setStock(sparePart.getStock());
        }
 */
        if (!(sparePart.getPrice()==null) && !sparePart.getPrice().describeConstable().isEmpty()){
            existingSparePart.setPrice(sparePart.getPrice());
        }

        if (!(sparePart.getStock()==null) && !sparePart.getStock().describeConstable().isEmpty()){
            existingSparePart.setStock(sparePart.getStock());
        }

        sparePartRepository.save(existingSparePart);
    }

}
