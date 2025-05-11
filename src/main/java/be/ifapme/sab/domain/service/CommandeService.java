package be.ifapme.sab.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import be.ifapme.sab.api.dto.ArticleDTO;
import be.ifapme.sab.api.dto.CommandeDTO;
import be.ifapme.sab.db.repository.ArticleRepository;
import be.ifapme.sab.db.repository.CommandeRepository;

@Service
public class CommandeService {
    
    private final CommandeRepository commandeRepository;

    public CommandeService(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    public List<CommandeDTO> getAllCommande(){
        return this.commandeRepository.findAll().stream()
                 .map(commande ->
                         new CommandeDTO(commande.getName())
                 ).toList();
    }

    public CommandeDTO getCommandeById(Integer id) throws Exception{
        return (CommandeDTO) this.commandeRepository.findById(Long.valueOf(id)).stream()
                 .map(commande -> new CommandeDTO(commande.getName())
                 );
    }

}
