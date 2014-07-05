package com.springapp.mvc.repository;

import com.springapp.mvc.models.Contacto;
import javax.annotation.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by macbookpro on 04-07-14.
 */
@Resource(name="contactoRepository")
public interface ContactoRepository extends JpaRepository<Contacto,Long> {
}
