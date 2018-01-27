package be.kul.dijleserver.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class AbstractBaseObject implements Comparable<Object> {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid2")
    private String id;

    @Column(name = "CREATED_ON_TIMESTAMP")
    private LocalDateTime createdOn;

    @Column(name = "LAST_MODIFIED_ON_TIMESTAMP")
    private LocalDateTime lastModifiedOn;

    public String getId() {
        return id;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public LocalDateTime getLastModifiedOn() {
        return lastModifiedOn;
    }

    public void setLastModifiedOn(LocalDateTime lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }

    @PrePersist
    public void onCreate() {
        this.createdOn = LocalDateTime.now();
        this.lastModifiedOn = this.createdOn;
    }

    @PreUpdate
    public void onUpdate() {
        this.lastModifiedOn = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return this.getClass().getName() + " - id : " + getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AbstractBaseObject that = (AbstractBaseObject) o;

        return !(id != null ? !id.equals(that.id) : that.id != null);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public boolean isNewObject() {
        return getId() == null;
    }

    public boolean isNearlyNewObject() {
        return isNewObject() || ( getCreatedOn().equals ( getLastModifiedOn() ) );
    }

    @Override
    public int compareTo(Object o){
        return getCreatedOn().compareTo(((AbstractBaseObject) o).getCreatedOn());
    }
}