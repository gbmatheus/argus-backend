package br.com.argus.argus.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.argus.argus.models.Responsavel;
import br.com.argus.argus.repositories.ResponsavelRepository;

@Service
public class ResponsavelService extends ServiceGeneric<Responsavel> {

	@Autowired
	ResponsavelRepository responsavelRepository;
	

	@Override
	public JpaRepository<Responsavel, Long> getRepository() {
		return responsavelRepository;
	}

	@Override
	@Transactional
	public Responsavel save(Responsavel objetoDto) {
		List<Responsavel> responsavels = findByAll();
<<<<<<< HEAD

		if (responsavels.size() != 0) {
			for (Responsavel r : responsavels) {
				if (r.getCpf().equalsIgnoreCase(objetoDto.getCpf())
						&& r.getPessoa().getRg().equalsIgnoreCase(objetoDto.getPessoa().getRg())) {
					System.out.println("Responsavel é " + r.getId() + " " + r.getPessoa().getId());
					return r;
				} else if (r.getCpf().equalsIgnoreCase(objetoDto.getCpf())
						^ r.getPessoa().getRg().equalsIgnoreCase(objetoDto.getPessoa().getRg()))
=======
		
		if(responsavels.size() != 0) {
			for (Responsavel r : responsavels) {
				if(r.getCpf().equalsIgnoreCase(objetoDto.getCpf())
						&& r.getPessoa().getRg().equalsIgnoreCase(objetoDto.getPessoa().getRg())
						) {
					System.out.println("Responsavel é "+ r.getId() +" "+ r.getPessoa().getId());
					return r;
				}else if(
						r.getCpf().equalsIgnoreCase(objetoDto.getCpf())
						^ r.getPessoa().getRg().equalsIgnoreCase(objetoDto.getPessoa().getRg())
						)
>>>>>>> refs/remotes/origin/master
					return null;
			}
		}
		return super.save(objetoDto);
	}
<<<<<<< HEAD

=======
	
>>>>>>> refs/remotes/origin/master
}
