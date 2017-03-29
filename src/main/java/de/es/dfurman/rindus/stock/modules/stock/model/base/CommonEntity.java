package de.es.dfurman.rindus.stock.modules.stock.model.base;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by furmans on 29.03.17
 * FurmanS dfurmans@gmail.com for Rindus
 *
 * @dfurmans
 */
@MappedSuperclass
public class CommonEntity implements Serializable {

    @Version
    protected Integer version;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = false)
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated", nullable = false)
    private Date updated;

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @PrePersist
    protected void onCreate() {
        updated = creationDate = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updated = new Date();
    }

}
