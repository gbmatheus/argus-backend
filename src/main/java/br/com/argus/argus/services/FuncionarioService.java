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
	PessoaService pessoaService;

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	FuncionarioReporitory funcionarioReporitory;

	@Override
	public JpaRepository<Funcionario, Long> getRepository() {
		return funcionarioReporitory;
	}

	@Override
	@Transactional
	public Funcionario save(Funcionario funcionarioDto) {

		if (funcionarioReporitory.findByCpf(funcionarioDto.getCpf()) != null) {
			throw new CpfException("CPF já está em uso");
		}
		Funcionario funcionario = new Funcionario();

		funcionario.setPessoa(pessoaService.save(funcionarioDto.getPessoa()));
		funcionario.setUsuario(usuarioService.save(funcionarioDto.getUsuario()));
		funcionario.setCargaHoraria(funcionarioDto.getCargaHoraria());

		funcionario.setCpf(funcionarioDto.getCpf());

		return super.save(funcionarioDto);
	}

	@Override
	@Transactional
	public Funcionario update(Long id, Funcionario funcionarioDto) {
		return findById(id).map(record -> {
			record.setPessoa(funcionarioDto.getPessoa());
			record.setUsuario(funcionarioDto.getUsuario());
			record.setCargaHoraria(funcionarioDto.getCargaHoraria());
			record.setCpf(record.getCpf());

			Funcionario funcionario = getRepository().save(record);
			return funcionario;
		}).orElse(null);
	}

}
