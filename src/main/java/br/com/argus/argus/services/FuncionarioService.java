package br.com.argus.argus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.argus.argus.models.Funcionario;
import br.com.argus.argus.repositories.FuncionarioReporitory;

@Service
public class FuncionarioService {

	@Autowired
	PessoaService pessoaService;

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	FuncionarioReporitory funcionarioReporitory;

	public List<Funcionario> findByAll() {
		return funcionarioReporitory.findAll();
	}

	public Optional<Funcionario> findById(long id) {
		return funcionarioReporitory.findById(id);
	}

	public Funcionario findBy(long id) {
//		Funcionario funcionario = funcionarioReporitory.findOne(id);
//
//		if (funcionario == null) {
//			try {
//				throw new ServicesException("Funcionario não existe");
//			} catch (ServicesException e) {
//				e.printStackTrace();
//			}
//		}
//		return funcionario;
		return null;
	}

	public Funcionario save(Funcionario funcionarioDto) {
		Funcionario funcionario = new Funcionario();

		funcionario.setPessoa(pessoaService.save(funcionarioDto.getPessoa()));
		funcionario.setUsuario(usuarioService.save(funcionarioDto.getUsuario()));
		funcionario.setCpf(funcionarioDto.getCpf());
		funcionario.setCargaHoraria(funcionarioDto.getCargaHoraria());

		return funcionarioReporitory.save(funcionario);
	}

	public Funcionario saveTest(Funcionario funcionario) {

		return funcionarioReporitory.save(funcionario);
	}

	public Funcionario update(Funcionario funcionario) {
		return null;
	}

	public void deleteById(long id) {

	}

	public void deleteAll() {

	}

}
