package br.com.clp.ecommerce.service;

import br.com.clp.ecommerce.domain.Usuario;
import br.com.clp.ecommerce.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario loadUserByUsername(String login) throws UsernameNotFoundException {
        return usuarioRepository.findByUsername(login);
    }
}
