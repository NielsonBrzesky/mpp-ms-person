package mpp.com.person.contract;
import mpp.com.person.contract.dto.PersonDTO;
import mpp.com.person.contract.dto.PaginatedResourceDTO;
import mpp.com.person.contract.dto.filters.PersonFiltersDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/v1/persons/")
public interface PersonApi extends GenericApi<PersonDTO, PersonFiltersDTO> {
	
	@Override
	@ApiOperation(value="Inclusão de custumer")
	@PostMapping()
	public ResponseEntity<Void> save(@Valid @RequestBody PersonDTO dto);
	
	@Override
	@ApiOperation(value="Busca por person-id")
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "person não encontrado") })
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<PersonDTO> find(@PathVariable Long id);
	
	@Override
	@ApiOperation(value="Busca por todos pessoas")
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "nenhuma pessoa encontrada") })
	@GetMapping
	public ResponseEntity<List<PersonDTO>> findAll();

	@Override
	@ApiOperation(value="Alterar por person-id")
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "person não encontrado") })
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<PersonDTO> update(final @Valid @RequestBody PersonDTO dto, Long id);

	@ApiOperation(value="Busca De person Paginada")
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "nenhum person encontrado") })
	@GetMapping("/paginate")
	ResponseEntity<PaginatedResourceDTO<PersonDTO>> findPaginate(@SpringQueryMap @Valid final PersonFiltersDTO filters);
}
