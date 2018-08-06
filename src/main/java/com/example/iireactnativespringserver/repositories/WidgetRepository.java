package com.example.iireactnativespringserver.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.iireactnativespringserver.models.Widget;

public interface WidgetRepository extends CrudRepository <Widget, Integer>  {

}
