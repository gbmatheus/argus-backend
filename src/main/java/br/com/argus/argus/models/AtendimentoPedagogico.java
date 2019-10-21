package br.com.argus.argus.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

import br.com.argus.argus.enums.StatusAtendimento;

@Entity
@Table(name = "aten_ped")
public class AtendimentoPedagogico {
	
	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "det_atendimento", nullable = false, length = 255)
	private String detalheAtendimento;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private StatusAtendimento situcao = StatusAtendimento.AGENDADO;
	
	@JsonSerialize(using = DateSerializer.class)
	@Column(name = "data_atendimento", nullable = false)
	private Date dataAtendimento;
	
	@JsonSerialize(using = DateSerializer.class)
	@Column(name = "data_realizado")
	private Date dataRealizado;
	
	public AtendimentoPedagogico() {
	}

	public Long getId() {
		return id;
	}
	
	@NotBlank(message = "Informações sobre o atedimento são obrigatórias")
	@Size(min = 10, max = 255)
	public String getDetalheAtendimento() {
		return detalheAtendimento;
	}

	@NotNull(message = "Situação é uma informação necessaria")
	public StatusAtendimento getSitucao() {
		return situcao;
	}
	
	@NotNull(message = "Data do atendimento é obrigatório")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	public Date getDataAtendimento() {
		return dataAtendimento;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	public Date getDataRealizado() {
		return dataRealizado;
	}

	public void setDetalheAtendimento(String detalheAtendimento) {
		this.detalheAtendimento = detalheAtendimento;
	}

	public void setSitucao(StatusAtendimento situcao) {
		this.situcao = situcao;
	}

	public void setDataAtendimento(Date dataAtendimento) {
		this.dataAtendimento = dataAtendimento;
	}

	public void setDataRealizado(Date dataRealizado) {
		this.dataRealizado = dataRealizado;
	}
	
}
