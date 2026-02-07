package com.shrimpjobs.demo.Controller;

import com.shrimpjobs.demo.Model.UserEntity;
import com.shrimpjobs.demo.Service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UserController {

    private final UsuarioService service;

    @GetMapping("/ping")
    public String ping() {
        return "Backend ShrimpJobs funcionando 🔥";
    }

    public UserController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<UserEntity> listar() {
        return service.listar();
    }

    @PostMapping
    public UserEntity crear(@RequestBody UserEntity usuario) {
        return service.guardar(usuario);
    }

    @GetMapping("/{id}")
    public UserEntity obtener(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }
}
