package my.ebizapp.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Vance on 4/12/2015.
 */
@Entity
public class CancelRequest {
    @Id
    @OneToOne
    private long id;

    private boolean customerApproved;
    private boolean supplierApproved;
    private String reason;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date time = new Date();


}
