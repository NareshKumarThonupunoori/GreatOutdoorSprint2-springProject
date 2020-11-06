package com.cg.go.greatoutdoor.service;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.go.greatoutdoor.dao.IProductRepository;
import com.cg.go.greatoutdoor.entity.ProductEntity;
import com.cg.go.greatoutdoor.exception.ProductException;

@Transactional
@Service
public class ProductServiceImpl implements IProductService{
	
    private static final Logger Log = LoggerFactory.getLogger(ProductServiceImpl.class);
	
    @Autowired
    private IProductRepository productRepository;

	@Override
	public List<ProductEntity> findAllProducts() {
		List<ProductEntity> list=productRepository.findAll();
		return list;
	}

	@Override
	public ProductEntity findByProductId(Integer productId) {
		Optional<ProductEntity> optional=productRepository.findById(productId);
		if(!optional.isPresent()){
            throw new ProductException("Product not found for id="+productId);
        }
		ProductEntity product=optional.get();
		return product;
	}

	@Override
	public List<ProductEntity> findByProductCategory(String productCategory) {
		List<ProductEntity> list=productRepository.findByCategory(productCategory);
		return list;
	}

	@Override
	public ProductEntity addProduct(ProductEntity productEntity) {
		
		boolean exists=productEntity.getProductId()!=null && productRepository.existsById(productEntity.getProductId());
        if(exists){
            throw new ProductException("Product already exists for id="+productEntity.getProductId());
        }
		ProductEntity product=productRepository.save(productEntity);
		return product;
	}

	@Override
	public ProductEntity updateProduct(ProductEntity productEntity)  {
		boolean exists= productRepository.existsById(productEntity.getProductId());
        if(!exists){
            throw new ProductException("Product does not exists for id="+productEntity.getProductId());
        }
		ProductEntity product=productRepository.save(productEntity);
		return product;
	}


	@Override
	public void deleteByProductId(Integer productId) {
		Optional<ProductEntity> optional=productRepository.findById(productId);
		if(!optional.isPresent()){
            throw new ProductException("Product not found for id="+productId);
        }
		productRepository.deleteById(productId);
		
	}

	@Override
	public List<ProductEntity> search(String keyword) {
		List<ProductEntity> list=productRepository.findByProductName(keyword);
		return list;
		
	}

	@Override
	public List<ProductEntity> filter(double maxPrice) {
		List<ProductEntity> list=productRepository.findByRange(maxPrice);
		return list;
	}
	
	/*@Override
	public void updateProductQuantity(Integer quantity, Integer productId) {
		Optional<ProductEntity> optional=daoProduct.findById(productId);
		if(!optional.isPresent()){
            throw new ProductException("Product not found for id="+productId);
        }
		ProductEntity product=optional.get();
		product.setQuantity(quantity);
		
	}*/
}
