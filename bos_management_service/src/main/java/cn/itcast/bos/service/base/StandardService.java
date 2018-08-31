package cn.itcast.bos.service.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cn.itcast.bos.domain.base.Standard;

import java.util.List;

public interface StandardService {


	void save(Standard standard);

	Page<Standard> pageQuery(Pageable pageable);

	List<Standard> findAll();
}
