package Newspring.newspring.dto.security;

import Newspring.newspring.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class PrincipalDetails implements UserDetails{

    private User user;
    private Map<String,Object> attributes;

    public PrincipalDetails(User user) {
        this.user = user;
    }

    public PrincipalDetails(User user,Map<String,Object> attributes){
        this.user=user;
        this.attributes=attributes;
    }

    public Map<String, Object> getAttributes() {
        return this.attributes;
    }

    public String getName() {
        return user.getName();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect=new ArrayList<>();
        collect.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return user.getRole();
            }
        });

        return collect;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}