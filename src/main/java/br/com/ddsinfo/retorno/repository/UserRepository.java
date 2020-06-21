package br.com.ddsinfo.retorno.repository;

import br.com.ddsinfo.retorno.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
