package br.com.starbank.repository;

import br.com.starbank.model.AddressModel;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<AddressModel, String> {
}
