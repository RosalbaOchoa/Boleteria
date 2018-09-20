package com.servipuedosv.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.servipuedosv.models.entities.Cliente;
import com.servipuedosv.models.services.IClienteService;


@Controller
@SessionAttributes("cliente")
public class ClienteControllers {
	
	@Autowired
	private IClienteService ClienteService;
	
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("title","listado de cliente");
		model.addAttribute("customers", ClienteService.findAll());
		return "listar";
	}
	
	@RequestMapping(value="/form")
	public String crear(Map<String, Object> model) {
		Cliente cliente = new Cliente();
		model.put("cliente", cliente);
		model.put("title", "Formulario de cliente");
		return "form";
	}
	
	@RequestMapping(value="/form", method=RequestMethod.POST)
	public String guardar(@Valid Cliente cliente, BindingResult bindingResult, RedirectAttributes flash, SessionStatus sessionStatus ) {
		if(bindingResult.hasErrors()) {
			return "form";
		}
		ClienteService.save(cliente);
		sessionStatus.setComplete();
		
		flash.addFlashAttribute("success","Cliente creado con exito");
		return "redirect:listar";
	}
	
	@RequestMapping(value="/form/{cli_num_documento}")
	public String editar(@PathVariable(value="cli_num_documento") Long cli_num_documento, Map<String, Object> model, RedirectAttributes flash) {
		Cliente cliente = null;
		if (cli_num_documento > 0) {
			cliente = ClienteService.findOne(cli_num_documento);
		}else {
			flash.addFlashAttribute("error","El Id del cliente no puede ser cero");
			return "redirect:/listar";
		}
		model.put("customer", cliente);
		model.put("title", "Editar Cliente");
		
		return "form";
	}
	
	@RequestMapping(value="/eliminar/{cli_num_documento}")
	public String eliminar(@PathVariable(value="cli_num_documento") Long cli_num_documento, RedirectAttributes flash) {
		if (cli_num_documento > 0 ) {
			ClienteService.delete(cli_num_documento);
		}
		flash.addFlashAttribute("success","Cliente eliminado con exito");
		return "redirect:/listar";
	}
	
	@RequestMapping(value="/ver/{cli_num_documento}", method=RequestMethod.GET)
	public String ver(@PathVariable(value = "cli_num_documento") Long cli_num_documento, Map<String, Object> model, RedirectAttributes flashl) {
		Cliente cliente = ClienteService.findOne(cli_num_documento);
		if (cliente == null) {
			flashl.addFlashAttribute("error", "El cliente no existe en la base de datos");
			return "redirect:/listar";
		}

		model.put("cliente", cliente);
		model.put("titulo", "Editar Cliente");
		return "ver";
	}

}
