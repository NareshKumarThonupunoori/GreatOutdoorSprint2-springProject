package com.cg.go.greatoutdoor.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.go.greatoutdoor.dao.ISalesReportRepository;
import com.cg.go.greatoutdoor.entity.Customer;
import com.cg.go.greatoutdoor.entity.ProductEntity;
import com.cg.go.greatoutdoor.entity.SalesReportEntity;
import com.cg.go.greatoutdoor.exception.CustomerException;
import com.cg.go.greatoutdoor.exception.ProductException;
import com.cg.go.greatoutdoor.exception.SalesReportException;

@Transactional
@Service
public class SalesReportServiceImpl implements ISalesReportService {
	private static final Logger Log = LoggerFactory.getLogger(SalesReportServiceImpl.class);
	
	@Autowired
    private ISalesReportRepository salesReportRepository;

	@Override
	public List<SalesReportEntity> findAllSalesReport() {
		List<SalesReportEntity> list=salesReportRepository.findAll();
		return list;
	}

	@Override
	public SalesReportEntity findSalesReportByProductId(String productId) {
		SalesReportEntity list=salesReportRepository.findByProductId(productId);
		/*if(list.equals(null)) {
			throw new SalesReportException("sales repot not foung for productId");
		}*/
		return list;
	}

	@Override
	public void updateProductReport(SalesReportEntity salesReportEntity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllSalesReport() throws SalesReportException {
		// TODO Auto-generated method stub
		salesReportRepository.deleteAll();
		
	}

	@Override
	public void deleteSalesReportById(Long salesReportId) throws SalesReportException {
		Optional<SalesReportEntity> optional=salesReportRepository.findById(salesReportId);
		if(!optional.isPresent()){
            throw new ProductException("sales report not found for id="+salesReportId);
        }
		salesReportRepository.deleteById(salesReportId);
		
	}

	@Override
	public SalesReportEntity addSalesReport(SalesReportEntity salesReportEntity) {
		/*boolean exists=SalesReportEntity.getProductId()!=null && salesReportRepository.existsById(SalesReportEntity.getProductId());
        if(exists){
            throw new SalesReportException("Product already exists for id="+SalesReportEntity.getProductId());
        }*/
	     System.out.println("inside Add sales");
		SalesReportEntity salesReport=salesReportRepository.save(salesReportEntity);
		return salesReport;
	}

}
