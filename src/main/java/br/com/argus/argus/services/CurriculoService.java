package br.com.argus.argus.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.argus.argus.models.Curriculo;
import br.com.argus.argus.repositories.CurriculoRepository;

@Service
public class CurriculoService extends ServiceGeneric<Curriculo>{
	
	@Autowired
	CurriculoRepository curriculoRepository;

	@Override
	public JpaRepository<Curriculo, Long> getRepository() {
		return curriculoRepository;
	}
	
		
	@Override
	@Transactional
	public Curriculo save(Curriculo objetoDto) {
		List<Curriculo> curriculos = findByAll();
		
		if(curriculos.size() != 0) {
			for (Curriculo c : curriculos) {
				if(c.getCodigo().equalsIgnoreCase(objetoDto.getCodigo()))
					return objetoDto;
			}
		}
		
		return super.save(objetoDto);
	}

}
