package br.com.ddsinfo.retorno.controller;

import br.com.ddsinfo.retorno.dto.UserDto;
import br.com.ddsinfo.retorno.entity.UserEntity;
import br.com.ddsinfo.retorno.exception.BusinessException;
import br.com.ddsinfo.retorno.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/user/{id}")
    public ResponseEntity findUser(@PathVariable("id") Long id) {

        log.info("findUser() - ini - id: {}", id);
        try {

            Optional<UserEntity> userEntity = userService.findById(id);

            if (!userEntity.isPresent()) {
                log.info("findUser() - id não encontrado na base: {} - fim", id);
                return ResponseEntity.noContent().build();
            }

            log.info("findUser() - id: {} encontrado na base", id);
            log.info("findUser() - userEntity: {}", userEntity.get().toString());
            log.info("findUser() - fim");
            return ResponseEntity.ok(userEntity.get());

        } catch (Exception error) {
            log.error("findUser() - error: {}", error.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error.getMessage());
        }

    }

    @GetMapping(value = "/users")
    public ResponseEntity findAllUsers() {

        log.info("findUser() - ini");
        try {

            List<UserEntity> userEntity = userService.findAll();

            if (userEntity.isEmpty()) {
                log.info("findUser() - Nenhum usuário encontrado na base - fim");
                return ResponseEntity.noContent().build();
            }

            log.info("findUser() - fim");
            return ResponseEntity.ok(userEntity);

        } catch (Exception error) {
            log.error("findUser() - error: {}", error.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error.getMessage());
        }

    }

    @PutMapping(value = "/user")
    public ResponseEntity alterarDados(@RequestBody UserDto userDto) {

        log.info("alterarDados() - ini");
        try {

            UserEntity userEntityResponse = userService.alterarDados(userDto);

            if (userEntityResponse == null) {
                log.info("alterarDados() - Erro alterar usuario - fim");
                return ResponseEntity.badRequest().build();
            }

            log.info("alterarDados() - fim");
            return ResponseEntity.ok(userEntityResponse);

        } catch (BusinessException error) {
            log.error("alterarDados() - error: {}", error.getMessage());
            return ResponseEntity.badRequest().body(error.getMessage());
        } catch (Exception error) {
            log.error("alterarDados() - error: {}", error.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error.getMessage());
        }

    }

    @PostMapping(value = "/user")
    public ResponseEntity criarUsuario(@RequestBody UserDto userDto) {

        log.info("criarUsuario() - ini");
        try {

            UserEntity userEntityResponse = userService.criarUsuario(userDto);

            if (userEntityResponse == null) {
                log.info("criarUsuario() - Erro alterar usuario - fim");
                return ResponseEntity.badRequest().build();
            }

            log.info("criarUsuario() - fim");
            return ResponseEntity.ok(userEntityResponse);

        } catch (BusinessException error) {
            log.error("criarUsuario() - error: {}", error.getMessage());
            return ResponseEntity.badRequest().body(error.getMessage());
        } catch (Exception error) {
            log.error("criarUsuario() - error: {}", error.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error.getMessage());
        }

    }

}
