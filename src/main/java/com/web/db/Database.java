package com.web.db;

import java.io.Serializable;
import java.util.List;

import com.google.gson.Gson;
import com.web.models.Point;
import com.web.utils.AreaChecker;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Named
@SessionScoped
public class Database implements Serializable{

    private String jsonPoints;

    @PersistenceContext
    private EntityManager manager;
    @Inject
    private AreaChecker checker;

    public List<Point> getPoints() {
        return
        manager.createQuery("select point from Point point", Point.class).getResultList();
    }

    @Transactional
    public Point addPoint(Point point) {
        checker.checkPoint(point);
        manager.merge(point);
        manager.flush();
        return point;
    }

    public int attemtCount() {
        return manager.createQuery("select count(*) from Point", Number.class).getSingleResult().intValue();
    }

    public String getJsonPoints(){
        this.jsonPoints = new Gson().toJson(this.getPoints());
        return jsonPoints;
    }
}
