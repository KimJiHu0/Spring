package com.boot.jpa.model.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.jpa.model.dto.JpaDto;


@Repository
public interface JpaDao extends JpaRepository<JpaDto, Integer> {
	
	// hibernate가 알아서 해준다.
	// JpaRepository에 있는 메소드들 있어서 재정의하는디?
	// return까지 다  해줘서 굳이 class를 만들 필요가 없다.

	public List<JpaDto> findAll();
	
	public JpaDto findByMyno(int myno);
	
	public JpaDto save(JpaDto dto);
	
	public JpaDto saveAndFlush(JpaDto dto);
	
	@Transactional
	public void deleteByMyno(int myno);
	
}
