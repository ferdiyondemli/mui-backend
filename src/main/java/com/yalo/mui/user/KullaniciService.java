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

       Kullanici kullanici=kullaniciRepo.findKullaniciByEmailAndPassword(kullaniciGiris.getEmail(),kullaniciGiris.getPassword());
     if(kullanici==null){
         throw new RuntimeException("kullanıcı bulunamadı");
     }   return kullanici;
    }

    @Transactional
    public Kullanici guncelle(KullaniciGuncelleDto kullaniciGuncelleDto) {

      Kullanici kullanici1=   kullaniciRepo.findById(kullaniciGuncelleDto.getId()).orElse(null);
      if(kullanici1.getPassword().equals(kullaniciGuncelleDto.getEskiPassword())){
          kullanici1.setKullaniciAdi(kullaniciGuncelleDto.getKullaniciAdi());
          kullanici1.setEmail(kullaniciGuncelleDto.getEmail());
          if(!kullaniciGuncelleDto.getPassword().isEmpty()){
              kullanici1.setPassword(kullaniciGuncelleDto.getPassword());
          }
          return kullanici1;
      }else {
           throw  new RuntimeException("uyumsuz password");
      }


    }
}
