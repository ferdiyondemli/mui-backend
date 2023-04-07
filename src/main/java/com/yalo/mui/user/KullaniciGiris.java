package com.yalo.mui.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KullaniciGiris {

    @NotBlank(message = "Şifre boş olmamalıdır.")
    private String password;
    @Email(message = "Geçerli bir email giriniz!")
    private String email;
}
