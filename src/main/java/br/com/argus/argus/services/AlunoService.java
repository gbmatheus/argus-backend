package br.com.argus.argus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.argus.argus.exception.PessoaException;
import br.com.argus.argus.exception.ServicesException;
import br.com.argus.argus.exception.ValidarColunaException;
import br.com.argus.argus.models.Aluno;
import br.com.argus.argus.repositories.AlunoRepository;

@Service
public class AlunoService extends GenericService<Aluno> {

	static int matricula = 0;

	@Autowired
	PessoaService pessoaService;

	@Autowired
	ResponsavelService responsavelService;

	@Autowired
	AlunoRepository alunoRepository;

	@Override
	public Optional<Aluno> findById(long id) {
		return alunoRepository.findById(id);
	}

	@Override
	public Aluno findBy(long id) {
		Aluno aluno = alunoRepository.findOne(id);

		if (aluno == null) {
			try {
				throw new ServicesException("Aluno não existe");
			} catch (ServicesException e) {
				e.printStackTrace();
			}
		}
		return aluno;
	}

	@Override
	public List<Aluno> findByAll() {
		return alunoRepository.findAll();
	}

	@Override
	public Aluno save(Aluno alunoDto) throws ValidarColunaException {
		Aluno aluno = new Aluno();

		try {
			if (alunoDto.getPessoa() == null || alunoDto.getMae() == null || alunoDto.getPai() == null
					|| alunoDto.getResponsavel() == null)
				throw new PessoaException("Informações pessoais inválidas");

			aluno.setPessoa(pessoaService.save(alunoDto.getPessoa()));

			aluno.setMae(pessoaService.save(alunoDto.getMae()));

			aluno.setPai(pessoaService.save(alunoDto.getPai()));

			aluno.setResponsavel(responsavelService.save(alunoDto.getResponsavel()));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return alunoRepository.save(aluno);
	}

	@Override
	public Aluno update(long id, Aluno alunoDto) {
		return findById(id).map(record -> {
			record.setPessoa(alunoDto.getPessoa());
			record.setMae(alunoDto.getMae());
			record.setPai(alunoDto.getPai());
			record.setResponsavel(alunoDto.getResponsavel());

			Aluno aluno = alunoRepository.save(record);
			return aluno;
		}).orElse(null);
	}

	@Override
	public void remove(long id) {
		Optional<Aluno> a = findById(id);
		pessoaService.remove(a.get().getPessoa().getId());
	}

	@Override
	public void deleteById(long id) {
		alunoRepository.deleteById(id);
	}

}
