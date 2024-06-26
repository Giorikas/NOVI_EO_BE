package nl.jhx.vapp.dto;

import nl.jhx.vapp.controller.Status;

public class ProjectDto {

    private Long id;
    private String name;
    private Status status;

    private Status getStatusFromString(String status){

        return switch (status) {
            case "STARTED"-> Status.STARTED;
            case "TRAFFIC_ENGINEERING"-> Status.TRAFFIC_ENGINEERING;
            case "TRAFFIC_EVALUATION"-> Status.TRAFFIC_EVALUATION;
            case "CIVIL_ENGINEERING"-> Status.CIVIL_ENGINEERING;
            case "CIVIL_EVALUATION"-> Status.CIVIL_EVALUATION;
            case "FINISHED"-> Status.FINISHED;
            default -> Status.MF;
        };
    }

    public ProjectDto(Long id, String name, Status status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Long getId() {return id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public Status getStatus() {return status;}

    public void setStatus(String status) {
        this.status = getStatusFromString(status);
    }
}
