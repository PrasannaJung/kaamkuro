package com.kaamkuro.kaamkuro.dto;

import com.kaamkuro.kaamkuro.entity.ApplyJob;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ApplyJobDto {
    private Integer id;

    @NotEmpty(message = "name can't be empty")
    private String fullname;

    @NotEmpty(message = "name can't be empty")
    private String jobposition;

    @NotEmpty(message = "name can't be empty")
    private String phoneNumber;

    @NotEmpty(message = "name can't be empty")
    private String address;

    @NotEmpty(message = "name can't be empty")
    private String cv;

    @NotEmpty(message = "name can't be empty")
    private String description;

    @NotEmpty(message = "name can't be empty")
    private String country;

    @NotEmpty(message = " email can't be empty")
    private String email;







    public ApplyJobDto(ApplyJob applyJob){
        this.id=applyJob.getId();
        this.fullname = applyJob.getFullname();
        this.email = applyJob.getEmail();
        //this.phoneNumber = applyJob.getPhoneNumber();
        this.jobposition = applyJob.getJobposition();
        this.description = applyJob.getDescription();
        this.country = applyJob.getCountry();
        this.cv = applyJob.getCv();
        //this.address = applyJob.getAddress();

    }

}
