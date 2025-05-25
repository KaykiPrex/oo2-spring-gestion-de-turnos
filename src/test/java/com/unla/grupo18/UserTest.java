package com.unla.grupo18;

import com.unla.grupo18.model.Contact;
import com.unla.grupo18.model.User;
import com.unla.grupo18.repositories.IUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserTest {
    @Autowired
    private IUserRepository usuarioService;

    @Test
    public void testCrearUsuario() {
        Contact contact = new Contact();
        contact.setMobile("154656465");
        contact.setWorkEmail("pepito@work.com");

        User usuario = new User();
        usuario.setName("pepito3");
        usuario.setPassword("claveSegura3");
        usuario.setContact(contact);

        contact.setUser(usuario);

        User guardado = usuarioService.save(usuario);

        assertNotNull(guardado.getId());  // Verifica que se guardó correctamente
    }

}
