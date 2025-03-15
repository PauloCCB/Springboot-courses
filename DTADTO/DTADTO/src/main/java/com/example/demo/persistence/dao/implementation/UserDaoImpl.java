package com.example.demo.persistence.dao.implementation;

import com.example.demo.persistence.dao.interfaces.IUserDAO;
import com.example.demo.persistence.entity.UserEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements IUserDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<UserEntity> findAll() {
        return this.em.createQuery(
                "SELECT u FROM UserEntity u"
        ).getResultList();
    }

    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public Optional<UserEntity> findById(Long id) {

        return Optional.ofNullable(this.em.find(UserEntity.class,id));
    }

    @Override
    @Transactional
    public void  saveUser(UserEntity userEntity) {
        this.em.persist(userEntity);
        this.em.flush(); // El flush me garantiza un commit
    }

    @Override
    public void updateUser(UserEntity userEntity) {
       this.em.merge(userEntity);
    }

    @Override
    public void deleteUser(UserEntity userEntity) {
        this.em.remove(userEntity);
    }
}
