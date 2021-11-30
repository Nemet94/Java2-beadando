package com.example.menhely;
import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "email", nullable = false, length = 20)
    private String email;
    @Column(name = "text", nullable = false, length = 200)
    private String text;
    @Column(name = "time", nullable = false)
    private Timestamp time;

    public Long getId() {
        return id;
    }

    public void Long(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }




}