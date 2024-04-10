package nl.jhx.vapp.dto;

import nl.jhx.vapp.controller.Role;

public class ProjectMemberDto {

    private  String name;
    private  String email;
    private  String password;
    private  Role role;

    private Role getRoleFromString(String role){

        return switch (role) {
            case "TRAFFIC_ENGINEER" -> Role.TRAFFIC_ENGINEER;
            case "CIVIL_ENGINEER" -> Role.CIVIL_ENGINEER;
            case "PROJECT_LEADER" -> Role.PROJECT_LEADER;
            default -> null;
        };
    }


    public ProjectMemberDto(String name, String email, String password, String role) throws Exception {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = getRoleFromString(role);
        if (this.role == null) {
            throw new Exception("Unexpected/Unsupported value: " + role);
        };
    };

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public Role getRole() {return role;}

    //public void setRole(String role){this.role=role;}


}

