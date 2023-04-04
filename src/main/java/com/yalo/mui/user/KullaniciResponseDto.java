package com.yalo.mui.user;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KullaniciResponseDto {

    private String email;
    private Long id;
    private String kullaniciAdi;
     private Role role;

    public KullaniciResponseDto(Kullanici kullanici) {
        this.email = kullanici.getEmail();
        this.id = kullanici.getId();
        this.kullaniciAdi =kullanici.getKullaniciAdi();
        this.role=kullanici.getRole();
    }

}
