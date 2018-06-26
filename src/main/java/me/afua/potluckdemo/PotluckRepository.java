package me.afua.potluckdemo;

import org.springframework.data.repository.CrudRepository;

public interface PotluckRepository extends CrudRepository<Potluck, Long> {
    Iterable<Potluck> findAllByDishContainingIgnoreCase(String s);
}

