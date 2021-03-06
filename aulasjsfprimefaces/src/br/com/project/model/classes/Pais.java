package br.com.project.model.classes;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.envers.Audited;

import br.com.project.annotation.IdentificaCampoPesquisa;

@Audited
@Entity
@Table(name = "pais")
@SequenceGenerator(name = "pais_seq", sequenceName = "pais_seq", initialValue = 1, allocationSize = 1)
public class Pais implements Serializable {

	private static final long serialVersionUID = 1L;

	@IdentificaCampoPesquisa(descricaoCampo = "Código", campoConsulta = "pais_id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pais_seq")
	private Long pais_id;

	@IdentificaCampoPesquisa(descricaoCampo = "Nome", campoConsulta = "pais_nome", principal = 1)
	@Column(nullable = false, length = 80)
	private String pais_nome;

	@Column(nullable = true, length = 15)
	private String pais_sigla;

	@Version
	@Column(name = "versionNum")
	private int versionNum;

	public Long getpais_id() {
		return pais_id;
	}

	public void setpais_id(Long pais_id) {
		this.pais_id = pais_id;
	}

	public String getpais_nome() {
		return pais_nome;
	}

	public void setpais_nome(String pais_nome) {
		this.pais_nome = pais_nome;
	}

	public String getpais_sigla() {
		return pais_sigla;
	}

	public void setpais_sigla(String pais_sigla) {
		this.pais_sigla = pais_sigla;
	}

	public int getVersionNum() {
		return versionNum;
	}

	public void setVersionNum(int versionNum) {
		this.versionNum = versionNum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pais_id == null) ? 0 : pais_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pais other = (Pais) obj;
		if (pais_id == null) {
			if (other.pais_id != null)
				return false;
		} else if (!pais_id.equals(other.pais_id))
			return false;
		return true;
	}

}
