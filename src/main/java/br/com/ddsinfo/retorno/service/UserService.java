package br.com.ddsinfo.retorno.service;

import br.com.ddsinfo.retorno.dto.UserDto;
import br.com.ddsinfo.retorno.entity.UserEntity;
import br.com.ddsinfo.retorno.exception.BusinessException;
import br.com.ddsinfo.retorno.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<UserEntity> findById(Long id) {
        return userRepository.findById(id);
    }

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public UserEntity alterarDados(UserDto userRequest) throws BusinessException {

        if (userRequest.getId() == null) {
            throw new BusinessException("Id não pode ser nulo");
        } else if (userRequest.getSenha() == null && userRequest.getUsuario() == null) {
            throw new BusinessException("Senha ou nome de usuario não pode ser vazio para criação de um usuário");
        }

        Optional<UserEntity> userEntityOptional = userRepository.findById(userRequest.getId());

        if (!userEntityOptional.isPresent()) {
            throw new BusinessException("Usuario não existe na base portanto não poderá ser alterado");
        }

        return userRepository.save(new UserEntity(userRequest.getId(), userRequest.getUsuario(), userRequest.getSenha()));
    }

    public UserEntity criarUsuario(UserDto userDto) throws BusinessException {

        if (userDto.getSenha() == null || userDto.getUsuario() == null) {
            throw new BusinessException("Senha ou nome de usuario não pode ser vazio para criação de um usuário");
        }

        return userRepository.save(new UserEntity(null, userDto.getUsuario(), userDto.getSenha()));

    }
}
