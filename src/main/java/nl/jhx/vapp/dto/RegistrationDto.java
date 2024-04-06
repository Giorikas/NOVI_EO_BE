package nl.jhx.vapp.dto;

import nl.jhx.vapp.controller.Role;

public class RegistrationDto {
    private final String name;
    private final String email;
    private final String password;
    private final Role role;

    private Role getRoleFromString(String role){

        return switch (role) {
            case "TRAFFIC_ENGINEER" -> Role.TRAFFIC_ENGINEER;
            case "CIVIL_ENGINEER" -> Role.CIVIL_ENGINEER;
            case "PROJECT_LEADER" -> Role.PROJECT_LEADER;
            default -> null;
        };
    }

    public RegistrationDto(String name, String email, String password, String role) throws Exception{

        this.name = name;
        this.email = email;
        this.password = password;
        this.role = getRoleFromString(role);
        if (this.role == null) {
            throw new Exception("Unexpected/Unsupported value: " + role);
        };

    };

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }





}

