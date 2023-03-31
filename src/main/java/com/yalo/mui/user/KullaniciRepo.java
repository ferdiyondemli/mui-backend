package com.yalo.mui.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface KullaniciRepo extends JpaRepository <Kullanici, Long> {

    Kullanici findKullaniciByEmailAndPassword(String email, String password);
}
