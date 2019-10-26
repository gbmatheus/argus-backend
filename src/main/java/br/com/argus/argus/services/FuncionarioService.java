package br.com.argus.argus.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.argus.argus.models.Funcionario;
import br.com.argus.argus.repositories.FuncionarioReporitory;

@Service
public class FuncionarioService extends ServiceGeneric<Funcionario>{

	@Autowired
	FuncionarioReporitory funcionarioReporitory;
	
	@Override
	public JpaRepository<Funcionario, Long> getRepository() {
		return funcionarioReporitory;
	}
	
	@Override
	@Transactional
	public Funcionario save(Funcionario objetoDto) {
		List<Funcionario> funcionarios = findByAll();
		
		if(funcionarios.size() != 0) {
			for (Funcionario f : funcionarios) {
				if(f.getCpf().equalsIgnoreCase(objetoDto.getCpf()))
					return objetoDto;
			}
		}
		
		return super.save(objetoDto);
	}
	
	@Override
	@Transactional
	public Funcionario update(long id, Funcionario funcionarioDto) {
		return findById(id).map(record -> {
			record.setPessoa(funcionarioDto.getPessoa());
			record.setUsuario(funcionarioDto.getUsuario());
			record.setCargaHoraria(funcionarioDto.getCargaHoraria());
			record.setCpf(record.getCpf());

			Funcionario funcionario = funcionarioReporitory.save(record);
			return funcionario;
		}).orElse(null);
	}	

}
