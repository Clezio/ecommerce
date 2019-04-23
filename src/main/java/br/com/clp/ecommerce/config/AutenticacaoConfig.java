package br.com.clp.ecommerce.config;

import br.com.clp.ecommerce.domain.Usuario;
import br.com.clp.ecommerce.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoConfig implements AuthenticationProvider {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Usuario usuario = usuarioService.loadUserByUsername(authentication.getName());

        if (usuario == null || !(new BCryptPasswordEncoder().matches(authentication.getCredentials().toString(), usuario.getPassword()))) {
            throw new BadCredentialsException("Dados não encontrados");
        }

        return new UsernamePasswordAuthenticationToken(authentication.getName(), authentication.getCredentials(), usuario.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
