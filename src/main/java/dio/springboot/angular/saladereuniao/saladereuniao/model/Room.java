package dio.springboot.angular.saladereuniao.saladereuniao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="MeetingRoom")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private String date;

    @Column
    @NotNull
    private String startHour;

    @Column
    @NotNull
    private String endHour;

    @Override
    public String toString(){
        return "Room [id="+getId()+",name="+getName()+",startHour="+getStartHour()+",endHour"+getEndHour()+"]";
    }
}
