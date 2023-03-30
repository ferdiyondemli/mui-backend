package com.yalo.mui.user;


import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
@CrossOrigin
public class KullaniciController {
    private final KullaniciService kullaniciService;

    @GetMapping(value = "/all")
    public List<Kullanici> getAll() {
        return kullaniciService.getAll();
    }

    @PostMapping(value = "/ekle")
    public  Kullanici  ekle (@RequestBody   Kullanici kullanici) {
        return kullaniciService.ekle(kullanici);

    }
    @GetMapping(value = "/{kullaniciId}")
    public Kullanici getAll(@PathVariable( "kullaniciId") Long kullaniciId ) {
        return kullaniciService.findById(kullaniciId);
    }

    @PostMapping(value = "/{kullaniciId}")
    public Kullanici getAll(@RequestBody   KullaniciGiris kullaniciGiris ) {
        return kullaniciService.findByGiris(kullaniciGiris);
    }

    }
