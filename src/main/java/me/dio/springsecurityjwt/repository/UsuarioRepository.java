package me.dio.springsecurityjwt.repository;

import me.dio.springsecurityjwt.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query("SELECT u FROM Usuario u JOIN FETCH u.roles WHERE u.username = (:username)")
    Usuario findByUserName(@Param("username") String username);

    boolean existsByUsername(String username);
}
