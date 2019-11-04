package br.com.argus.argus.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.argus.argus.models.Aluno;
import br.com.argus.argus.models.AtendimentoPedagogico;
import br.com.argus.argus.models.Curriculo;
import br.com.argus.argus.models.Disciplina;
import br.com.argus.argus.models.Endereco;
import br.com.argus.argus.models.Funcionario;
import br.com.argus.argus.models.Matricula;
import br.com.argus.argus.models.Pessoa;
import br.com.argus.argus.models.Responsavel;
import br.com.argus.argus.models.Turma;
import br.com.argus.argus.models.Usuario;
import br.com.argus.argus.responses.Response;
import br.com.argus.argus.services.AlunoService;
import br.com.argus.argus.services.AtendimentoPedagodicoService;
import br.com.argus.argus.services.CurriculoService;
import br.com.argus.argus.services.DisciplinaService;
import br.com.argus.argus.services.EnderecoService;
import br.com.argus.argus.services.FuncionarioService;
import br.com.argus.argus.services.MatriculaService;
import br.com.argus.argus.services.PessoaService;
import br.com.argus.argus.services.ResponsavelService;
import br.com.argus.argus.services.TurmaService;
import br.com.argus.argus.services.UsuarioService;

@RestController
@RequestMapping("/api")
public class Controller {

	@Autowired
	private AlunoService alunoService;

	@Autowired
	private AtendimentoPedagodicoService atendimentoService;

	@Autowired
	private CurriculoService curriculoService;

	@Autowired
	private DisciplinaService disciplinaService;

	@Autowired
	private EnderecoService enderecoService;

	@Autowired
	private FuncionarioService funcionarioService;

	@Autowired
	private MatriculaService matriculaService;

	@Autowired
	private PessoaService pessoaService;

	@Autowired
	private ResponsavelService responsavelService;

	@Autowired
	private TurmaService turmaService;

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Object>> index() {
		List<Object> entidades = new ArrayList<>();

		List<Aluno> alunos = alunoService.findByAll();
		
		List<AtendimentoPedagogico> atendimentos = atendimentoService.findByAll();
		List<Curriculo> curriculos = curriculoService.findByAll();
		List<Disciplina> disciplinas = disciplinaService.findByAll();
		List<Endereco> enderecos = enderecoService.findByAll();
		List<Funcionario> funcionarios = funcionarioService.findByAll();
		List<Matricula> matriculas = matriculaService.findByAll();
		List<Pessoa> pessoas = pessoaService.findByAll();
		List<Responsavel> responsavels = responsavelService.findByAll();

		List<Turma> turmas = turmaService.findByAll();
		List<Usuario> usuarios = usuarioService.findByAll();

		entidades.add(alunos);
		entidades.add(atendimentos);
		entidades.add(curriculos);
		entidades.add(disciplinas);
		entidades.add(enderecos);
		entidades.add(funcionarios);
		entidades.add(matriculas);
		entidades.add(pessoas);
		entidades.add(responsavels);
		entidades.add(turmas);
		entidades.add(usuarios);

		return ResponseEntity.status(HttpStatus.OK).body(entidades);
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Response<Pessoa>> create(@Valid @RequestBody Pessoa pessoaDto, BindingResult result) {
		Response<Pessoa> response = new Response<Pessoa>();
		
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
				
		Pessoa obj;
		obj = this.pessoaService.save(pessoaDto);
		response.setData(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pessoaDto.getId()).toUri();
		return ResponseEntity.created(uri).body(response);

	}


}
