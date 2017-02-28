package com.example.formador.realm;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;

/**
 * Created by formador on 31/1/17.
 */

public class Holiday extends RealmObject{

    public static final int STATE_APPROVED = 1;
    public static final int STATE_STANDBY = 2;
    public static final int STATE_DENIED = 3;

    @PrimaryKey
    private String id;
    @Index
    private Date dateStart, dateEnd;
    private int state;

    public Holiday() {
    }

    public Holiday(String id, Date dateStart, Date dateEnd, int state) {
        this.id = id;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.state = state;
    }

    public Holiday(Date dateStart, Date dateEnd) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.state = STATE_STANDBY;
    }

    public Holiday(Date dateStart, Date dateEnd, int state) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public int getState() {
        return state;
    }

    public String getStateString() {
        switch (state) {
            case STATE_STANDBY:
                return "Pendiente";
            case STATE_APPROVED:
                return "Aprobadas";
            case STATE_DENIED:
                return "Denegadas";
            default:
                return "Estado deconocido";
        }
    }

    public void setState(int state) {
        this.state = state;
    }
}
