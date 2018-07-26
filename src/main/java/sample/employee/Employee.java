package sample.employee;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @JsonView(DataTablesOutput.View.class)
    @Id private int id;

    @JsonView(DataTablesOutput.View.class)
    private String firstName;

    @JsonView(DataTablesOutput.View.class)
    private String lastName;
    private String position;
    private int age;
    private int salary;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_office")
    private Office office;

}