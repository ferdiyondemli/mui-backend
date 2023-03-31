package com.yalo.mui.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.ReadOnlyBufferException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class KullaniciService {
    private final KullaniciRepo kullaniciRepo;


   @Transactional(readOnly = true)
    public List<Kullanici> getAll() {
        return kullaniciRepo.findAll();
    }

    @Transactional
    public Kullanici  ekle(Kullanici kullanici) {
       return      kullaniciRepo.save(kullanici);
    }
    @Transactional(readOnly = true)
    public Kullanici findById(Long kullaniciId) {
        return   kullaniciRepo.findById(kullaniciId).orElse(null);

    }

    @Transactional(readOnly = true)
    public Kullanici findByGiris(KullaniciGiris kullaniciGiris) {
        return   kullaniciRepo.findKullaniciByEmailAndPassword(kullaniciGiris.getEmail(),kullaniciGiris.getPassword());
    }




}
