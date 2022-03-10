package br.com.starbank.repository;

import br.com.starbank.model.AddressModel;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AddressRepository extends CrudRepository<AddressModel, UUID> {
}
