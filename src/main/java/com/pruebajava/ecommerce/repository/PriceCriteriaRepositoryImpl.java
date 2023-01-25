package com.pruebajava.ecommerce.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Repository;

import com.pruebajava.ecommerce.model.Price;
import com.pruebajava.ecommerce.model.RequestPrice;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Predicate;

@Repository
public class PriceCriteriaRepositoryImpl implements PriceCriteriaRepository{

	private final EntityManager entityManager;
	private final CriteriaBuilder criteriaBuilder;
	
	public PriceCriteriaRepositoryImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
		this.criteriaBuilder = entityManager.getCriteriaBuilder();
	}
	
	@Override
	public List<Price> findProduct(RequestPrice request) {
		CriteriaQuery<Price> criteriaQuery = criteriaBuilder.createQuery(Price.class);
		Root<Price> priceRoot = criteriaQuery.from(Price.class);
		Predicate predicate = getPredicate(request, priceRoot);
		criteriaQuery.where(predicate);
		
		TypedQuery<Price> typedQuery = entityManager.createQuery(criteriaQuery);
		List<Price> resultStream = typedQuery.getResultList();		
			
		return resultStream;
	}

	private Predicate getPredicate(RequestPrice request, Root<Price> priceRoot) {
		
		List<Predicate> predicates = new ArrayList<>();
		
		if(Objects.nonNull(request.getProductId())) {
			predicates.add(
					criteriaBuilder.equal( priceRoot.get("productId"), request.getProductId()) 
			);
		}
		
		if(Objects.nonNull(request.getBrandId())) {
			predicates.add(
					criteriaBuilder.equal( priceRoot.get("brandId"), request.getBrandId()) 
			);
		}
		
		if(Objects.nonNull(request.getDateApplication())) {
			predicates.add(
					criteriaBuilder.between(criteriaBuilder.literal(request.getDateApplication()), 
							priceRoot.get("startDate"), priceRoot.get("endDate")) 
			);
		}
		
		return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
	}
}
