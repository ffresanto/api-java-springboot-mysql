package br.com.ddsinfo.retorno.service;

import br.com.ddsinfo.retorno.dto.UserDto;
import br.com.ddsinfo.retorno.entity.UserEntity;
import br.com.ddsinfo.retorno.exception.BusinessException;
import br.com.ddsinfo.retorno.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepositoryMock;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }


    @PostConstruct
    public void popularBanco(){
        userRepository.save(new UserEntity(null, "Teste insercao 1", "123456"));
        userRepository.save(new UserEntity(null, "Teste insercao 2", "123456"));
        userRepository.save(new UserEntity(null, "Teste insercao 3", "123456"));
        userRepository.save(new UserEntity(null, "Teste insercao 4", "123456"));
    }

    @Test
    public void testeFindByIdService(){

        Optional<UserEntity> userEntityOptional = userRepository.findById(1L);
        Mockito.when(userRepositoryMock.findById(1L)).thenReturn(userEntityOptional);
        Assert.assertEquals(userService.findById(1L).isPresent(), userEntityOptional.isPresent());
        if (userEntityOptional.isPresent()){
            UserEntity userEntity = userEntityOptional.get();
            Assert.assertEquals(userService.findById(1L).get(), userEntity);
        }

    }

    @Test
    public void testeFindAllIdService(){

        List<UserEntity> userEntityList = userRepository.findAll();
        Mockito.when(userRepositoryMock.findAll()).thenReturn(userEntityList);
        Assert.assertEquals(!userService.findAll().isEmpty(), !userEntityList.isEmpty());
        Assert.assertEquals(userService.findAll(), userEntityList);

    }


    @Test
    public void testeAlterarUsuarioExceptionId() {
        final String errorMessage = "Id não pode ser nulo";
        BusinessException businessException = Assert.assertThrows(BusinessException.class, () -> { userService.alterarDados(new UserDto(null, "Teste", "teste")); });
        Assert.assertEquals(businessException.getMessage(), errorMessage);
    }

    @Test
    public void testeAlterarUsuarioExceptionUsuarioESenha() {
        final String errorMessage = "Senha ou nome de usuario não pode ser vazio para criação de um usuário";
        BusinessException businessException = Assert.assertThrows(BusinessException.class, () -> { userService.alterarDados(new UserDto(1L, null, null)); });
        Assert.assertEquals(businessException.getMessage(), errorMessage);
    }

    @Test
    public void testeUsuarioNaoEncontradoParaAlteracao() {
        final String errorMessage = "Usuario não existe na base portanto não poderá ser alterado";
        BusinessException businessException = Assert.assertThrows(BusinessException.class, () -> { userService.alterarDados(new UserDto(1000L, "teste", "teste")); });
        Assert.assertEquals(businessException.getMessage(), errorMessage);
    }

    @Test
    public void testeSucessoAlteracao() throws BusinessException {
        UserEntity userEntity = new UserEntity(1L, "TesteAlteracao", "TesteAlteracao");
        Optional<UserEntity> userEntityOptional = userRepository.findById(1L);
        Mockito.when(userRepositoryMock.findById(1L)).thenReturn(userEntityOptional);
        Mockito.when(userRepositoryMock.save(userEntity)).thenReturn(userEntity);
        Assert.assertEquals(userEntity, userService.alterarDados(new UserDto(1L, "TesteAlteracao", "TesteAlteracao")));
    }

    @Test
    public void testeCriarUsuarioExceptionUsuario() {
        final String errorMessage = "Senha ou nome de usuario não pode ser vazio para criação de um usuário";
        BusinessException businessException = Assert.assertThrows(BusinessException.class, () -> { userService.criarUsuario(new UserDto(null, null, "senha")); });
        Assert.assertEquals(businessException.getMessage(), errorMessage);
    }

    @Test
    public void testeCriarUsuarioExceptionSenha() {
        final String errorMessage = "Senha ou nome de usuario não pode ser vazio para criação de um usuário";
        BusinessException businessException = Assert.assertThrows(BusinessException.class, () -> { userService.criarUsuario(new UserDto(null, "usuario", null)); });
        Assert.assertEquals(businessException.getMessage(), errorMessage);
    }

    @Test
    public void testeCriarUsuarioExceptionUsuarioESenha() {
        final String errorMessage = "Senha ou nome de usuario não pode ser vazio para criação de um usuário";
        BusinessException businessException = Assert.assertThrows(BusinessException.class, () -> { userService.criarUsuario(new UserDto(null, null, null)); });
        Assert.assertEquals(businessException.getMessage(), errorMessage);
    }

    @Test
    public void testeSucessoCriacao() throws BusinessException {
        UserEntity userEntity = new UserEntity(5L, "TesteCriacao", "TesteCriacao");
        Mockito.when(userRepositoryMock.save(userEntity)).thenReturn(userEntity);
        Mockito.when(userService.criarUsuario(new UserDto(5L, "TesteCriacao", "TesteCriacao"))).thenReturn(userEntity);
        Assert.assertEquals(userEntity, userService.criarUsuario(new UserDto(5L, "TesteCriacao", "TesteCriacao")));
    }


}
