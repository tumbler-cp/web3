package com.web.utils;

import java.io.Serializable;

import com.web.models.Point;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class AreaChecker implements Serializable {
    public void checkPoint(Point point) {
        double x = point.getX();
        double y = point.getY();
        double r = point.getR();
        point.setHit(
            x <= 0 && y <= 0 && Math.abs(x) <= r && Math.abs(y) <= r ||
            x >= 0 && y >= 0 && Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(r, 2) ||
            x < 0 && y > 0 && (-2 * x - r <= y)
        );
    }
}
