package com.crud.senaicrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crud.senaicrud.models.Usuario;
import com.crud.senaicrud.repository.CrudRepositorio;

@Controller
public class CrudControlle {
	
	@Autowired
	private CrudRepositorio csr;

	@RequestMapping(value="/cadastrarUsuario", method=RequestMethod.GET)
	public String cadastrarUsuario() {
		return "crud/cadastrar-usuario";
	}
	
	@RequestMapping(value="/cadastrarUsuario", method=RequestMethod.POST)
	public String cadastrarUsuario(Usuario usuario) {
		csr.save(usuario);
		return "redirect:/";
	}
	
	@RequestMapping("/")
	public ModelAndView listarUsuarios() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Usuario> usuarios = csr.findAll();
		mv.addObject("usuarios", usuarios);
		return mv;
	}
	
	@RequestMapping(value="/alterarUsuario/{idUsuario}", method=RequestMethod.GET)
	public ModelAndView alterarUsuario(@PathVariable("idUsuario") long idUsuario) {
		Usuario usuario = csr.findByIdUsuario(idUsuario);
		ModelAndView mv = new ModelAndView("crud/atualizar-usuario");
		mv.addObject("usuario", usuario);
		return mv;
	}
	
	@RequestMapping(value="/alterarUsuario/{idUsuario}", method=RequestMethod.POST)
	public String atualizarUsuario(@Validated Usuario usuario, BindingResult result, RedirectAttributes attributes) {
		csr.save(usuario);
		return "redirect:/";
	}
	
//	@RequestMapping(path="/alterarUsuario/{idUsuario}", method=RequestMethod.PUT)
//	public String atualizarUsuario(long idUsuario) {
//		Usuario usuario = csr.findByIdUsuario(idUsuario);
//		csr.save(usuario);
//		return "redirect:/";
//	}
	
	@RequestMapping("/confirmarExclusaoUsuario/{idUsuario}")
	public ModelAndView confirmarExclusaoUsuario(@PathVariable("idUsuario") long idUsuario) {
		Usuario usuario = csr.findByIdUsuario(idUsuario);
		ModelAndView mv = new ModelAndView("crud/excluir-usuario");
		mv.addObject("usuario", usuario);
		return mv;
	}
	
	@RequestMapping("/excluirUsuario")
	public String excluirUsuario(long idUsuario) {
		Usuario usuario = csr.findByIdUsuario(idUsuario);
		csr.delete(usuario);
		return "redirect:/";
	}
}