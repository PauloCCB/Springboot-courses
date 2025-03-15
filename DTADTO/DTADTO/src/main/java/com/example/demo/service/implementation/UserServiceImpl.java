package com.example.demo.service.implementation;

import com.example.demo.persistence.dao.interfaces.IUserDAO;
import com.example.demo.persistence.entity.UserEntity;
import com.example.demo.presentation.DTO.UserDTO;
import com.example.demo.service.interfaces.IUserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDAO userDao;

    @Override
    public List<UserDTO> findAll() {
        ModelMapper modelMapper = new ModelMapper();
        //Convierte el Entidad a DTO  y luego lo retorna a una lista
        return this.userDao.findAll()
                        .stream()
                //Un stream es una forma de procesamiento secuencial o paralelo de elementos,
                // que permite realizar operaciones en cada elemento de la colección sin tener
                // que escribir bucles tradicionales como for o while.
                        .map(entity->modelMapper.map(entity, UserDTO.class)).
                        collect(Collectors.toList());
    }

    @Override
    public UserDTO findById(Long id) {
        Optional<UserEntity> userEntityOptional=this.userDao.findById(id);
        if(userEntityOptional.isPresent()){
            ModelMapper modelMapper = new ModelMapper();
            UserEntity currentUser= userEntityOptional.get();
            return modelMapper.map(currentUser,UserDTO.class);
        }else{
            return new UserDTO();
        }
    }

    @Override
    public UserDTO createrUser(UserDTO userDTO) {
        try {
            ModelMapper modelMapper=new ModelMapper();
            // Convertirmos un DTO en un Entity para que se pueda guardar
            UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
            this.userDao.saveUser(userEntity);
            return userDTO;
        }catch(Exception e){
            throw new UnsupportedOperationException("Error al guardar el usuario");
        }
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, Long id) {
        Optional<UserEntity> userEntity= this.userDao.findById(id);
        if(userEntity.isPresent()){
            UserEntity currentUserEntity=userEntity.get();
            currentUserEntity.setName(userDTO.getName());
            currentUserEntity.setEmail(userDTO.getEmail());
            currentUserEntity.setAge(userDTO.getAge());

            this.userDao.updateUser(currentUserEntity);

            ModelMapper modelMapper=new ModelMapper();
            return modelMapper.map(currentUserEntity,UserDTO.class);
        }else{
            throw new IllegalArgumentException("El usuario no existe");
        }

    }

    @Override
    public String deleteUser(Long id) {
        Optional<UserEntity> userEntity= this.userDao.findById(id);

        if(userEntity.isPresent()){
            UserEntity currentUserEntity=userEntity.get();
            this.userDao.deleteUser(currentUserEntity);
            return "Usuario con ID " + id +" ha sido eliminado";
        }else{
            return "El usuario con ID" + " no existe";
        }

    }
}
