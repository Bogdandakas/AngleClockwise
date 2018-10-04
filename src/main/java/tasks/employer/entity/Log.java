package tasks.employer.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "log")
public class Log {

    public static final String INPUT = "input";
    public static final String START = "start";
    public static final String ANGLE = "angle";
    public static final String DEGREE_SYMBOL = "degree";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String level;
    @Column
    private String text;

    @Column
    private Date date;

    public Log() {
    }

    public Log(String level, String text, Date date) {
        this.level = level;
        this.text = text;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
