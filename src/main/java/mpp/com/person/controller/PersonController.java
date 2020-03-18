package mpp.com.person.controller;

import mpp.com.person.contract.PersonApi;
import mpp.com.person.contract.dto.PersonDTO;
import mpp.com.person.contract.dto.PaginatedResourceDTO;
import mpp.com.person.contract.dto.filters.PersonFiltersDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Valid
@RestController
public class PersonController implements PersonApi {

/*	@Autowired
	private CostumerService service;*/

	@Override
	public ResponseEntity<Void> save(@Valid @RequestBody PersonDTO costumer) {
//		final var obj = service.save(costumer);
		//retorna url com novo registro inserido
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
//				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		// Não está retornando a URI no corpo da response
//		return ResponseEntity.created(uri).build();
		return null;
	}

	@Override
	public ResponseEntity<PersonDTO> find(Long id) {
		return null;//ResponseEntity.ok().body(service.find(id));
	}

	@Override
	public ResponseEntity<List<PersonDTO>> findAll() {
		return null; //ResponseEntity.ok().body(service.findAll());
	}

	@Override
	public ResponseEntity<PersonDTO> update(@Valid @RequestBody PersonDTO dto, Long id) {
		return null;//ResponseEntity.ok().body(service.update(dto, id));
	}

	@Override
	public ResponseEntity<PaginatedResourceDTO<PersonDTO>> findPaginate(@Valid PersonFiltersDTO filters) {
		return null; // ResponseEntity.ok().body(service.findPaginate(filters));
	}
}

