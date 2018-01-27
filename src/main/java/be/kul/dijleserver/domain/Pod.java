package be.kul.dijleserver.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tbl_pod")
public class Pod extends AbstractBaseObject {

    @NotBlank
    @NotNull
    @Column
    private String name;

    @OneToMany(mappedBy = "pod")
    private List<Reading> readings;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Reading> getReadings() {
        return readings;
    }

    public void setReadings(List<Reading> readings) {
        this.readings = readings;
    }

}
