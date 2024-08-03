package com.activa.programa.model;

import com.activa.programa.security.PermissionSecurity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.security.Permission;
import java.util.Arrays;
import java.util.List;

public enum RoleModel implements GrantedAuthority {

    USER(List.of(PermissionSecurity.SAVE_ONE_PRODUCT, PermissionSecurity.READ_ALL_PRODUCTS)),
    ;
    private List<PermissionSecurity> permissions;

    RoleModel(List<PermissionSecurity> permissions) {
        this.permissions = permissions;
    }

    public List<PermissionSecurity> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionSecurity> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String getAuthority() {
        return null;
    }
}