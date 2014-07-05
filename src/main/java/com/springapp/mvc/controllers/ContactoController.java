package com.springapp.mvc.controllers;

import com.springapp.mvc.models.Contacto;
import com.springapp.mvc.repository.ContactoRepository;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by macbookpro on 04-07-14.
 */
@Controller
public class ContactoController {

    @Resource(name = "contactoRepository")
    private ContactoRepository contactoRepository;
    private static final Logger logger = LoggerFactory.getLogger(ContactoController.class);

    @RequestMapping("/contacto")
    public String mostrarContacto() {
        return "contacto/contacto";
    }

    @RequestMapping("/guardarContacto")
    public String guardarContacto(@ModelAttribute("contacto") Contacto contacto, BindingResult result) {

        Contacto guardado = contactoRepository.save(contacto);
        if (guardado != null) {
            logger.debug("Se almacenó contacto: {}", guardado.getNombre());
        } else {
            logger.debug("No se pudo persistir la aplicación");
        }

        return "contacto/contacto";
    }

    @RequestMapping("/listarContacto")
    public String listarContacto(ModelMap modelMap) {
        modelMap.addAttribute("contacto", new Contacto());
        modelMap.addAttribute("contactos", contactoRepository.findAll());
        return "contacto/contacto";
    }
}
