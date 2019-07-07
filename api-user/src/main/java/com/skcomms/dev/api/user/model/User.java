package com.skcomms.dev.api.user.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private String userId;
    private String name;
    private String email;

}
