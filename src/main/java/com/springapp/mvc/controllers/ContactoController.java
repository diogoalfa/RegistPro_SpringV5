package com.springapp.mvc.controllers;

import com.springapp.mvc.models.ContactoEntity;
import com.springapp.mvc.models.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by macbookpro on 04-07-14.
 */
@Controller
public class ContactoController {


    @RequestMapping("/contacto")
    public String mostrarContacto(){
        return "contacto/contacto";
    }

    @RequestMapping("/guardarContacto")
    public String guardarContacto(@ModelAttribute("contacto") ContactoEntity contacto, BindingResult result){
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("persistenceUnit");
        EntityManager em=emf.createEntityManager();


        em.getTransaction().begin();
        ContactoEntity contactoEntity=new ContactoEntity();
        contactoEntity.setNombre(contacto.getNombre());
        contactoEntity.setCorreo(contacto.getCorreo());
        contactoEntity.setTelefono(contacto.getTelefono());
        em.persist(contactoEntity);
        em.getTransaction().commit();
        return "contacto/contacto";
    }

    //@Autowired
    //private ContactoRepository contactoRepository;

    @RequestMapping("/listarContacto")
    public String listarContacto(ModelMap modelMap){
      //  modelMap.addAttribute("contacto",new ContactoEntity());
       // modelMap.addAttribute("contactos",contactoRepository.findAll());
        return "contacto/contacto";
    }
}
