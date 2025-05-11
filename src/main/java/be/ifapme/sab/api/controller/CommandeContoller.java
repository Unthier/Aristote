package be.ifapme.sab.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import be.ifapme.sab.api.dto.CommandeDTO;
import be.ifapme.sab.api.dto.UserDTO;
import be.ifapme.sab.db.model.UserEntity;
import be.ifapme.sab.domain.service.CommandeService;
import be.ifapme.sab.domain.service.UserService;

@RestController
@RequestMapping("/Commande")
public class CommandeContoller {
    private final CommandeService commandeService;

    public CommandeContoller(CommandeService commandeService) {
        this.commandeService = commandeService;
    }


    @PreAuthorize("hasAnyRole(RolesEnum.AMIN)")
    @GetMapping("")
    public List<CommandeDTO> getAllCommande() {
        return commandeService.getAllCommande();
    }

    @GetMapping("")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public CommandeDTO store(@RequestBody Integer id) throws Exception{
        return this.commandeService.getCommandeById(id);
    }

}
