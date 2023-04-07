package com.yalo.mui.user;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KullaniciGuncelleDto {

    @Email(message = "Geçerli bir email giriniz!")
    private String email;
    @NotNull(message = "Id boş olmamalıdır.")
    private Long id;
    private String password;

    private String eskiPassword;
    private String kullaniciAdi;



}
