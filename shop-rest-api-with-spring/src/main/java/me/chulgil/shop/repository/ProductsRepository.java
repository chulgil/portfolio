package me.chulgil.shop.repository;

import org.springframework.data.repository.CrudRepository;

import me.chulgil.shop.domain.Products;

public interface ProductsRepository extends CrudRepository<Products,Long>{

}
