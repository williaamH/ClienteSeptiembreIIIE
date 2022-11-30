package idatcom.ClienteMicroServicioIIIE.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idatcom.ClienteMicroServicioIIIE.dto.ClienteDTO;
import idatcom.ClienteMicroServicioIIIE.model.Cliente;
import idatcom.ClienteMicroServicioIIIE.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Override
	public List<ClienteDTO> listar() {
		
		List<ClienteDTO> listadto = new ArrayList<>();
		ClienteDTO dto = null;
		
		for(Cliente cliente : repository.findAll()) {
			dto = new ClienteDTO();
			dto.setCod(cliente.getIdCliente());
			dto.setNom(cliente.getNombre());
			dto.setTel(cliente.getTelefono());
			
			listadto.add(dto);
		}
		return listadto;
		
	}

	@Override
	public ClienteDTO obtener(Integer idCliente) {
		
		Cliente cliente = repository.findById(idCliente).orElse(null);
		
		ClienteDTO dto = new ClienteDTO();
		dto = new ClienteDTO();
		dto.setCod(cliente.getIdCliente());
		dto.setNom(cliente.getNombre());
		dto.setTel(cliente.getTelefono());
		
		return dto;
	}

	@Override
	public void guardar(ClienteDTO cliente) {
		
		Cliente cli = new Cliente();
		cli.setIdCliente(cliente.getCod());
		cli.setNombre(cliente.getNom());
		cli.setTelefono(cliente.getTel());
		repository.save(cli);

	}

	@Override
	public void actualizar(ClienteDTO cliente) {
		
		Cliente cli = new Cliente();
		cli.setIdCliente(cliente.getCod());
		cli.setNombre(cliente.getNom());
		cli.setTelefono(cliente.getTel());
		repository.saveAndFlush(cli);

	}

	@Override
	public void eliminar(Integer idCliente) {
		
		repository.deleteById(idCliente);
		
	}

}
