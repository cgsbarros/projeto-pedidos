package com.cauabarros.aulajpacurso.services;

import com.cauabarros.aulajpacurso.entities.User;
import com.cauabarros.aulajpacurso.repositories.UserRepository;
import com.cauabarros.aulajpacurso.services.exceptions.DatabaseException;
import com.cauabarros.aulajpacurso.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class UserService {
    @Autowired
    private UserRepository repository;
    public List<User> findAll(){
        return repository.findAll();
    }
    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
    public User insert(User obj){
        return repository.save(obj);
    }
    public void delete(Long id) {
        try {
            if (!repository.existsById(id)) {
                System.out.println("Erro: Usuário não encontrado!");
                throw new ResourceNotFoundException(id);
            }
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
    public User update(Long id, User obj){
        try {
            User entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }
    public void updateData(User entity ,User obj){
        entity.setNome(obj.getNome());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }

}
