package com.api.sustentavel.user;

import java.util.Collection;

public interface UserDetails {
    Collection<Object> getAuthorities();

    Object getUsername();
}
