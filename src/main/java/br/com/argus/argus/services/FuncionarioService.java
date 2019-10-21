package br.com.argus.argus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.argus.argus.exception.PessoaException;
import br.com.argus.argus.exception.ServicesException;
import br.com.argus.argus.exception.UsuarioException;
import br.com.argus.argus.exception.ValidarColunaException;
import br.com.argus.argus.models.Funcionario;
import br.com.argus.argus.repositories.FuncionarioReporitory;

@Service
public class FuncionarioService extends GenericService<Funcionario> {

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
		Funcionario funcionario = funcionarioReporitory.findOne(id);

		if (funcionario == null) {
			try {
				throw new ServicesException("Funcionario não existe");
			} catch (ServicesException e) {
				e.printStackTrace();
			}
		}
		return funcionario;
	}

	@Override
	public Funcionario save(Funcionario funcionarioDto) throws ValidarColunaException {
		List<Funcionario> funcionarios = findByAll();

		Funcionario funcionario = new Funcionario();

		try {
			if (funcionarioDto.getPessoa() == null)
				throw new PessoaException("As informações pessoais estão vazias");
			funcionario.setPessoa(pessoaService.save(funcionarioDto.getPessoa()));

			if (funcionarioDto.getUsuario() == null)
				throw new UsuarioException("As informações do usuário estão vazias");
			funcionario.setUsuario(usuarioService.save(funcionarioDto.getUsuario()));

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (funcionarios.size() != 0) {
			for (Funcionario f : funcionarios) {
				if (f.getCpf().equalsIgnoreCase(funcionarioDto.getCpf())) {
					new ValidarColunaException("CPF já está em uso");
				}
			}
		}

		funcionario.setCpf(funcionarioDto.getCpf());
		funcionario.setCargaHoraria(funcionarioDto.getCargaHoraria());

		return funcionarioReporitory.save(funcionario);
	}

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

	@Override
	public void remove(long id) {
		Optional<Funcionario> f = findById(id);
		pessoaService.remove(f.get().getPessoa().getId());
	}

	public void deleteById(long id) {
		funcionarioReporitory.deleteById(id);
	}

}
