package com.unla.grupo18.services.request;

import jakarta.validation.constraints.Email;

public record CreateUserContactRequest(@Email String workEmail,@Email String personalEmail, String phone, String mobile) {
}
