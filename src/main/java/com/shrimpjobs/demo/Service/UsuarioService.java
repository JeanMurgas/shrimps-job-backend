package com.shrimpjobs.demo.Service;
import com.shrimpjobs.demo.Model.UserEntity;
import com.shrimpjobs.demo.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UserRepository repository;

    public UsuarioService(UserRepository repository) {
        this.repository = repository;
    }

    public List<UserEntity> listar() {
        return repository.findAll();
    }

    public UserEntity guardar(UserEntity usuario) {
        return repository.save(usuario);
    }

    public UserEntity buscarPorId(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }


}
