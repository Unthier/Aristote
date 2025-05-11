package be.ifapme.sab.api.controller;


import be.ifapme.sab.api.dto.UserDTO;
import be.ifapme.sab.db.model.UserEntity;
import be.ifapme.sab.domain.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PreAuthorize("hasAnyRole(RolesEnum.AMIN)")
    @GetMapping(name="/{id}", produces = "application/json")
    public UserDTO getUserBy(String id) {

        if (id == null || id.isEmpty() || id.trim().isEmpty()) {
            return null;
        }
        if (!id.matches("\\d+")) {
            return null;
        }
        return userService.getUserBy(Long.parseLong(id));
    }

    /*@PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void store(@RequestBody Article article) {
        this.articleSpringDataRepository.save(article);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        this.articleSpringDataRepository.deleteById(id);
    }*/

    @PutMapping("/{id}")
    public void update(@RequestBody UserEntity user) {
        this.userService.save(user);
    }
}
