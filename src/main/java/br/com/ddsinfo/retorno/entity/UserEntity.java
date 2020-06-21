package br.com.ddsinfo.retorno.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

@Validated
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_login")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "USUARIO")
    private String usuario;

    @Column(name = "SENHA")
    private String senha;

}
