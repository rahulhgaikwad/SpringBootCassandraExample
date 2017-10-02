package com.spring.apache.DTO;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.spring.apache.VO.CustomerVO;
@Repository
public interface CustomerDAORepository extends CassandraRepository<CustomerVO> {

}
