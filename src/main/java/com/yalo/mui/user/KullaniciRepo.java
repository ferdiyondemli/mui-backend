package com.yalo.mui.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface KullaniciRepo extends JpaRepository <Kullanici, Long> {

    Kullanici findKullaniciByKullaniciAdiAndPassword(String kullanciAdi, String password);
}
