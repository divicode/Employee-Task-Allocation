package com.cts.employee.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity @Table(name = "jobs")
public class JobDetail {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jobId;

    //@DateTimeFormat(pattern = "yyyy-MM-dd")
//   @JsonFormat(pattern = "dd-MM-yyyy HH:mm",shape = JsonFormat.Shape.STRING)
//    @Column(name = "startTime", columnDefinition="DATETIME")
  //  @Temporal(TemporalType.TIMESTAMP)
    private String startDateTime;

    //@DateTimeFormat(pattern = "yyyy-MM-dd")
//   @JsonFormat(pattern = "dd-MM-yyyy HH:mm",shape = JsonFormat.Shape.STRING)
//    @Column(name = "endTime", columnDefinition="DATETIME")
    //@Temporal(TemporalType.TIMESTAMP)
    private String endDateTime;


    private int profitValue;
    private String status;
    @JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY)
    private Employee engagedEmployee;
}

