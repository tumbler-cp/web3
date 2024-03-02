package com.web.models;

import java.io.Serializable;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@ToString
@Table
@Named
@SessionScoped
public class Point implements Serializable{
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "x", nullable = false)
    private Double x = 0d;
    @Column(name = "y", nullable = false)
    private Double y = 0d;
    @Column(name = "r", nullable = false)
    private Double r = 1d;
    @Column(name = "hit", nullable = false)
    private boolean hit;
    public Double getX() {
        return x;
    }
    public Double getY() {
        return y;
    }
    public Double getR() {
        return r;
    }
    public void setX(Double x) {
        this.x = x;
    }
    public void setY(Double y) {
        this.y = y;
    }
    public void setR(Double r) {
        this.r = r;
    }
    public void setHit(boolean hit) {
        this.hit = hit;
    }
    public boolean isHit() {
        return hit;
    }
}
