package br.com.argus.argus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.argus.argus.exception.CpfException;
import br.com.argus.argus.models.Funcionario;
import br.com.argus.argus.repositories.FuncionarioReporitory;

@Service
public class FuncionarioService extends ServiceGeneric<Funcionario> {

	@Autowired
	FuncionarioReporitory funcionarioReporitory;

	@Override
	public JpaRepository<Funcionario, Long> getRepository() {
		return funcionarioReporitory;
	}

	@Override
	@Transactional
	public Funcionario save(Funcionario objetoDto) {

		if (funcionarioReporitory.findByCpf(objetoDto.getCpf()) != null) {
			throw new CpfException("CPF já está em uso");
		} 
		return funcionarioReporitory.save(objetoDto);
	}

	@Override
	@Transactional
	public Funcionario update(Long id, Funcionario funcionarioDto) {
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
