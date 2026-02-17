package com.example.projeto.service;

import com.example.projeto.model.User;
import com.example.projeto.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public User save(User user) {
        if (user.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        return repository.save(user);
    }

    public User update(Long id, User user) {
        User existing = findById(id);
        if (existing == null) throw new RuntimeException("Usuário não encontrado");

        existing.setNome(user.getNome());
        existing.setEmail(user.getEmail());
        existing.setPassword(user.getPassword());
        existing.setRole(user.getRole());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
