package idatcom.ClienteMicroServicioIIIE.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import idatcom.ClienteMicroServicioIIIE.dto.ClienteDTO;
import idatcom.ClienteMicroServicioIIIE.service.ClienteService;

@Controller
@RequestMapping("api/cliente/v1")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping("/listar")
	public @ResponseBody List<ClienteDTO> listar(){
		return service.listar();
	}
	
	@GetMapping("/listar/{id}")
	public @ResponseBody ClienteDTO obtenerId(@PathVariable Integer id) {
		return service.obtener(id);
	}
	
	@PostMapping("/guardar")
	public @ResponseBody void guardar(@RequestBody ClienteDTO dto) {
		service.guardar(dto);
	}
	
	@PutMapping("/actualizar")
	public @ResponseBody void actualizar(@RequestBody ClienteDTO dto) {
		service.actualizar(dto);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public @ResponseBody void eliminar(@PathVariable Integer id) {
		service.eliminar(id);
	}
}
