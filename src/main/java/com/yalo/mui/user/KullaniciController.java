package com.yalo.mui.user;


import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
@CrossOrigin
public class KullaniciController {
    private final KullaniciService kullaniciService;

    @GetMapping(value = "/all")
    public List<KullaniciResponseDto> getAll() {
        List<Kullanici> kullaniciList = kullaniciService.getAll();
        List<KullaniciResponseDto> list = new ArrayList<KullaniciResponseDto>(kullaniciList.size());
        for (Kullanici kullanici : kullaniciList) {
            list.add(new KullaniciResponseDto(kullanici));
        }
        return list;
    }

    @PostMapping(value = "/ekle")
    public KullaniciResponseDto ekle(@RequestBody Kullanici kullanici) {
        return new KullaniciResponseDto(kullaniciService.ekle(kullanici));
    }

    @PutMapping(value = "/guncelle")
    public KullaniciResponseDto guncelle(@RequestBody KullaniciGuncelleDto kullaniciGuncelleDto) {
        return new KullaniciResponseDto(kullaniciService.guncelle(kullaniciGuncelleDto));
    }


    @GetMapping(value = "/{kullaniciId}")
    public Kullanici getAll(@PathVariable("kullaniciId") Long kullaniciId) {
        return kullaniciService.findById(kullaniciId);
    }

    @PostMapping(value = "/giris")
    public KullaniciResponseDto getAll(@RequestBody KullaniciGiris kullaniciGiris) {
        return new KullaniciResponseDto(kullaniciService.findByGiris(kullaniciGiris));
    }

}
