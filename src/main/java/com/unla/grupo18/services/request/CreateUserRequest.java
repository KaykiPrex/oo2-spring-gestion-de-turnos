package com.unla.grupo18.services.request;

import jakarta.validation.constraints.NotBlank;

public record CreateUserRequest(@NotBlank String name , @NotBlank String pass , CreateUserContactRequest contact) {
}
