package com.web.models;

import java.util.List;
import java.util.Map;

import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;

import com.web.db.Database;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;


@Named
@SessionScoped
public class PointList extends LazyDataModel<Point>{
    @Inject
    private Database database;

    @Override
    public int count(Map<String, FilterMeta> filterBy) {
        return database.attemtCount();
    }

    @Override
    public List<Point> load(int first, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
        return database.getPoints();
    }
}
