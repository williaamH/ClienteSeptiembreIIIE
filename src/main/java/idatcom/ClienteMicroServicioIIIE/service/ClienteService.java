package idatcom.ClienteMicroServicioIIIE.service;

import java.util.List;

import idatcom.ClienteMicroServicioIIIE.dto.ClienteDTO;

public interface ClienteService {
	
	List<ClienteDTO> listar();
	ClienteDTO obtener(Integer idCliente);
	void guardar(ClienteDTO cliente);
	void actualizar(ClienteDTO cliente);
	void eliminar(Integer idCliente);

}
